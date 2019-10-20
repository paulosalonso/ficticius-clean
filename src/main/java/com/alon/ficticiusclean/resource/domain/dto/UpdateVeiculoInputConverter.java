package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Veiculo;
import com.alon.ficticiusclean.repository.domain.ModeloRepository;
import com.alon.spring.crud.resource.dto.InputDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateVeiculoInputConverter implements InputDtoConverter<UpdateVeiculoInput, Veiculo> {
    
    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public Veiculo convert(UpdateVeiculoInput input) {
        Veiculo veiculo = new Veiculo();
        veiculo.setConsumoCidadeKmL(input.consumoCidadeKmL);
        veiculo.setConsumoRodoviaKmL(input.consumoRodoviaKmL);
        veiculo.setDataFabricacao(input.dataFabricacao);
        veiculo.setId(input.id);
        veiculo.setModelo(this.modeloRepository.getOne(input.modeloId));
        veiculo.setNome(input.nome);
        
        return veiculo;
    }
    
}
