package com.matias.activosapp.repository;

import com.matias.activosapp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findClienteByEmail(String email);
}
