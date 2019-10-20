package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Modelo;
import com.alon.spring.crud.resource.dto.OutputDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ModeloEntityToModeloDtoConverter implements OutputDtoConverter<Modelo, ModeloDto> {

    @Autowired
    private MontadoraEntityToMontadoraDtoConverter montadoraEntityToDtoConverter;
    
    @Override
    public ModeloDto convert(Modelo data) {
        ModeloDto modeloDto = new ModeloDto();
        modeloDto.id = data.getId();
        modeloDto.montadora = this.montadoraEntityToDtoConverter.convert(data.getMontadora());
        modeloDto.nome = data.getNome();
        
        return modeloDto;
    }
    
}
