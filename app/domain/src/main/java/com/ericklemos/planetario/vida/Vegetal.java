package com.ericklemos.planetario.vida;

import com.ericklemos.planetario.Planeta;
import com.ericklemos.planetario.Vida;
import com.ericklemos.planetario.enums.TipoDeVida;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vegetal implements Vida {

    private String id;
    private String nome;
    private TipoDeVida tipo;
    private Planeta planeta;

}
