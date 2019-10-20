package com.alon.ficticiusclean.resource.security.dto;

public class UserReadOutput {
    
    public UserDto user;

    public UserReadOutput() {
    }

    public UserReadOutput(UserDto user) {
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
