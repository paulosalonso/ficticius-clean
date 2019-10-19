package com.alon.ficticiusclean.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "UserEntity") // User is a SQL reserved keyword
public class User implements UserDetails, BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(unique = true)
    private String username;
    
    @NotBlank
    private String password;
    
    private boolean active;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserPrivilege",
            joinColumns = @JoinColumn(name = "userId", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "privilegeId", nullable = false)
    )
    private List<Privilege> privileges;

    public User() {
        this.active = true;
        this.privileges = Collections.emptyList();
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public List<Role> getAuthorities() {
        return this.privileges
                   .stream()
                   .map(privilege -> privilege.getRoles())
                   .flatMap(Collection::stream)
                   .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
    
}