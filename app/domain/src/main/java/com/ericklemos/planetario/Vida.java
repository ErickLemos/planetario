package com.ericklemos.planetario;

import com.ericklemos.planetario.enums.TipoDeVida;

public interface Vida {

    String getNome();

    void setNome(String nome);

    TipoDeVida getTipo();

    void setTipo(TipoDeVida tipo);

}
