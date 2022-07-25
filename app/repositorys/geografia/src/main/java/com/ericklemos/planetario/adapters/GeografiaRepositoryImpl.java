package com.ericklemos.planetario.adapters;

import com.ericklemos.planetario.Geografia;
import com.ericklemos.planetario.core.exceptions.EntidadeNaoEncontradaException;
import com.ericklemos.planetario.core.repositorys.GeografiaRepository;
import com.ericklemos.planetario.mappers.GeografiaEntityMapper;
import com.ericklemos.planetario.repository.GeografiaMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GeografiaRepositoryImpl implements GeografiaRepository {

    private static final String ID_NAO_PODE_SER_NULO = "id não pode ser nulo";
    private final GeografiaMongoRepository repository;

    @Override
    public Optional<Geografia> buscarPorId(String id) {
        Assert.notNull(id, ID_NAO_PODE_SER_NULO);
        return repository.findById(id)
                .map(GeografiaEntityMapper.INSTANCE::mapFrom);
    }

    @Override
    public Geografia salvar(Geografia geografia) {

        Assert.notNull(geografia, "geografia não pode ser nula");

        var entityMapeada = GeografiaEntityMapper.INSTANCE.mapFrom(geografia);

        var entitySalva = repository.save(entityMapeada);

        return GeografiaEntityMapper.INSTANCE.mapFrom(entitySalva);

    }

    @Override
    public void excluirPorId(String id) {

        Assert.notNull(id, ID_NAO_PODE_SER_NULO);

        var entidade = repository.findById(id)
                .orElseThrow(EntidadeNaoEncontradaException::new);

        repository.delete(entidade);

    }

}
