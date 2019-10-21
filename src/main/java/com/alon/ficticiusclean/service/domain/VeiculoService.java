package com.alon.ficticiusclean.service.domain;

import com.alon.ficticiusclean.model.domain.Veiculo;
import com.alon.ficticiusclean.repository.domain.VeiculoRepository;
import com.alon.ficticiusclean.service.domain.dto.ConsumoVeiculoDto;
import com.alon.spring.crud.service.CrudService;
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
        
        return veiculos.stream()
                       .map(veiculo -> this.calculaConsumoVeiculo(veiculo, 
                                                                  precoCombustivel, 
                                                                  distanciaTotalCidadeKm, 
                                                                  distanciaTotalRodoviaKm))
                       .sorted(this::rankingSort)
                       .collect(Collectors.toList());
    }
    
    private ConsumoVeiculoDto calculaConsumoVeiculo(
            Veiculo veiculo,
            double precoCombustivel,
            double distanciaTotalCidadeKm,
            double distanciaTotalRodoviaKm
    ) {        
        double consumoCidade = distanciaTotalCidadeKm / veiculo.getConsumoCidadeKmL();
        double consumoRodovia = distanciaTotalRodoviaKm / veiculo.getConsumoRodoviaKmL();
        double consumoTotal = BigDecimal.valueOf(consumoCidade + consumoRodovia)
                                        .setScale(2, RoundingMode.HALF_EVEN)
                                        .doubleValue();
        double valorTotal = BigDecimal.valueOf(consumoTotal * precoCombustivel)
                                      .setScale(2, RoundingMode.HALF_EVEN)
                                      .doubleValue();
        
        ConsumoVeiculoDto consumoVeiculoDto = new ConsumoVeiculoDto();
        consumoVeiculoDto.nome = veiculo.getNome();
        consumoVeiculoDto.marca = veiculo.getModelo().getMontadora().getNome();
        consumoVeiculoDto.modelo = veiculo.getModelo().getNome();
        consumoVeiculoDto.ano = this.extraiAnoFabricacao(veiculo.getDataFabricacao());
        consumoVeiculoDto.consumoCombustivelL = consumoTotal;
        consumoVeiculoDto.valorTotalCombustivel = valorTotal;
        
        return consumoVeiculoDto;
    }
    
    private int extraiAnoFabricacao(Date dataFabricacao) {
        String ano = YEAR_FORMAT.format(dataFabricacao);
        return Integer.valueOf(ano);
    }
    
    private int rankingSort(ConsumoVeiculoDto veiculoA, ConsumoVeiculoDto veiculoB) {
        return veiculoA.valorTotalCombustivel
                       .compareTo(veiculoB.getValorTotalCombustivel());
    }
    
}
