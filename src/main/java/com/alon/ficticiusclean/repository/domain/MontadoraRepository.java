package com.alon.ficticiusclean.repository.domain;

import com.alon.ficticiusclean.model.domain.Montadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MontadoraRepository extends JpaRepository<Montadora, Long>, JpaSpecificationExecutor<Montadora> {
    
}
