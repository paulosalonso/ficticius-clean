package com.alon.ficticiusclean.resource.security.dto;

import com.alon.ficticiusclean.resource.core.dto.OutputDtoConverter;
import com.alon.ficticiusclean.model.security.Role;
import com.alon.ficticiusclean.model.security.User;
import com.alon.ficticiusclean.resource.security.dto.UserDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDtoConverter implements OutputDtoConverter<User, UserDto> {

    @Override
    public UserDto convert(User data) {
        UserDto user = new UserDto();
        user.id = data.getId();
        user.username = data.getUsername();
        user.password = data.getPassword();
        user.active = data.isActive();
        user.roles = this.convertRoles(data.getAuthorities());
        
        return user;
    }
    
    private List<String> convertRoles(List<Role> roles) {        
        return roles.stream()
                    .map(role -> role.getAuthority())
                    .collect(Collectors.toList());
    }
    
}
