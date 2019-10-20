package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.spring.crud.resource.dto.InputDto;

public class CreateMontadoraInput implements InputDto {
    
    public String nome;

    public CreateMontadoraInput() {
    }

    public CreateMontadoraInput(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
