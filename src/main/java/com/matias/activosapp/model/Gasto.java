package com.matias.activosapp.model;

import com.matias.activosapp.model.enums.Estado;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGasto;

    private BigDecimal monto;//pesos uruguayos en principio

    private LocalDate fechaVencimiento;

    private LocalDate fechaPago;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_activo")
    private Activo activo;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoDeGasto tipoDeGasto;

    public Gasto() {
    }

    public Gasto(BigDecimal monto, LocalDate fechaVencimiento, LocalDate fechaPago, Estado estado,Activo activo, TipoDeGasto tipoDeGasto) {
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaPago = fechaPago;
        this.estado = estado;
        this.activo = activo;
        this.tipoDeGasto = tipoDeGasto;
    }

    public Long getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Long idGasto) {
        this.idGasto = idGasto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
