package com.ericklemos.planetario;

import com.ericklemos.planetario.commands.AdicionarPlanetaCommand;
import com.ericklemos.planetario.repositorys.PlanetaRepository;
import com.ericklemos.planetario.utils.CommandContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class AdicionarPlanetaCommandImpl implements AdicionarPlanetaCommand {

    private final PlanetaRepository repository;

    @Override
    public Planeta process(CommandContext context) {

        var planeta = context.getData(Planeta.class);

        Assert.notNull(planeta, "planeta está nulo");
        Assert.notNull(planeta.getNome(), "nome do planeta está nulo");

        return repository.salvar(planeta);

    }

}
