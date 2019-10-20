package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Montadora;
import com.alon.spring.crud.resource.dto.InputDtoConverter;
import org.springframework.stereotype.Component;

@Component
public class UpdateMontadoraInputConverter implements InputDtoConverter<UpdateMontadoraInput, Montadora> {

    @Override
    public Montadora convert(UpdateMontadoraInput input) {
        Montadora montadora = new Montadora();
        montadora.setId(input.id);
        montadora.setNome(input.nome);
        
        return montadora;
    }
    
}
