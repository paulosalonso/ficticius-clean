package com.alon.ficticiusclean.resource.security.dto;

import com.alon.ficticiusclean.resource.core.dto.InputDtoConverter;
import com.alon.ficticiusclean.model.security.User;
import com.alon.ficticiusclean.resource.security.dto.UserCreateInput;
import org.springframework.stereotype.Component;

@Component
public class UserCreateInputConverter implements InputDtoConverter<UserCreateInput, User> {

    @Override
    public User convert(UserCreateInput input) {
        return new User(input.username, input.password);
    }
    
}
