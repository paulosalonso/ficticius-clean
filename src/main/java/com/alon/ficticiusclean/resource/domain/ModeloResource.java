package com.alon.ficticiusclean.resource.domain;

import com.alon.ficticiusclean.resource.domain.dto.CreateModeloInput;
import com.alon.ficticiusclean.resource.domain.dto.ModeloResourceDtoConverterProvider;
import com.alon.ficticiusclean.resource.domain.dto.UpdateModeloInput;
import com.alon.ficticiusclean.service.domain.ModeloService;
import com.alon.spring.crud.resource.CrudResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modelo")
public class ModeloResource extends CrudResource<ModeloService, 
                                                 CreateModeloInput, 
                                                 UpdateModeloInput, 
                                                 ModeloResourceDtoConverterProvider> {
    
}
