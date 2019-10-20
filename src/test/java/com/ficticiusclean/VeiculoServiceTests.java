package com.ficticiusclean;

import com.alon.ficticiusclean.model.domain.Modelo;
import com.alon.ficticiusclean.model.domain.Montadora;
import com.alon.ficticiusclean.model.domain.Veiculo;
import com.alon.ficticiusclean.service.domain.VeiculoService;
import com.alon.ficticiusclean.service.domain.dto.ConsumoVeiculoDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class VeiculoServiceTests extends FicticiusCleanApplicationTests {
    
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    private VeiculoService service;
    
    @Test
    public void maisEconomicoNaCidade() {
        double precoCombustivel = 4;
        int distanciaTotalCidadeKm = 100;
        int distanciaTotalRodoviaKm = 0;
        
        List<ConsumoVeiculoDto> ranking = this.service.calculaRankingConsumo(precoCombustivel, distanciaTotalCidadeKm, distanciaTotalRodoviaKm);
        
        ConsumoVeiculoDto maisEconomico = ranking.get(0);
        
        String modeloEsperado = "Strada";
        double consumoCombustivelEsperado = 9.09;
        double valorCombustivelEsperado = 36.36;
        
        assertEquals(modeloEsperado, maisEconomico.modelo);
        assertEquals(maisEconomico.consumoCombustivelL, consumoCombustivelEsperado, 0.1);
        assertEquals(maisEconomico.valorTotalCombustivel, valorCombustivelEsperado, 0.1);
    }
    
    @Test
    public void maisEconomicoNaRodovia() {
        double precoCombustivel = 4;
        int distanciaTotalCidadeKm = 0;
        int distanciaTotalRodoviaKm = 100;
        
        List<ConsumoVeiculoDto> ranking = this.service.calculaRankingConsumo(precoCombustivel, distanciaTotalCidadeKm, distanciaTotalRodoviaKm);
        
        ConsumoVeiculoDto maisEconomico = ranking.get(0);
        
        String modeloEsperado = "Toro";
        double consumoCombustivelEsperado = 6.25;
        double valorCombustivelEsperado = 25;
        
        assertEquals(modeloEsperado, maisEconomico.modelo);
        assertEquals(maisEconomico.consumoCombustivelL, consumoCombustivelEsperado, 0.1);
        assertEquals(maisEconomico.valorTotalCombustivel, valorCombustivelEsperado, 0.1);
    }
    
    @Before
    public void init() {    
        this.service = spy(this.service);
        when(this.service.list(0, Integer.MAX_VALUE)).thenReturn(this.provideVeiculosPage());
    }
    
    private Page<Veiculo> provideVeiculosPage() {
        List<Veiculo> veiculos = Arrays.asList(this.provideVeiculoA(), this.provideVeiculoB());
        Pageable pageable = PageRequest.of(1, 2);
        
        Page<Veiculo> page = new PageImpl<>(veiculos, pageable, 2);
        
        return page;
    }
    
    private Veiculo provideVeiculoA() {
        Montadora montadora = new Montadora();
        montadora.setId(1L);
        montadora.setNome("Fiat");
        
        Modelo modelo = new Modelo();
        modelo.setId(1L);
        modelo.setNome("Toro");
        modelo.setMontadora(montadora);
        
        Veiculo veiculo = new Veiculo();
        veiculo.setId(1L);
        veiculo.setModelo(modelo);
        veiculo.setConsumoCidadeKmL(9);
        veiculo.setConsumoRodoviaKmL(16);
        
        try {
            veiculo.setDataFabricacao(DATE_FORMAT.parse("01-01-2018"));
        } catch (ParseException ex) {
            // Ambiente controlado. Erro não ocorrerá.
        }
        
        return veiculo;
    }
    
    private Veiculo provideVeiculoB() {
        Montadora montadora = new Montadora();
        montadora.setId(1L);
        montadora.setNome("Fiat");
        
        Modelo modelo = new Modelo();
        modelo.setId(1L);
        modelo.setNome("Strada");
        modelo.setMontadora(montadora);
        
        Veiculo veiculo = new Veiculo();
        veiculo.setId(1L);
        veiculo.setModelo(modelo);
        veiculo.setConsumoCidadeKmL(11);
        veiculo.setConsumoRodoviaKmL(14);
        
        try {
            veiculo.setDataFabricacao(DATE_FORMAT.parse("01-01-2016"));
        } catch (ParseException ex) {
            // Ambiente controlado. Erro não ocorrerá.
        }
        
        return veiculo;
    }
    
}
