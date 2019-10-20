package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Veiculo;
import com.alon.spring.crud.resource.dto.OutputDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VeiculoEntityToVeiculoDtoConverter implements OutputDtoConverter<Veiculo, VeiculoDto> {

    @Autowired
    private ModeloEntityToModeloDtoConverter modeloEntityToDtoConverter;
    
    @Override
    public VeiculoDto convert(Veiculo data) {
        VeiculoDto veiculoDto = new VeiculoDto();
        veiculoDto.consumoCidadeKmL = data.getConsumoCidadeKmL();
        veiculoDto.consumoRodoviaKmL = data.getConsumoRodoviaKmL();
        veiculoDto.dataFabricacao = data.getDataFabricacao();
        veiculoDto.id = data.getId();
        veiculoDto.modelo = this.modeloEntityToDtoConverter.convert(data.getModelo());
        veiculoDto.nome = data.getNome();
        
        return veiculoDto;
    }
    
}
