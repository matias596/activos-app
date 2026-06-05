package com.matias.activosapp.repository;

import com.matias.activosapp.model.TipoDeGasto;
import com.matias.activosapp.model.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoDeGastoRepository extends JpaRepository<TipoDeGasto,Long> {

    boolean existsByNombreAndCatActivo(String nombre, Categoria categoria);

    List<TipoDeGasto> findByEsDefaultTrueAndCatActivo(Categoria categoria);
}
