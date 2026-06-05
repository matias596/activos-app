package com.matias.activosapp.controller;

import com.matias.activosapp.dto.TipoDeGastoResponse;
import com.matias.activosapp.model.enums.Categoria;
import com.matias.activosapp.service.TipoDeGastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/tiposDeGasto")
@RestController
@RequiredArgsConstructor
public class TipoDeGastoController {

    private final TipoDeGastoService service;

    @GetMapping("/default")
    public ResponseEntity<List<TipoDeGastoResponse>> listarDeafaults(@RequestParam Categoria categoria){
        return ResponseEntity.ok(
                service.listarDefaultsPorCategoria(categoria)
        );
    }
}
