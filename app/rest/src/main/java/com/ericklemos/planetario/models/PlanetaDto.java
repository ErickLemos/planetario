package com.ericklemos.planetario.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanetaDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String nome;

}
