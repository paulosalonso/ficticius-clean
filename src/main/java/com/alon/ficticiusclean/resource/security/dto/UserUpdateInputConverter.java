package com.alon.ficticiusclean.resource.security.dto;

import com.alon.ficticiusclean.resource.core.dto.InputDtoConverter;
import com.alon.ficticiusclean.model.security.User;
import com.alon.ficticiusclean.resource.security.dto.UserUpdateInput;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateInputConverter implements InputDtoConverter<UserUpdateInput, User> {

    @Override
    public User convert(UserUpdateInput input) {
        User user = new User();
        user.setId(input.id);
        user.setActive(input.active);
        
        return user;
    }
    
}
