package com.ericklemos.planetario.templates;

import com.ericklemos.planetario.Planeta;

public interface PlanetaTemplate {

    static Planeta load() {
        return Planeta.builder()
                .id("id")
                .nome("Terra")
                .build();
    }

}
