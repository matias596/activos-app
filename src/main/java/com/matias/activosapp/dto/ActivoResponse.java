package com.matias.activosapp.dto;

import com.matias.activosapp.model.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivoResponse {
    private Long id;
    private Categoria categoria;
}