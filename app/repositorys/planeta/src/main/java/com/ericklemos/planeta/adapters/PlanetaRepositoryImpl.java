package com.ericklemos.planeta.adapters;

import com.ericklemos.planeta.mappers.PlanetaEntityMapper;
import com.ericklemos.planeta.repository.PlanetaRepositoryMongo;
import com.ericklemos.planetario.Planeta;
import com.ericklemos.planetario.repositorys.PlanetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlanetaRepositoryImpl implements PlanetaRepository {

    private final PlanetaRepositoryMongo repository;

    @Override
    public List<Planeta> buscarTodos() {
        return repository.findAll()
                .stream()
                .map(PlanetaEntityMapper.INSTANCE::mapFrom)
                .toList();
    }

    @Override
    public Optional<Planeta> buscarPorId(String id) {
        Assert.notNull(id, "id não pode ser nulo");
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
        Assert.notNull(id, "id não pode ser nulo");
        repository.deleteById(id);
    }

}
