package com.matias.activosapp.config;

import com.matias.activosapp.model.TipoDeGasto;
import com.matias.activosapp.model.enums.Categoria;
import com.matias.activosapp.model.enums.Frecuencia;
import com.matias.activosapp.repository.TipoDeGastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final TipoDeGastoRepository tipoDeGastoRepository;

    @Override
    public void run(String... args) {
        crearSiNoExiste("Contribución Inmobiliaria", Categoria.PROPIEDAD, Frecuencia.ANUAL);
        crearSiNoExiste("Impuesto de Primaria", Categoria.PROPIEDAD, Frecuencia.ANUAL);
        crearSiNoExiste("UTE", Categoria.PROPIEDAD, Frecuencia.MENSUAL);
        crearSiNoExiste("OSE", Categoria.PROPIEDAD, Frecuencia.MENSUAL);
        crearSiNoExiste("Internet", Categoria.PROPIEDAD, Frecuencia.MENSUAL);

        crearSiNoExiste("Patente de Rodados", Categoria.VEHICULO, Frecuencia.ANUAL);
        crearSiNoExiste("Seguro", Categoria.VEHICULO, Frecuencia.ANUAL);
    }

    private void crearSiNoExiste(String nombre, Categoria categoria, Frecuencia frecuencia) {
        boolean existe = tipoDeGastoRepository.existsByNombreAndCatActivo(nombre, categoria);

        if (!existe) {
            TipoDeGasto tipo = new TipoDeGasto();
            tipo.setNombre(nombre);
            tipo.setCategoria(categoria);
            tipo.setFrecuencia(frecuencia);
            tipo.setDefault(true);

            tipoDeGastoRepository.save(tipo);
        }
    }
}
