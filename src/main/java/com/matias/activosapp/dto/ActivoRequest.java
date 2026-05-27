package com.matias.activosapp.dto;

import com.matias.activosapp.model.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivoRequest {
    @NotNull(message = "La categoría es obligatoria")
    Categoria categoria;
    String descripcion;
}
