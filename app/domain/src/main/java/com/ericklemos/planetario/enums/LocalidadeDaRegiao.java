package com.ericklemos.planetario.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LocalidadeDaRegiao {
    FRENTE("FRENTE"),
    DIREITA("DIREITA"),
    ESQUERDA("ESQUERDA"),
    ATRAS("ATRAS"),
    ENCIMA("ENCIMA"),
    EMBAIXO("EMBAIXO");

    private final String valor;

}
