package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Veiculo;
import com.alon.spring.crud.resource.dto.OutputDtoConverter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
class ListVeiculoOutputConverter implements OutputDtoConverter<Page<Veiculo>, ListVeiculoOutput> {
    
    @Autowired
    private VeiculoEntityToVeiculoDtoConverter converter;
    
    @Override
    public ListVeiculoOutput convert(Page<Veiculo> data) {
        List<VeiculoDto> veiculosDto = data.getContent()
                                               .stream()
                                               .map(user -> this.converter.convert(user))
                                               .collect(Collectors.toList());
        
        ListVeiculoOutput output = new ListVeiculoOutput();
        output.content = veiculosDto;
        output.page = data.getNumber() + 1;
        output.pageSize = veiculosDto.size();
        output.totalPages = data.getTotalPages();
        output.totalSize = data.getNumberOfElements();
        
        return output;
    }
    
}
