package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.resource.core.dto.ResourceDtoConverterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VeiculoResourceDtoConverterProvider implements ResourceDtoConverterProvider {
    
    @Autowired
    private ListVeiculoOutputConverter listConverter;
    
    @Autowired
    private VeiculoEntityToVeiculoDtoConverter entityToDtoConverter;
    
    @Autowired
    private CreateVeiculoInputConverter createInputConverter;
    
    @Autowired
    private UpdateVeiculoInputConverter updateInputConverter;

    @Override
    public ListVeiculoOutputConverter getListOutputDtoConverter() {
        return this.listConverter;
    }

    @Override
    public VeiculoEntityToVeiculoDtoConverter getReadOutputDtoConverter() {
        return this.entityToDtoConverter;
    }

    @Override
    public CreateVeiculoInputConverter getCreateInputDtoConverter() {
        return this.createInputConverter;
    }

    @Override
    public VeiculoEntityToVeiculoDtoConverter getCreateOutputDtoConverter() {
        return this.entityToDtoConverter;
    }

    @Override
    public UpdateVeiculoInputConverter getUpdateInputDtoConverter() {
        return this.updateInputConverter;
    }

    @Override
    public VeiculoEntityToVeiculoDtoConverter getUpdateOutputDtoConverter() {
        return this.entityToDtoConverter;
    }
    
}
