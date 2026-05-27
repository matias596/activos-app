package com.matias.activosapp.model;

import com.matias.activosapp.model.enums.Categoria;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Activo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivo;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private String descripcion;

    @OneToMany(mappedBy = "activo")
    private List<Gasto> gastos;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Activo() {
    }

    public Activo(Categoria categoria, Cliente cliente, String descripcion) {
        this.categoria = categoria;
        this.cliente = cliente;
        this.descripcion = descripcion;
    }

    public Long getIdActivo() {
        return idActivo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
