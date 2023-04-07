package com.example.app.mapper;

import com.example.app.dto.BetDTO;
import com.example.app.entity.Bet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class BetMapper {

    @Autowired
    protected HorseMapper horseMapper;

    @Autowired
    protected UserMapper userMapper;

    @Mapping(target = "money",source = "bet.money")
    @Mapping(target = "horse",expression = "java(horseMapper.mapToHorseDTO(bet.getHorse()))")
    @Mapping(target = "user",expression = "java(userMapper.mapToUserDTO(bet.getUser()))")
    public abstract BetDTO mapToBetDTO(Bet bet);
}
