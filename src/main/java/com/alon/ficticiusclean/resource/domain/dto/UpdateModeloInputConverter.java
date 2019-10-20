package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Modelo;
import com.alon.ficticiusclean.repository.domain.MontadoraRepository;
import com.alon.ficticiusclean.resource.core.dto.InputDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateModeloInputConverter implements InputDtoConverter<UpdateModeloInput, Modelo> {

    @Autowired
    private MontadoraRepository montadoraRepository;
    
    @Override
    public Modelo convert(UpdateModeloInput input) {
        Modelo modelo = new Modelo();
        modelo.setId(input.id);
        modelo.setMontadora(this.montadoraRepository.getOne(input.montadoraId));
        modelo.setNome(input.nome);
        
        return modelo;
    }
    
}
