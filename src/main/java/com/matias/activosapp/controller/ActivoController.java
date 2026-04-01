package com.matias.activosapp.controller;

import com.matias.activosapp.auth.AuthenticationResponse;
import com.matias.activosapp.dto.ActivoRequest;
import com.matias.activosapp.dto.ActivoResponse;
import com.matias.activosapp.service.ActivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activos")
@RequiredArgsConstructor
public class ActivoController {

    private final ActivoService service;

    @PostMapping
    public ResponseEntity<ActivoResponse> crearActivo(@Validated @RequestBody ActivoRequest activo){
        ActivoResponse response = service.crearActivo(activo);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
