package com.ericklemos.planetario.geografia;

import com.ericklemos.planetario.enums.LocalidadeDaRegiao;
import com.ericklemos.planetario.enums.TipoDeRegiao;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Regiao {

    private LocalidadeDaRegiao localidadeDaRegiao;
    private String nome;
    private TipoDeRegiao tipoDeRegiao;
    private Integer temperatura;
    private List<LocalidadeDaRegiao> conexoes;

}
