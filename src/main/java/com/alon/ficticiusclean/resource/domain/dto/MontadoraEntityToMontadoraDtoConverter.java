package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Montadora;
import com.alon.ficticiusclean.resource.core.dto.OutputDtoConverter;
import org.springframework.stereotype.Component;

@Component
public class MontadoraEntityToMontadoraDtoConverter implements OutputDtoConverter<Montadora, MontadoraDto> {

    @Override
    public MontadoraDto convert(Montadora data) {
        MontadoraDto montadora = new MontadoraDto();
        montadora.id = data.getId();
        montadora.nome = data.getNome();
        
        return montadora;
    }
    
}
