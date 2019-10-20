package com.alon.ficticiusclean.resource.domain.dto;

public class ModeloDto {
    
    public Long id;
    public String nome;
    public MontadoraDto montadora;

    public ModeloDto() {
    }

    public ModeloDto(Long id, String nome, MontadoraDto montadora) {
        this.id = id;
        this.nome = nome;
        this.montadora = montadora;
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

    public MontadoraDto getMontadora() {
        return montadora;
    }

    public void setMontadora(MontadoraDto montadora) {
        this.montadora = montadora;
    }
    
}
