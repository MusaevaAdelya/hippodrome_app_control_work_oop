package com.example.app.mapper;

import com.example.app.dto.HorseDTO;
import com.example.app.entity.Horse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HorseMapper {

    HorseDTO mapToHorseDTO(Horse horse);
}
