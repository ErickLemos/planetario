package com.ericklemos.planetario.entitys.geografia;

import com.ericklemos.planetario.enums.LocalidadeDaRegiao;
import com.ericklemos.planetario.enums.TipoDeRegiao;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegiaoEntity {

    private LocalidadeDaRegiao localidadeDaRegiao;
    private String nome;
    private TipoDeRegiao tipoDeRegiao;
    private Integer temperatura;
    private List<LocalidadeDaRegiao> conexoes;

}
