package com.ericklemos.planetario.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TipoDeRegiao {
    OCEANO("OCEANO"),
    FLORESTA_TROPICAL("FLORESTA_TROPICAL"),
    LITORAL("LITORAL"),
    DESERTO("DESERTO"),
    MONTANHAS("MONTANHAS");

    private final String valor;

    public static TipoDeVida entryOf(String valor) {
        return Arrays.stream(TipoDeVida.values())
                .filter(tipo -> tipo.getValor().equals(valor))
                .findFirst()
                .orElse(null);
    }

    public static boolean exists(String valor) {
        return Arrays.stream(TipoDeVida.values())
                .anyMatch(tipo -> tipo.getValor().equals(valor));
    }

}
