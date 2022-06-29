package com.ericklemos.planetario.controllers;

import com.ericklemos.planetario.utils.Versao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppController {

    @Value("${planetario.versao.numero}")
    private String numero;

    @Value("${planetario.versao.codinome}")
    private String codinome;

    @GetMapping
    public ResponseEntity<Versao> getVersao() {
        return ResponseEntity.ok(Versao.builder()
                .numero(numero)
                .codinome(codinome)
                .build());
    }

}
