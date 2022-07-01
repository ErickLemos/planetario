package com.ericklemos.planetario;

import com.ericklemos.planetario.core.commands.AdicionarPlanetaCommand;
import com.ericklemos.planetario.core.repositorys.PlanetaRepository;
import com.ericklemos.planetario.core.utils.CommandContext;
import com.ericklemos.planetario.core.utils.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AdicionarPlanetaCommandImpl implements AdicionarPlanetaCommand {

    private final PlanetaRepository repository;

    @Override
    public Planeta process(CommandContext context) {

        var planeta = Validator.ofType(Planeta.class)
                .addRegra(Objects::nonNull, "pix não pode ser nulo")
                .addRegra(item -> Objects.nonNull(item.getNome()), "nome não pode ser nulo")
                .supplier(context.getData(Planeta.class))
                .validar();

        return repository.salvar(planeta);

    }

}
