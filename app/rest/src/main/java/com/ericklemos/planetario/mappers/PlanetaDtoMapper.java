package com.ericklemos.planetario.mappers;

import com.ericklemos.planetario.Planeta;
import com.ericklemos.planetario.models.PlanetaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanetaDtoMapper {

    PlanetaDtoMapper INSTANCE = Mappers.getMapper(PlanetaDtoMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    Planeta mapFrom(PlanetaDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    PlanetaDto mapFrom(Planeta domain);

}
