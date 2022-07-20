package com.ericklemos.planetario;

import com.ericklemos.planetario.core.commands.SalvarPlanetaCommand;
import com.ericklemos.planetario.core.repositorys.PlanetaRepository;
import com.ericklemos.planetario.core.utils.CommandContext;
import com.ericklemos.planetario.core.utils.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarPlanetaCommandImpl implements SalvarPlanetaCommand {

    private final PlanetaRepository repository;

    @Override
    public Planeta process(CommandContext context) {

        var planeta = Validator.ofType(Planeta.class)
                .supplier(context.getData(Planeta.class))
                .validar();

        return repository.salvar(planeta);

    }

}
