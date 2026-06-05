package com.matias.activosapp.service;

import com.matias.activosapp.dto.TipoDeGastoResponse;
import com.matias.activosapp.model.TipoDeGasto;
import com.matias.activosapp.model.enums.Categoria;
import com.matias.activosapp.repository.TipoDeGastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoDeGastoService {
    private final TipoDeGastoRepository repository;

    public List<TipoDeGastoResponse> listarDefaultsPorCategoria(Categoria categoria) {
        List<TipoDeGasto> tipos = repository.findByEsDefaultTrueAndCatActivo(categoria);

        return tipos.stream()
                .map(tipo -> new TipoDeGastoResponse(
                        tipo.getIdTipo(),
                        tipo.getNombre(),
                        tipo.getCatActivo(),
                        tipo.getFrecuencia()
                ))
                .toList();
    }
}
