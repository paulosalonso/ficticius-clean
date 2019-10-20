package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Modelo;
import com.alon.ficticiusclean.model.domain.Montadora;
import com.alon.ficticiusclean.repository.domain.MontadoraRepository;
import com.alon.spring.crud.resource.dto.InputDtoConverter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateModeloInputConverter implements InputDtoConverter<UpdateModeloInput, Modelo> {

    @Autowired
    private MontadoraRepository montadoraRepository;
    
    @Override
    public Modelo convert(UpdateModeloInput input) {
        Optional<Montadora> montadoraOpt = this.montadoraRepository.findById(input.montadoraId);
        
        if (montadoraOpt.isEmpty())
            throw new RuntimeException(String.format("A montadora informada não existe (id: %d).", input.montadoraId));
        
        Modelo modelo = new Modelo();
        modelo.setId(input.id);
        modelo.setMontadora(montadoraOpt.get());
        modelo.setNome(input.nome);
        
        return modelo;
    }
    
}
