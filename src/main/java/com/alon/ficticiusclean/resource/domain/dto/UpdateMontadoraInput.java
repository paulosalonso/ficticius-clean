package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.resource.core.dto.InputDto;

public class UpdateMontadoraInput implements InputDto {
    
    public Long id;
    public String nome;

    public UpdateMontadoraInput() {
    }

    public UpdateMontadoraInput(Long id, String nome) {
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
