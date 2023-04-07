package com.example.app.mapper;

import com.example.app.dto.BetResultDTO;
import com.example.app.entity.User;
import com.example.app.service.BetService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class BetResultMapper {

    @Autowired
    protected BetService betService;


    @Mapping(target="email",source = "user.email")
    @Mapping(target="username",source = "user.username")
    @Mapping(target = "money",expression = "java(betService.getMoney(user.getEmail()))")
    public abstract BetResultDTO map(User user);
}
