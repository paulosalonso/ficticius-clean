package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.resource.core.dto.InputDto;
import java.util.Date;

public class UpdateVeiculoInput implements InputDto {
    
    public Long id;
    public String nome;
    public Long modeloId;    
    public Date dataFabricacao;
    public int consumoCidadeKmL;
    public int consumoRodoviaKmL;

    public UpdateVeiculoInput() {
    }

    public UpdateVeiculoInput(Long id, String nome, Long modeloId, Date dataFabricacao, int consumoCidadeKmL, int consumoRodoviaKmL) {
        this.id = id;
        this.nome = nome;
        this.modeloId = modeloId;
        this.dataFabricacao = dataFabricacao;
        this.consumoCidadeKmL = consumoCidadeKmL;
        this.consumoRodoviaKmL = consumoRodoviaKmL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public int getConsumoCidadeKmL() {
        return consumoCidadeKmL;
    }

    public void setConsumoCidadeKmL(int consumoCidadeKmL) {
        this.consumoCidadeKmL = consumoCidadeKmL;
    }

    public int getConsumoRodoviaKmL() {
        return consumoRodoviaKmL;
    }

    public void setConsumoRodoviaKmL(int consumoRodoviaKmL) {
        this.consumoRodoviaKmL = consumoRodoviaKmL;
    }
}
