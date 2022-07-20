package com.ericklemos.planetario;

import com.ericklemos.planetario.core.commands.BuscarPlanetasCommand;
import com.ericklemos.planetario.core.repositorys.PlanetaRepository;
import com.ericklemos.planetario.core.utils.CommandContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarPlanetasCommandImpl implements BuscarPlanetasCommand {

    private final PlanetaRepository planetaRepository;

    @Override
    public List<Planeta> process(CommandContext context) {
        return planetaRepository.buscarTodos();
    }

}
