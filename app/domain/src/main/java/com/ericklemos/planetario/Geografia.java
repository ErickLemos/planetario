package com.ericklemos.planetario;

import com.ericklemos.planetario.geografia.Regiao;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Geografia {

    private String id;
    private Planeta planeta;
    private List<Regiao> regioes;

}
