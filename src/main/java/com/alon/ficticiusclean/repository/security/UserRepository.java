/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alon.ficticiusclean.repository.security;

import com.alon.ficticiusclean.model.security.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author paulo
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    
    public boolean existsByUsername(String username);
    
    public Optional<User> findByUsername(String username);
    
}
