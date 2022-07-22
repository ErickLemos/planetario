package com.ericklemos.planeta.adapters;

import com.ericklemos.planetario.adapters.PlanetaRepositoryImpl;
import com.ericklemos.planetario.entitys.PlanetaEntity;
import com.ericklemos.planetario.repository.PlanetaRepositoryMongo;
import com.ericklemos.planetario.templates.PlanetaEntityTemplate;
import com.ericklemos.planetario.templates.PlanetaTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlanetaRepositoryImplTest {

    @InjectMocks
    private PlanetaRepositoryImpl repository;

    @Mock
    private PlanetaRepositoryMongo mongo;

    @Test
    @DisplayName("buscarTodos: sucesso")
    void buscarTodos() {

        when(mongo.findAll()).thenReturn(List.of(
                PlanetaEntityTemplate.load(),
                PlanetaEntityTemplate.load()
        ));

        var resultado = repository.buscarTodos();

        assertFalse(resultado.isEmpty());
        verify(mongo, times(1)).findAll();

    }

    @Test
    @DisplayName("buscarPorId: sucesso")
    void buscarPorId() {

        when(mongo.findById(any(String.class)))
                .thenReturn(Optional.ofNullable(PlanetaEntityTemplate.load()));

        var resultado = repository.buscarPorId("id");

        assertTrue(resultado.isPresent());
        verify(mongo, times(1))
                .findById(any(String.class));

    }

    @Test
    @DisplayName("buscarPorId: validar caso id seja nulo")
    void buscarPorIdValidarCasoSejaNulo() {

        assertThrows(IllegalArgumentException.class,
                () -> repository.buscarPorId(null));

        verify(mongo, times(0))
                .findById(any(String.class));

    }

    @Test
    @DisplayName("buscarPorId: validar caso resultado não seja encontrado")
    void buscarPorIdValidarCasoResultadoNaoSejaEncontrado() {

        when(mongo.findById(any(String.class)))
                .thenReturn(Optional.empty());

        var resultado = repository.buscarPorId("algo");

        assertTrue(resultado.isEmpty());
        verify(mongo, times(1))
                .findById(any(String.class));

    }

    @Test
    @DisplayName("salvar: sucesso")
    void salvar() {

        when(mongo.save(any(PlanetaEntity.class)))
                .thenReturn(PlanetaEntityTemplate.load());

        var resultado = repository.salvar(PlanetaTemplate.load());

        assertNotNull(resultado);
        verify(mongo, times(1))
                .save(any(PlanetaEntity.class));

    }

    @Test
    @DisplayName("salvar: validar caso valor seja nulo")
    void salvarValidarCasoValorSejaNulo() {

        assertThrows(IllegalArgumentException.class,
                () -> repository.salvar(null));

        verify(mongo, times(0))
                .save(any(PlanetaEntity.class));

    }

    @Test
    @DisplayName("excluirPorId: sucesso")
    void excluirPorId() {

        doNothing().when(mongo)
                .delete(any(PlanetaEntity.class));

        var planetaEntity = Optional.of(new PlanetaEntity());
        doReturn(planetaEntity).when(mongo)
                .findById(any(String.class));

        repository.excluirPorId("id");

        verify(mongo, times(1))
                .findById(any(String.class));

        verify(mongo, times(1))
                .delete(any(PlanetaEntity.class));

    }

    @Test
    @DisplayName("excluirPorId: validar caso id seja nulo")
    void excluirPorIdValidarCasoIdSejaNulo() {

        assertThrows(IllegalArgumentException.class,
                () -> repository.excluirPorId(null));

        verify(mongo, times(0))
                .deleteById(any(String.class));
    }

}