package com.ericklemos.planetario.mappers;

import com.ericklemos.planetario.Geografia;
import com.ericklemos.planetario.entitys.GeografiaEntity;
import com.ericklemos.planetario.mappers.geografia.RegiaoEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        RegiaoEntityMapper.class
})
public interface GeografiaEntityMapper {

    GeografiaEntityMapper INSTANCE = Mappers.getMapper(GeografiaEntityMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "regioes", source = "regioes")
    Geografia mapFrom(GeografiaEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "regioes", source = "regioes")
    GeografiaEntity mapFrom(Geografia domain);

}
