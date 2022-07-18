package com.ericklemos.planetario;

import com.ericklemos.planetario.core.repositorys.PlanetaRepository;
import com.ericklemos.planetario.core.utils.CommandContext;
import com.ericklemos.planetario.core.utils.validator.ValidationException;
import com.ericklemos.planetario.templates.PlanetaTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SalvarPlanetaCommandImplTest {

    @InjectMocks
    private SalvarPlanetaCommandImpl command;

    @Mock
    private PlanetaRepository repository;

    @Test
    @DisplayName("sucesso")
    void sucesso() {

        var planeta = PlanetaTemplate.load();
        planeta.setId(null);

        when(repository.salvar(any(Planeta.class)))
                .thenReturn(PlanetaTemplate.load());

        var resultado = command.process(new CommandContext(planeta));

        assertEquals("id", resultado.getId());
        assertEquals("Terra", resultado.getNome());

        verify(repository, times(1))
                .salvar(any(Planeta.class));

    }

    @Test
    @DisplayName("disparar exception caso repository apresente falha")
    void validarRepository() {

        var planeta = PlanetaTemplate.load();
        var context = new CommandContext(planeta);

        when(repository.salvar(any(Planeta.class)))
                .thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class,
                () -> command.process(context));

        verify(repository, times(1))
                .salvar(any(Planeta.class));

    }

    @Test
    @DisplayName("disparar exception caso planeta seja nulo")
    void validarPlaneta() {

        var context = new CommandContext();

        assertThrows(ValidationException.class,
                () -> command.process(context));

    }

}