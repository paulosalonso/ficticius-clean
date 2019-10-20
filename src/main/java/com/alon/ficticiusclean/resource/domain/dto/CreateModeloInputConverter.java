package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Modelo;
import com.alon.ficticiusclean.repository.domain.MontadoraRepository;
import com.alon.spring.crud.resource.dto.InputDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateModeloInputConverter implements InputDtoConverter<CreateModeloInput, Modelo> {

    @Autowired
    private MontadoraRepository montadoraRepository;
    
    @Override
    public Modelo convert(CreateModeloInput input) {
        Modelo modelo = new Modelo();
        modelo.setMontadora(this.montadoraRepository.getOne(input.montadoraId));
        modelo.setNome(input.nome);
        
        return modelo;
    }
    
}
