package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Modelo;
import com.alon.ficticiusclean.model.domain.Veiculo;
import com.alon.ficticiusclean.repository.domain.ModeloRepository;
import com.alon.spring.crud.resource.dto.InputDtoConverter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateVeiculoInputConverter implements InputDtoConverter<CreateVeiculoInput, Veiculo> {

    @Autowired
    private ModeloRepository modeloRepository;
    
    @Override
    public Veiculo convert(CreateVeiculoInput input) {
        Optional<Modelo> modeloOpt = this.modeloRepository.findById(input.modeloId);
        
        if (modeloOpt.isEmpty())
            throw new RuntimeException(String.format("O modelo informado não existe (id: %d).", input.modeloId));
        
        Veiculo veiculo = new Veiculo();
        veiculo.setConsumoCidadeKmL(input.consumoCidadeKmL);
        veiculo.setConsumoRodoviaKmL(input.consumoRodoviaKmL);
        veiculo.setDataFabricacao(input.dataFabricacao);
        veiculo.setModelo(modeloOpt.get());
        veiculo.setNome(input.nome);
        
        return veiculo;
    }
    
}
