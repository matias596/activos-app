package com.matias.activosapp.repository;

import com.matias.activosapp.model.Activo;
import com.matias.activosapp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivoRepository extends JpaRepository<Activo,Long> {

}
