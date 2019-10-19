package com.alon.ficticiusclean.resource.dto.converter;

import com.alon.ficticiusclean.model.User;
import com.alon.ficticiusclean.resource.dto.UserUpdateInput;
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
