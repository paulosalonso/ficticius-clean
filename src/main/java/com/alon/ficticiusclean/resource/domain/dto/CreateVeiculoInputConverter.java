package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Veiculo;
import com.alon.ficticiusclean.repository.domain.ModeloRepository;
import com.alon.ficticiusclean.resource.core.dto.InputDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateVeiculoInputConverter implements InputDtoConverter<CreateVeiculoInput, Veiculo> {

    @Autowired
    private ModeloRepository modeloRepository;
    
    @Override
    public Veiculo convert(CreateVeiculoInput input) {
        Veiculo veiculo = new Veiculo();
        veiculo.setConsumoCidadeKmL(input.consumoCidadeKmL);
        veiculo.setConsumoRodoviaKmL(input.consumoRodoviaKmL);
        veiculo.setDataFabricacao(input.dataFabricacao);
        veiculo.setModelo(this.modeloRepository.getOne(input.modeloId));
        veiculo.setNome(input.nome);
        
        return veiculo;
    }
    
}
