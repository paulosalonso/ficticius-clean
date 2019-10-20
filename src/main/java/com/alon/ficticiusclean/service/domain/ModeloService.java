package com.alon.ficticiusclean.service.domain;

import com.alon.ficticiusclean.model.domain.Modelo;
import com.alon.ficticiusclean.repository.domain.ModeloRepository;
import com.alon.spring.crud.service.CrudService;
import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ModeloService extends CrudService<Modelo, ModeloRepository> {

    @Override
    public List<Sort.Order> getDefaultSort() {
        return Collections.singletonList(Sort.Order.asc("nome"));
    }
    
}
