package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Modelo;
import com.alon.spring.crud.resource.dto.OutputDtoConverter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ListModeloOutputConverter implements OutputDtoConverter<Page<Modelo>, ListModeloOutput> {

    @Autowired
    private ModeloEntityToModeloDtoConverter converter;
    
    @Override
    public ListModeloOutput convert(Page<Modelo> data) {
        List<ModeloDto> modelosDto = data.getContent()
                                         .stream()
                                         .map(user -> this.converter.convert(user))
                                         .collect(Collectors.toList());
        
        ListModeloOutput output = new ListModeloOutput();
        output.content = modelosDto;
        output.page = data.getNumber() + 1;
        output.pageSize = modelosDto.size();
        output.totalPages = data.getTotalPages();
        output.totalSize = data.getNumberOfElements();
        
        return output;
    }
    
}
