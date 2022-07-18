package com.ericklemos.planetario.controllers;

import com.ericklemos.planetario.core.commands.SalvarPlanetaCommand;
import com.ericklemos.planetario.core.utils.CommandContext;
import com.ericklemos.planetario.mappers.PlanetaDtoMapper;
import com.ericklemos.planetario.models.PlanetaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("planetas")
public class PlanetaController {

    private final SalvarPlanetaCommand salvarPlanetaCommand;

    @GetMapping
    public ResponseEntity<PlanetaDto> getAll() {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<PlanetaDto> getById(@PathVariable("id") String id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<PlanetaDto> salvar(@RequestBody PlanetaDto dto) {

        var planeta = PlanetaDtoMapper.INSTANCE.mapFrom(dto);
        var planetaSalvo = salvarPlanetaCommand.process(CommandContext.of(planeta));
        var planetaDto = PlanetaDtoMapper.INSTANCE.mapFrom(planetaSalvo);

        return ResponseEntity.ok(planetaDto);

    }

    @PutMapping("{id}")
    public ResponseEntity<PlanetaDto> editar(@RequestBody PlanetaDto dto) {
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PlanetaDto> deletar(@PathVariable("id") String id) {
        return null;
    }

}
