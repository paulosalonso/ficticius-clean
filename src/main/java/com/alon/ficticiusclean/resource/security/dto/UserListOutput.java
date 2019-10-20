package com.alon.ficticiusclean.resource.security.dto;

import com.alon.ficticiusclean.resource.core.dto.ListOutput;
import java.util.List;

public class UserListOutput extends ListOutput<UserDto> {

    public UserListOutput() {}

    public UserListOutput(List<UserDto> content, int page, int pageSize, int totalPages, int totalSize) {
        super(content, page, pageSize, totalPages, totalSize);
    }
    
}
