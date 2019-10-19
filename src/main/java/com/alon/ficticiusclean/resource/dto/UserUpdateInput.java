package com.alon.ficticiusclean.resource.dto;

public class UserUpdateInput implements InputDto {
    
    public Long id;
    public boolean active;

    public UserUpdateInput() {
    }

    public UserUpdateInput(Long id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
