package com.alon.ficticiusclean.resource.dto.converter;

import com.alon.ficticiusclean.model.Role;
import com.alon.ficticiusclean.model.User;
import com.alon.ficticiusclean.resource.dto.UserDto;
import com.alon.ficticiusclean.resource.dto.UserListOutput;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class UserListOutputConverter implements OutputDtoConverter<Page<User>, UserListOutput> {
    
    @Autowired
    private UserEntityToUserDtoConverter converter;

    @Override
    public UserListOutput convert(Page<User> data) {
        List<UserDto> usersDto = data.getContent()
                                     .stream()
                                     .map(user -> this.converter.convert(user))
                                     .collect(Collectors.toList());
        
        UserListOutput output = new UserListOutput();
        output.content = usersDto;
        output.page = data.getNumber() + 1;
        output.pageSize = usersDto.size();
        output.totalPages = data.getTotalPages();
        output.totalSize = data.getNumberOfElements();
        
        return output;
    }
    
}
