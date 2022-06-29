package com.ericklemos.planeta.mappers;

import com.ericklemos.planetario.templates.PlanetaEntityTemplate;
import com.ericklemos.planetario.templates.PlanetaTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlanetaEntityMapperTest {

    @Test
    @DisplayName("domain para entity")
    void domainParaEntity() {

        var domain = PlanetaTemplate.load();
        var resultado = PlanetaEntityMapper.INSTANCE.mapFrom(domain);

        assertEquals(domain.getId(), resultado.getId());
        assertEquals(domain.getNome(), resultado.getNome());

    }

    @Test
    @DisplayName("entity para domain")
    void entityParaDomain() {

        var entity = PlanetaEntityTemplate.load();
        var resultado = PlanetaEntityMapper.INSTANCE.mapFrom(entity);

        assertEquals(entity.getId(), resultado.getId());
        assertEquals(entity.getNome(), resultado.getNome());

    }

}