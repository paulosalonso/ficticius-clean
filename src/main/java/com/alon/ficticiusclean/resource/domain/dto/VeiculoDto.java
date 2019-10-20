package com.alon.ficticiusclean.resource.domain.dto;

import java.util.Date;

public class VeiculoDto {
    
    public Long id;
    public String nome;
    public ModeloDto modelo;
    public Date dataFabricacao;
    public int consumoCidadeKmL;
    public int consumoRodoviaKmL;

    public VeiculoDto() {
    }

    public VeiculoDto(Long id, String nome, ModeloDto modelo, Date dataFabricacao, int consumoCidadeKmL, int consumoRodoviaKmL) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
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

    public ModeloDto getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDto modelo) {
        this.modelo = modelo;
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
