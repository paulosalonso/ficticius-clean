package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Montadora;
import com.alon.ficticiusclean.resource.core.dto.InputDtoConverter;
import org.springframework.stereotype.Component;

@Component
public class CreateMontadoraInputConverter implements InputDtoConverter<CreateMontadoraInput, Montadora> {

    @Override
    public Montadora convert(CreateMontadoraInput input) {
        Montadora montadora = new Montadora();
        montadora.setNome(input.nome);
        
        return montadora;
    }
    
}
