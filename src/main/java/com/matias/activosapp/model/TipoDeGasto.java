package com.matias.activosapp.model;

import com.matias.activosapp.model.enums.Categoria;
import com.matias.activosapp.model.enums.Frecuencia;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TipoDeGasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipo;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria catActivo;

    @Enumerated(EnumType.STRING)
    private Frecuencia frecuencia;

    private Boolean esDefault;

    @OneToMany(mappedBy = "tipoDeGasto")
    private List<Gasto> gastos;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente; // null si es default

    public TipoDeGasto(String nombre, Categoria catActivo, Frecuencia frecuencia,Boolean esDefault) {
        this.nombre = nombre;
        this.catActivo = catActivo;
        this.frecuencia = frecuencia;
        this.esDefault = esDefault;
    }

    public TipoDeGasto(String nombre, Categoria catActivo, Frecuencia frecuencia, Boolean esDefault, Cliente cliente) {
        this.nombre = nombre;
        this.catActivo = catActivo;
        this.frecuencia = frecuencia;
        this.esDefault = esDefault;
        this.cliente = cliente;
    }

    public TipoDeGasto() {

    }
}
