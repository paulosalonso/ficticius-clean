package com.alon.ficticiusclean.resource.domain;

import com.alon.ficticiusclean.resource.core.CrudResource;
import com.alon.ficticiusclean.resource.domain.dto.CreateMontadoraInput;
import com.alon.ficticiusclean.resource.domain.dto.MontadoraResourceDtoConverterProvider;
import com.alon.ficticiusclean.resource.domain.dto.UpdateMontadoraInput;
import com.alon.ficticiusclean.service.domain.MontadoraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/montadora")
public class MontadoraResource extends CrudResource<MontadoraService, 
                                                    CreateMontadoraInput, 
                                                    UpdateMontadoraInput,
                                                    MontadoraResourceDtoConverterProvider> {
    
}
