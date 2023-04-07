package com.example.app.mapper;

import com.example.app.dto.UserDTO;
import com.example.app.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO mapToUserDTO(User user);
}
