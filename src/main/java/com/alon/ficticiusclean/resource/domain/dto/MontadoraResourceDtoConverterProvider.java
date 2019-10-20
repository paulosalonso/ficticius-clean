package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.resource.core.dto.ResourceDtoConverterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MontadoraResourceDtoConverterProvider implements ResourceDtoConverterProvider {

    @Autowired
    private ListMontadoraOutputConverter listConverter;
    
    @Autowired
    private MontadoraEntityToMontadoraDtoConverter entityToDtoConverter;
    
    @Autowired
    private CreateMontadoraInputConverter createInputConverter;
    
    @Autowired
    private UpdateMontadoraInputConverter updateInputConverter;
    
    @Override
    public ListMontadoraOutputConverter getListOutputDtoConverter() {
        return this.listConverter;
    }

    @Override
    public MontadoraEntityToMontadoraDtoConverter getReadOutputDtoConverter() {
        return this.entityToDtoConverter;
    }

    @Override
    public CreateMontadoraInputConverter getCreateInputDtoConverter() {
        return this.createInputConverter;
    }

    @Override
    public MontadoraEntityToMontadoraDtoConverter getCreateOutputDtoConverter() {
        return this.entityToDtoConverter;
    }

    @Override
    public UpdateMontadoraInputConverter getUpdateInputDtoConverter() {
        return this.updateInputConverter;
    }

    @Override
    public MontadoraEntityToMontadoraDtoConverter getUpdateOutputDtoConverter() {
        return this.entityToDtoConverter;
    }
    
}
