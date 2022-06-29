package com.ericklemos.planetario.entitys;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class PlanetaEntity {

    @Id
    private String id;
    private String nome;

}
