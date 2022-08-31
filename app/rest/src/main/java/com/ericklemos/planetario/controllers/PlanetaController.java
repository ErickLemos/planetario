package com.ericklemos.planetario.controllers;

import com.ericklemos.planetario.core.commands.BuscarPlanetaPorIdCommand;
import com.ericklemos.planetario.core.commands.BuscarPlanetasCommand;
import com.ericklemos.planetario.core.commands.DeletarPlanetaCommand;
import com.ericklemos.planetario.core.commands.SalvarPlanetaCommand;
import com.ericklemos.planetario.core.utils.CommandContext;
import com.ericklemos.planetario.core.utils.Validator;
import com.ericklemos.planetario.mappers.PlanetaDtoMapper;
import com.ericklemos.planetario.models.PlanetaDto;
import com.ericklemos.planetario.utils.Mensagem;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("planetas")
public class PlanetaController {

    private final BuscarPlanetasCommand buscarPlanetasCommand;
    private final BuscarPlanetaPorIdCommand buscarPlanetaPorIdCommand;
    private final SalvarPlanetaCommand salvarPlanetaCommand;
    private final DeletarPlanetaCommand deletarPlanetaCommand;
    private final Logger log = LoggerFactory.getLogger(PlanetaController.class);

    @GetMapping
    public ResponseEntity<List<PlanetaDto>> buscarTodos() {

        log.info("buscar todos - 01 - iniciando consulta");
        var planetas = buscarPlanetasCommand.process(CommandContext.empty());

        log.info("buscar todos - 02 - mapeando domain para dto");
        var planetasDto = planetas.stream()
                .map(PlanetaDtoMapper.INSTANCE::mapFrom)
                .toList();

        log.info("buscar todos - 03 - retornando dtos");
        return ResponseEntity.ok(planetasDto);

    }

    @GetMapping("{id}")
    public ResponseEntity<PlanetaDto> buscarPorId(@PathVariable("id") String id) {

        log.info("buscar por id - 01 - iniciando consulta por id");
        var planeta = buscarPlanetaPorIdCommand.process(CommandContext.of(id));

        log.info("buscar por id - 02 - mapeando domain para dto");
        var planetaDto = PlanetaDtoMapper.INSTANCE.mapFrom(planeta);

        log.info("buscar por id - 03 - retornando dto");
        return ResponseEntity.ok(planetaDto);

    }

    @PostMapping
    public ResponseEntity<PlanetaDto> salvar(@RequestBody PlanetaDto dto) {

        log.info("salvar - 01 - validando valor recebido");
        var dtoValidado = Validator.ofType(PlanetaDto.class)
                .addRegra(item -> Objects.nonNull(item.getNome()), "nome está nulo")
                .comValor(dto)
                .validar();

        log.info("salvar - 02 - mapeando dto para domain");
        var planeta = PlanetaDtoMapper.INSTANCE.mapFrom(dtoValidado);

        log.info("salvar - 03 - chamando command");
        var planetaSalvo = salvarPlanetaCommand.process(CommandContext.of(planeta));

        log.info("salvar - 04 - mapeando domain para dto");
        var planetaDto = PlanetaDtoMapper.INSTANCE.mapFrom(planetaSalvo);

        log.info("salvar - 05 - retornando dto");
        return ResponseEntity.ok(planetaDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Mensagem> deletar(@PathVariable("id") String id) {

        log.info("deletar por id - 01 - chamando command");
        var mensagem = deletarPlanetaCommand.process(CommandContext.of(id));

        log.info("deletar por id - 02 - retornando mensagem");
        return ResponseEntity.ok(mensagem);

    }

}
