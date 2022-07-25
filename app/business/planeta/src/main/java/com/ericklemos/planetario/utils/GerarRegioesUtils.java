package com.ericklemos.planetario.utils;

import com.ericklemos.planetario.enums.LocalidadeDaRegiao;
import com.ericklemos.planetario.geografia.Regiao;

import java.util.List;

public interface GerarRegioesUtils {

    static List<Regiao> gerar() {

        var conexoesFrontaisAtras = List.of(
                LocalidadeDaRegiao.DIREITA,
                LocalidadeDaRegiao.ESQUERDA
        );

        var conexoesEsquerdaDireita = List.of(
                LocalidadeDaRegiao.FRENTE,
                LocalidadeDaRegiao.ATRAS
        );

        var conexoesEncimaEmbaixo = List.of(
                LocalidadeDaRegiao.FRENTE,
                LocalidadeDaRegiao.ATRAS,
                LocalidadeDaRegiao.DIREITA,
                LocalidadeDaRegiao.ESQUERDA
        );

        var regiaoFrontal = Regiao.builder()
                .nome("Primeira região")
                .localidadeDaRegiao(LocalidadeDaRegiao.FRENTE)
                .conexoes(conexoesFrontaisAtras)
                .build();

        var regiaoAtras = Regiao.builder()
                .nome("Segundo região")
                .localidadeDaRegiao(LocalidadeDaRegiao.ATRAS)
                .conexoes(conexoesFrontaisAtras)
                .build();

        var regiaoEsquerda = Regiao.builder()
                .nome("Terceira região")
                .localidadeDaRegiao(LocalidadeDaRegiao.ESQUERDA)
                .conexoes(conexoesEsquerdaDireita)
                .build();

        var regiaoDireita = Regiao.builder()
                .nome("Quarta região")
                .localidadeDaRegiao(LocalidadeDaRegiao.DIREITA)
                .conexoes(conexoesEsquerdaDireita)
                .build();

        var regiaoEncima = Regiao.builder()
                .nome("Quinta região")
                .localidadeDaRegiao(LocalidadeDaRegiao.ENCIMA)
                .conexoes(conexoesEncimaEmbaixo)
                .build();

        var regiaoEmbaixo = Regiao.builder()
                .nome("Sexta região")
                .localidadeDaRegiao(LocalidadeDaRegiao.EMBAIXO)
                .conexoes(conexoesEncimaEmbaixo)
                .build();

        return List.of(
                regiaoFrontal,
                regiaoAtras,
                regiaoEsquerda,
                regiaoDireita,
                regiaoEncima,
                regiaoEmbaixo
        );

    }

}
