package com.example.turnos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="TURNOS")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurno;
    private Integer idServicio;
    private Timestamp fechaTurno;
    private String horaInicio;
    private String horaFin;
    private String estado;

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Timestamp getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Timestamp fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
