package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.model.domain.Montadora;
import com.alon.ficticiusclean.resource.core.dto.OutputDtoConverter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ListMontadoraOutputConverter implements OutputDtoConverter<Page<Montadora>, ListMontadoraOutput> {

    @Autowired
    private MontadoraEntityToMontadoraDtoConverter converter;
    
    @Override
    public ListMontadoraOutput convert(Page<Montadora> data) {
        List<MontadoraDto> montadorasDto = data.getContent()
                                               .stream()
                                               .map(user -> this.converter.convert(user))
                                               .collect(Collectors.toList());
        
        ListMontadoraOutput output = new ListMontadoraOutput();
        output.content = montadorasDto;
        output.page = data.getNumber() + 1;
        output.pageSize = montadorasDto.size();
        output.totalPages = data.getTotalPages();
        output.totalSize = data.getNumberOfElements();
        
        return output;
    }
    
}
