package com.ericklemos.planetario;

import com.ericklemos.planetario.core.commands.DeletarPlanetaCommand;
import com.ericklemos.planetario.core.repositorys.PlanetaRepository;
import com.ericklemos.planetario.core.utils.CommandContext;
import com.ericklemos.planetario.utils.Mensagem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeletarPlanetaCommandImpl implements DeletarPlanetaCommand {

    private final PlanetaRepository planetaRepository;

    @Override
    public Mensagem process(CommandContext context) {

        var id = Optional.ofNullable(context.getData(String.class))
                .orElseThrow(RuntimeException::new);

        planetaRepository.excluirPorId(id);

        return Mensagem.of(
                "sucesso",
                "planeta foi deletado com sucesso"
        );

    }

}
