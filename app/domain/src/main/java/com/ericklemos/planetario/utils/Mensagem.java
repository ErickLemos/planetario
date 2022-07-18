package com.ericklemos.planetario.utils;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mensagem {

    private String titulo;
    private String descricao;

    public static Mensagem of(String titulo, String descricao) {
        return Mensagem.builder()
                .titulo(titulo)
                .descricao(descricao)
                .build();
    }

}
