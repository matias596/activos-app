package com.matias.activosapp.dto;

import com.matias.activosapp.model.enums.Categoria;
import com.matias.activosapp.model.enums.Frecuencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoDeGastoResponse {
    private Long idTipo;
    private String nombre;
    private Categoria catActivo;
    private Frecuencia frecuencia;
}
