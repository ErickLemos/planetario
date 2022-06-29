package com.ericklemos.planetario.templates;

import com.ericklemos.planetario.entitys.PlanetaEntity;

import java.util.UUID;

public interface PlanetaEntityTemplate {

    static PlanetaEntity load() {
        return PlanetaEntity.builder()
                .id(UUID.randomUUID().toString())
                .nome("Terra")
                .build();
    }

}
