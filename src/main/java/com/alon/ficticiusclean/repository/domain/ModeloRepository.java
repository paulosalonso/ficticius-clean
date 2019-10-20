package com.alon.ficticiusclean.repository.domain;

import com.alon.ficticiusclean.model.domain.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ModeloRepository extends JpaRepository<Modelo, Long>, JpaSpecificationExecutor<Modelo> {
    
}
