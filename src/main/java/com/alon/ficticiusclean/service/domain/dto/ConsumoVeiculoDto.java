package com.alon.ficticiusclean.service.domain.dto;

public class ConsumoVeiculoDto {

    public String nome;
    public String marca;
    public String modelo;
    public Integer ano;
    public Double consumoCombustivelL;
    public Double valorTotalCombustivel;

    public ConsumoVeiculoDto() {
    }

    public ConsumoVeiculoDto(String nome, String marca, String modelo, int ano, Double consumoCombustivelL, Double valorTotalCombustivel) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.consumoCombustivelL = consumoCombustivelL;
        this.valorTotalCombustivel = valorTotalCombustivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Double getConsumoCombustivelL() {
        return consumoCombustivelL;
    }

    public void setConsumoCombustivelL(Double consumoCombustivelL) {
        this.consumoCombustivelL = consumoCombustivelL;
    }

    public Double getValorTotalCombustivel() {
        return valorTotalCombustivel;
    }

    public void setValorTotalCombustivel(Double valorTotalCombustivel) {
        this.valorTotalCombustivel = valorTotalCombustivel;
    }
    
}
