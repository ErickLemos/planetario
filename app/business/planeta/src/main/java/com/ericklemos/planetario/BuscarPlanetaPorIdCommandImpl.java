package com.ericklemos.planetario;

import com.ericklemos.planetario.core.commands.BuscarPlanetaPorIdCommand;
import com.ericklemos.planetario.core.repositorys.PlanetaRepository;
import com.ericklemos.planetario.core.utils.CommandContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarPlanetaPorIdCommandImpl implements BuscarPlanetaPorIdCommand {

    private final PlanetaRepository repository;

    @Override
    public Planeta process(CommandContext context) {

        var id = Optional.ofNullable(context.getData(String.class))
                .orElseThrow(RuntimeException::new);

        return repository.buscarPorId(id)
                .orElseThrow(RuntimeException::new);

    }

}
