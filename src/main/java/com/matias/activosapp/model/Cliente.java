package com.matias.activosapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private LocalDate fechaNacimiento;

    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Activo> activos;

    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public Cliente() {

    }
}
