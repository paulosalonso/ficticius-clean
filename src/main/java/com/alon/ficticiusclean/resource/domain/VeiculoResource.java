package com.alon.ficticiusclean.resource.domain;

import com.alon.ficticiusclean.resource.core.CrudResource;
import com.alon.ficticiusclean.resource.domain.dto.CreateVeiculoInput;
import com.alon.ficticiusclean.resource.domain.dto.RankingConsumoInput;
import com.alon.ficticiusclean.resource.domain.dto.RankingConsumoOutput;
import com.alon.ficticiusclean.resource.domain.dto.UpdateVeiculoInput;
import com.alon.ficticiusclean.resource.domain.dto.VeiculoResourceDtoConverterProvider;
import com.alon.ficticiusclean.service.domain.VeiculoService;
import com.alon.ficticiusclean.service.domain.dto.ConsumoVeiculoDto;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo")
public class VeiculoResource extends CrudResource<VeiculoService, 
                                                  CreateVeiculoInput, 
                                                  UpdateVeiculoInput, 
                                                  VeiculoResourceDtoConverterProvider> {
    
    @PostMapping("rankingConsumo")
    public RankingConsumoOutput rankingConsumo(@RequestBody RankingConsumoInput input) {
        List<ConsumoVeiculoDto> ranking = this.service
                                              .calculaRankingConsumo(input.precoCombustivel, 
                                                                     input.distanciaTotalCidadeKm, 
                                                                     input.distanciaTotalRodoviaKm);
        
        return this.buildRakingConsumoOutput(ranking);
    }
    
    private RankingConsumoOutput buildRakingConsumoOutput(List<ConsumoVeiculoDto> ranking) {
        RankingConsumoOutput rankingOutput = new RankingConsumoOutput();
        rankingOutput.content = ranking;
        rankingOutput.page = 1;
        rankingOutput.pageSize = ranking.size();
        rankingOutput.totalPages = 1;
        rankingOutput.totalSize = ranking.size();
        
        return rankingOutput;
    }
}
