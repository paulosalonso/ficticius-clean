package com.alon.ficticiusclean.resource.dto;

import java.util.List;

public class UserListOutput extends ListOutput<UserDto> {

    public UserListOutput() {}

    public UserListOutput(List<UserDto> content, int page, int pageSize, int totalPages, int totalSize) {
        super(content, page, pageSize, totalPages, totalSize);
    }
    
}
