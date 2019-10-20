/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alon.ficticiusclean.model.security;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author paulo
 */
@Entity
public class Role implements GrantedAuthority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleAuthority roleAuthority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleAuthority getRoleAuthority() {
        return roleAuthority;
    }

    public void setRoleAuthority(RoleAuthority roleAuthority) {
        this.roleAuthority = roleAuthority;
    }

    @Override
    public String getAuthority() {
        return this.roleAuthority.name();
    }
    
}
