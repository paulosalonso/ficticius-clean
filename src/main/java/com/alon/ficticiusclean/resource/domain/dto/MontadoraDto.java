package com.alon.ficticiusclean.resource.domain.dto;

public class MontadoraDto {
    
    public Long id;
    public String nome;

    public MontadoraDto() {
    }

    public MontadoraDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
    
}
