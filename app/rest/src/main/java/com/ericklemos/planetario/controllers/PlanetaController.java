package com.ericklemos.planetario.controllers;

import com.ericklemos.planetario.core.commands.BuscarPlanetaPorIdCommand;
import com.ericklemos.planetario.core.commands.BuscarPlanetasCommand;
import com.ericklemos.planetario.core.commands.DeletarPlanetaCommand;
import com.ericklemos.planetario.core.commands.SalvarPlanetaCommand;
import com.ericklemos.planetario.core.utils.CommandContext;
import com.ericklemos.planetario.mappers.PlanetaDtoMapper;
import com.ericklemos.planetario.models.PlanetaDto;
import com.ericklemos.planetario.utils.Mensagem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("planetas")
public class PlanetaController {

    private final BuscarPlanetasCommand buscarPlanetasCommand;
    private final BuscarPlanetaPorIdCommand buscarPlanetaPorIdCommand;
    private final SalvarPlanetaCommand salvarPlanetaCommand;
    private final DeletarPlanetaCommand deletarPlanetaCommand;

    @GetMapping
    public ResponseEntity<List<PlanetaDto>> getAll() {

        var planetas = buscarPlanetasCommand.process(CommandContext.empty());

        var planetasDto = planetas.stream()
                .map(PlanetaDtoMapper.INSTANCE::mapFrom)
                .toList();

        return ResponseEntity.ok(planetasDto);

    }

    @GetMapping("{id}")
    public ResponseEntity<PlanetaDto> getById(@PathVariable("id") String id) {

        var planeta = buscarPlanetaPorIdCommand.process(CommandContext.of(id));

        var planetaDto = PlanetaDtoMapper.INSTANCE.mapFrom(planeta);

        return ResponseEntity.ok(planetaDto);

    }

    @PostMapping
    public ResponseEntity<PlanetaDto> salvar(@RequestBody PlanetaDto dto) {
        return salvarBase(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<PlanetaDto> editar(@RequestBody PlanetaDto dto) {
        return salvarBase(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Mensagem> deletar(@PathVariable("id") String id) {

        var mensagem = deletarPlanetaCommand.process(CommandContext.of(id));

        return ResponseEntity.ok(mensagem);

    }

    private ResponseEntity<PlanetaDto> salvarBase(PlanetaDto dto) {
        var planeta = PlanetaDtoMapper.INSTANCE.mapFrom(dto);
        var planetaSalvo = salvarPlanetaCommand.process(CommandContext.of(planeta));
        var planetaDto = PlanetaDtoMapper.INSTANCE.mapFrom(planetaSalvo);
        return ResponseEntity.ok(planetaDto);
    }

}
