package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.service.domain.dto.ConsumoVeiculoDto;
import com.alon.spring.crud.resource.dto.ListOutput;
import java.util.List;

public class RankingConsumoOutput extends ListOutput<ConsumoVeiculoDto> {

    public RankingConsumoOutput() {
    }

    public RankingConsumoOutput(List<ConsumoVeiculoDto> content, int page, int pageSize, int totalPages, int totalSize) {
        super(content, page, pageSize, totalPages, totalSize);
    }
    
}
