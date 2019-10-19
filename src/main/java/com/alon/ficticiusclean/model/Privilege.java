package com.alon.ficticiusclean.model;

import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Privilege {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String description;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "PrivilegeRole",
            joinColumns = @JoinColumn(name = "privilegeId", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "roleId", nullable = false)
    )
    @Size(min = 1, message = "A privilege must have at least one role.")
    private List<Role> roles;

    public Privilege() {
        this.roles = Collections.emptyList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
}
