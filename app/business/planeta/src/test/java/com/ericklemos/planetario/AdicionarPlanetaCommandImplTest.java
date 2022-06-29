package com.ericklemos.planetario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("testes no fluxo de adicao de planetas")
class AdicionarPlanetaCommandImplTest {

    @InjectMocks
    private AdicionarPlanetaCommandImpl command;

    @Test
    @DisplayName("sucesso")
    void sucesso() {
        // TODO: implementar testes
    }

}