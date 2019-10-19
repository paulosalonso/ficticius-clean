package com.alon.ficticiusclean.resource.dto.converter;

import com.alon.ficticiusclean.model.User;
import com.alon.ficticiusclean.resource.dto.UserCreateInput;
import org.springframework.stereotype.Component;

@Component
public class UserCreateInputConverter implements InputDtoConverter<UserCreateInput, User> {

    @Override
    public User convert(UserCreateInput input) {
        return new User(input.username, input.password);
    }
    
}
