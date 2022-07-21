package com.ericklemos.planetario;

import com.ericklemos.planetario.core.commands.DeletarPlanetaCommand;
import com.ericklemos.planetario.core.repositorys.PlanetaRepository;
import com.ericklemos.planetario.core.utils.CommandContext;
import com.ericklemos.planetario.utils.Mensagem;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeletarPlanetaCommandImpl implements DeletarPlanetaCommand {

    private final PlanetaRepository planetaRepository;
    private final Logger log = LoggerFactory.getLogger(DeletarPlanetaCommandImpl.class);

    @Override
    public Mensagem process(CommandContext context) {

        log.info("01 - validando se dados sao validos");
        var id = Optional.ofNullable(context.getData(String.class))
                .orElseThrow(RuntimeException::new);

        log.info("02 - verificando se há planeta com id repassado: {}", id);
        if (!planetaRepository.existePorId(id)) {
            return Mensagem.of(
                    "ops!",
                    "planeta não foi encontrado"
            );
        }

        log.info("03 - iniciando processo de exclusao por id: {}", id);
        planetaRepository.excluirPorId(id);

        log.info("04 - retornando mensagem de sucesso");
        return Mensagem.of(
                "sucesso",
                "planeta foi deletado com sucesso"
        );

    }

}
