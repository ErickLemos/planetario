package com.ericklemos.planetario.adapters;

import com.ericklemos.planetario.Planeta;
import com.ericklemos.planetario.core.exceptions.EntidadeNaoEncontradaException;
import com.ericklemos.planetario.core.repositorys.PlanetaRepository;
import com.ericklemos.planetario.mappers.PlanetaEntityMapper;
import com.ericklemos.planetario.repository.PlanetaRepositoryMongo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlanetaRepositoryImpl implements PlanetaRepository {

    private final PlanetaRepositoryMongo repository;
    private static final String ID_NAO_PODE_SER_NULO = "id não pode ser nulo";

    @Override
    public List<Planeta> buscarTodos() {
        return repository.findAll()
                .stream()
                .map(PlanetaEntityMapper.INSTANCE::mapFrom)
                .toList();
    }

    @Override
    public Optional<Planeta> buscarPorId(String id) {
        Assert.notNull(id, ID_NAO_PODE_SER_NULO);
        return repository.findById(id)
                .map(PlanetaEntityMapper.INSTANCE::mapFrom);
    }

    @Override
    public Planeta salvar(Planeta planeta) {

        Assert.notNull(planeta, "planeta não pode ser nulo");

        var entityMapeada = PlanetaEntityMapper.INSTANCE.mapFrom(planeta);

        var entitySalva = repository.save(entityMapeada);

        return PlanetaEntityMapper.INSTANCE.mapFrom(entitySalva);

    }

    @Override
    public void excluirPorId(String id) {

        Assert.notNull(id, ID_NAO_PODE_SER_NULO);

        var planeta = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("planeta não foi encontrado"));

        repository.delete(planeta);

    }

}
