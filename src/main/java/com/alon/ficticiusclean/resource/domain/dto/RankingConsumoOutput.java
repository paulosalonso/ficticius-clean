package com.alon.ficticiusclean.resource.domain.dto;

import com.alon.ficticiusclean.resource.core.dto.ListOutput;
import com.alon.ficticiusclean.service.domain.dto.ConsumoVeiculoDto;
import java.util.List;

public class RankingConsumoOutput extends ListOutput<ConsumoVeiculoDto> {

    public RankingConsumoOutput() {
    }

    public RankingConsumoOutput(List<ConsumoVeiculoDto> content, int page, int pageSize, int totalPages, int totalSize) {
        super(content, page, pageSize, totalPages, totalSize);
    }
    
}
