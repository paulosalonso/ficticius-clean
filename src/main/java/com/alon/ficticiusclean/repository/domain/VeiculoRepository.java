package com.alon.ficticiusclean.repository.domain;

import com.alon.ficticiusclean.model.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>, JpaSpecificationExecutor<Veiculo> {
    
}
