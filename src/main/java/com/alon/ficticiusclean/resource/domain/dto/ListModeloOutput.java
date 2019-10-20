package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.resource.core.dto.ListOutput;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ListModeloOutput extends ListOutput<ModeloDto> {

    public ListModeloOutput() {
    }

    public ListModeloOutput(List<ModeloDto> content, int page, int pageSize, int totalPages, int totalSize) {
        super(content, page, pageSize, totalPages, totalSize);
    }
    
}
