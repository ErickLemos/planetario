package com.ericklemos.planetario;

import com.ericklemos.planetario.core.commands.SalvarPlanetaCommand;
import com.ericklemos.planetario.core.repositorys.PlanetaRepository;
import com.ericklemos.planetario.core.utils.CommandContext;
import com.ericklemos.planetario.core.utils.Validator;
import com.ericklemos.planetario.utils.GerarRegioesUtils;
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

        var geografia = Geografia.builder()
                .regioes(GerarRegioesUtils.gerar())
                .build();

        return repository.salvar(planeta);

    }

}
