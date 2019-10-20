package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.spring.crud.resource.dto.InputDto;

public class UpdateModeloInput implements InputDto {
    
    public Long id;
    public String nome;
    public Long montadoraId;

    public UpdateModeloInput() {
    }

    public UpdateModeloInput(Long id, String nome, Long montadoraId) {
        this.id = id;
        this.nome = nome;
        this.montadoraId = montadoraId;
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

    public Long getMontadoraId() {
        return montadoraId;
    }

    public void setMontadoraId(Long montadoraId) {
        this.montadoraId = montadoraId;
    }
    
}
