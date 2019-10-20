package com.alon.ficticiusclean.service.domain;

import com.alon.ficticiusclean.model.domain.Montadora;
import com.alon.ficticiusclean.repository.domain.MontadoraRepository;
import com.alon.spring.crud.service.CrudService;
import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MontadoraService extends CrudService<Montadora, MontadoraRepository> {

    @Override
    public List<Sort.Order> getDefaultSort() {
        return Collections.singletonList(Sort.Order.asc("nome"));
    }
    
}
