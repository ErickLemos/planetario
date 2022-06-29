package com.ericklemos.planetario.templates;

import com.ericklemos.planetario.Planeta;

import java.util.UUID;

public interface PlanetaTemplate {

    static Planeta load() {
        return Planeta.builder()
                .id(UUID.randomUUID().toString())
                .nome("Terra")
                .build();
    }

}
