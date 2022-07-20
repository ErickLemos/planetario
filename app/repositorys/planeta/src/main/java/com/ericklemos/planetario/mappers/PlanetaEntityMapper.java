package com.ericklemos.planetario.mappers;

import com.ericklemos.planetario.Planeta;
import com.ericklemos.planetario.entitys.PlanetaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanetaEntityMapper {

    PlanetaEntityMapper INSTANCE = Mappers.getMapper(PlanetaEntityMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    Planeta mapFrom(PlanetaEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    PlanetaEntity mapFrom(Planeta domain);

}
