package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.spring.crud.resource.dto.ResourceDtoConverterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModeloResourceDtoConverterProvider implements ResourceDtoConverterProvider {

    @Autowired
    private ListModeloOutputConverter listConverter;
    
    @Autowired 
    private ModeloEntityToModeloDtoConverter entityToDtoConverter;
    
    @Autowired
    private CreateModeloInputConverter createInputConverter;
    
    @Autowired
    private UpdateModeloInputConverter updateInputConverter;
    
    @Override
    public ListModeloOutputConverter getListOutputDtoConverter() {
        return this.listConverter;
    }

    @Override
    public ModeloEntityToModeloDtoConverter getReadOutputDtoConverter() {
        return this.entityToDtoConverter;
    }

    @Override
    public CreateModeloInputConverter getCreateInputDtoConverter() {
        return this.createInputConverter;
    }

    @Override
    public ModeloEntityToModeloDtoConverter getCreateOutputDtoConverter() {
        return this.entityToDtoConverter;
    }

    @Override
    public UpdateModeloInputConverter getUpdateInputDtoConverter() {
        return this.updateInputConverter;
    }

    @Override
    public ModeloEntityToModeloDtoConverter getUpdateOutputDtoConverter() {
        return this.entityToDtoConverter;
    }
    
}
