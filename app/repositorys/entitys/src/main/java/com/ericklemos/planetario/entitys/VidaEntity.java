package com.ericklemos.planetario.entitys;

import com.ericklemos.planetario.Planeta;
import com.ericklemos.planetario.enums.TipoDeVida;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class VidaEntity {

    @Id
    private String id;
    private String nome;
    private TipoDeVida tipo;
    private Planeta planeta;

}
