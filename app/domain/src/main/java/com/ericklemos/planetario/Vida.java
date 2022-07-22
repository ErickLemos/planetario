package com.ericklemos.planetario;

import com.ericklemos.planetario.enums.TipoDeVida;

public interface Vida {

    String getId();

    void setId(String id);

    String getNome();

    void setNome(String nome);

    TipoDeVida getTipo();

    void setTipo(TipoDeVida tipo);

    Planeta getPlaneta();

    void setPlaneta(Planeta planeta);

}
