package com.alon.ficticiusclean.resource.security;

import com.alon.ficticiusclean.resource.core.CrudResource;
import com.alon.ficticiusclean.model.security.User;
import com.alon.ficticiusclean.resource.security.dto.ChangePasswordInput;
import com.alon.ficticiusclean.resource.security.dto.UserCreateInput;
import com.alon.ficticiusclean.resource.security.dto.UserDto;
import com.alon.ficticiusclean.resource.security.dto.UserResourceDtoConverterProvider;
import com.alon.ficticiusclean.resource.security.dto.UserUpdateInput;
import com.alon.ficticiusclean.resource.security.dto.UserEntityToUserDtoConverter;
import com.alon.ficticiusclean.service.core.UpdateException;
import com.alon.ficticiusclean.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource extends CrudResource<UserService, UserCreateInput, UserUpdateInput, UserResourceDtoConverterProvider> {
    
    @Autowired
    private UserEntityToUserDtoConverter entityToDtoConverter;
    
    @PostMapping("/changePassword")
    public UserDto changePassword(@RequestBody ChangePasswordInput input) throws UpdateException {
        User user = this.service
                        .changePassword(input.username, input.password, input.newPassword);
        
        return this.entityToDtoConverter
                   .convert(user);
    }
    
}
