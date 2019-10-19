package com.alon.ficticiusclean.resource.dto;

import com.alon.ficticiusclean.resource.dto.converter.UserCreateInputConverter;
import com.alon.ficticiusclean.resource.dto.converter.UserEntityToUserDtoConverter;
import com.alon.ficticiusclean.resource.dto.converter.UserListOutputConverter;
import com.alon.ficticiusclean.resource.dto.converter.UserUpdateInputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResourceDtoConverterProvider implements ResourceDtoConverterProvider {

    @Autowired
    private UserListOutputConverter listConverter;
    
    @Autowired
    private UserEntityToUserDtoConverter entityToDtoConverter;
    
    @Autowired
    private UserCreateInputConverter createInputConverter;
    
    @Autowired
    private UserUpdateInputConverter updateInputConverter;
    
    @Override
    public UserListOutputConverter getListOutputDtoConverter() {
        return this.listConverter;
    }

    @Override
    public UserEntityToUserDtoConverter getReadOutputDtoConverter() {
        return this.entityToDtoConverter;
    }

    @Override
    public UserCreateInputConverter getCreateInputDtoConverter() {
        return this.createInputConverter;
    }

    @Override
    public UserEntityToUserDtoConverter getCreateOutputDtoConverter() {
        return this.entityToDtoConverter;
    }

    @Override
    public UserUpdateInputConverter getUpdateInputDtoConverter() {
        return this.updateInputConverter;
    }

    @Override
    public UserEntityToUserDtoConverter getUpdateOutputDtoConverter() {
        return this.entityToDtoConverter;
    }
    
}
