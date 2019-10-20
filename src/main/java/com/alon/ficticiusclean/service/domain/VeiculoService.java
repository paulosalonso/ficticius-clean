package com.alon.ficticiusclean.service.domain;

import com.alon.ficticiusclean.model.domain.Veiculo;
import com.alon.ficticiusclean.repository.domain.VeiculoRepository;
import com.alon.ficticiusclean.service.core.CrudService;
import com.alon.ficticiusclean.service.domain.dto.ConsumoVeiculoDto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService extends CrudService<Veiculo, VeiculoRepository> {
    
    private static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");
    
    @Override
    public List<Sort.Order> getDefaultSort() {
        return Collections.singletonList(Sort.Order.asc("nome"));
    }
    
    public List<ConsumoVeiculoDto> calculaRankingConsumo(
            double precoCombustivel,
            int distanciaTotalCidadeKm,
            int distanciaTotalRodoviaKm
    ) {
        int page = 0;
        int size = Integer.MAX_VALUE;
        
        List<Veiculo> veiculos = this.list(page, size).getContent();
        
        List<ConsumoVeiculoDto> ranking = 
                veiculos.stream()
                        .map(veiculo -> this.calculaConsumoVeiculo(veiculo, 
                                                                   precoCombustivel, 
                                                                   distanciaTotalCidadeKm, 
                                                                   distanciaTotalRodoviaKm))
                                            .collect(Collectors.toList());
        
        return this.ordenarRanking(ranking);
    }
    
    private ConsumoVeiculoDto calculaConsumoVeiculo(
            Veiculo veiculo,
            double precoCombustivel,
            int distanciaTotalCidadeKm,
            int distanciaTotalRodoviaKm
    ) {
        ConsumoVeiculoDto consumoVeiculoDto = new ConsumoVeiculoDto();
        
        double consumoCidade = distanciaTotalCidadeKm / veiculo.getConsumoCidadeKmL();
        double consumoRodovia = distanciaTotalRodoviaKm / veiculo.getConsumoRodoviaKmL();
        double consumoTotal = consumoCidade + consumoRodovia;
        double valorTotal = BigDecimal.valueOf(consumoTotal * precoCombustivel)
                                      .setScale(2, RoundingMode.HALF_EVEN)
                                      .doubleValue();
        
        consumoVeiculoDto.nome = veiculo.getNome();
        consumoVeiculoDto.marca = veiculo.getModelo().getMontadora().getNome();
        consumoVeiculoDto.modelo = veiculo.getModelo().getNome();
        consumoVeiculoDto.ano = this.extraiAnoFabricacao(veiculo.getDataFabricacao());
        consumoVeiculoDto.consumoCombustivelL = (int) consumoTotal;
        consumoVeiculoDto.valorTotalCombustivel = valorTotal;
        
        return consumoVeiculoDto;
    }
    
    private int extraiAnoFabricacao(Date dataFabricacao) {
        String ano = YEAR_FORMAT.format(dataFabricacao);
        return Integer.valueOf(ano);
    }
    
    private List<ConsumoVeiculoDto> ordenarRanking(List<ConsumoVeiculoDto> ranking) {
        ranking.sort((veiculoA, veiculoB) -> veiculoA.valorTotalCombustivel
                                                     .compareTo(veiculoB.getValorTotalCombustivel()));
        
        return ranking;
    }
    
}
