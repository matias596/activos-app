package com.matias.activosapp.service;

import com.matias.activosapp.dto.ActivoRequest;
import com.matias.activosapp.dto.ActivoResponse;
import com.matias.activosapp.exception.ResourceNotFoundException;
import com.matias.activosapp.model.Activo;
import com.matias.activosapp.model.Cliente;
import com.matias.activosapp.repository.ActivoRepository;
import com.matias.activosapp.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivoService {

    private final ActivoRepository repository;
    private final ClienteRepository clienteRepository;

    public ActivoResponse crearActivo(ActivoRequest activo) {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        Cliente cliente = clienteRepository.findClienteByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        Activo activo1 = new Activo(activo.getCategoria(),cliente,activo.getDescripcion());
        repository.save(activo1);

        return new ActivoResponse(activo1.getIdActivo(), activo1.getCategoria(), activo1.getDescripcion());
    }

    public List<ActivoResponse> listarActivos() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        Cliente cliente = clienteRepository.findClienteByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        List<Activo> activos = repository.findByCliente(cliente);


        return activos.stream()
                .map(activo -> new ActivoResponse(
                        activo.getIdActivo(),
                        activo.getCategoria(),
                        activo.getDescripcion()
                ))
                .toList();
    }
}
