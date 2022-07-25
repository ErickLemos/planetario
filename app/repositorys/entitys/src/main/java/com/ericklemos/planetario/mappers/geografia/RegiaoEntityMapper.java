package com.ericklemos.planetario.mappers.geografia;

import com.ericklemos.planetario.entitys.geografia.RegiaoEntity;
import com.ericklemos.planetario.geografia.Regiao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegiaoEntityMapper {

    RegiaoEntityMapper INSTANCE = Mappers.getMapper(RegiaoEntityMapper.class);

    @Mapping(target = "localidadeDaRegiao", source = "localidadeDaRegiao")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "tipoDeRegiao", source = "tipoDeRegiao")
    @Mapping(target = "temperatura", source = "temperatura")
    @Mapping(target = "conexoes", source = "conexoes")
    Regiao mapFrom(RegiaoEntity entity);

    @Mapping(target = "localidadeDaRegiao", source = "localidadeDaRegiao")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "tipoDeRegiao", source = "tipoDeRegiao")
    @Mapping(target = "temperatura", source = "temperatura")
    @Mapping(target = "conexoes", source = "conexoes")
    RegiaoEntity mapFrom(Regiao domain);

}
