package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.spring.crud.resource.dto.ListOutput;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ListVeiculoOutput extends ListOutput<VeiculoDto> {

    public ListVeiculoOutput() {
    }

    public ListVeiculoOutput(List<VeiculoDto> content, int page, int pageSize, int totalPages, int totalSize) {
        super(content, page, pageSize, totalPages, totalSize);
    }
    
}
