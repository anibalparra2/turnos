package com.example.turnos.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="COMERCIOS")
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idComercio;
    private String nomComercio;
    private Integer aforoMaximo;

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public String getNomComercio() {
        return nomComercio;
    }

    public void setNomComercio(String nomComercio) {
        this.nomComercio = nomComercio;
    }

    public Integer getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(Integer aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }
}
