package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.spring.crud.resource.dto.InputDto;

public class RankingConsumoInput implements InputDto {
    
    public double precoCombustivel;
    public int distanciaTotalCidadeKm;
    public int distanciaTotalRodoviaKm;

    public RankingConsumoInput() {
    }

    public RankingConsumoInput(double precoCombustivel, int distanciaTotalCidadeKm, int distanciaTotalRodoviaKm) {
        this.precoCombustivel = precoCombustivel;
        this.distanciaTotalCidadeKm = distanciaTotalCidadeKm;
        this.distanciaTotalRodoviaKm = distanciaTotalRodoviaKm;
    }

    public double getPrecoCombustivel() {
        return precoCombustivel;
    }

    public void setPrecoCombustivel(double precoCombustivel) {
        this.precoCombustivel = precoCombustivel;
    }

    public int getDistanciaTotalCidadeKm() {
        return distanciaTotalCidadeKm;
    }

    public void setDistanciaTotalCidadeKm(int distanciaTotalCidadeKm) {
        this.distanciaTotalCidadeKm = distanciaTotalCidadeKm;
    }

    public int getDistanciaTotalRodoviaKm() {
        return distanciaTotalRodoviaKm;
    }

    public void setDistanciaTotalRodoviaKm(int distanciaTotalRodoviaKm) {
        this.distanciaTotalRodoviaKm = distanciaTotalRodoviaKm;
    }
}
