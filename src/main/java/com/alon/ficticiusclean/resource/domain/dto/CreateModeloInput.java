package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.resource.core.dto.InputDto;

public class CreateModeloInput implements InputDto {
    
    public String nome;
    public Long montadoraId;

    public CreateModeloInput() {
    }

    public CreateModeloInput(String nome, Long montadoraId) {
        this.nome = nome;
        this.montadoraId = montadoraId;
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
