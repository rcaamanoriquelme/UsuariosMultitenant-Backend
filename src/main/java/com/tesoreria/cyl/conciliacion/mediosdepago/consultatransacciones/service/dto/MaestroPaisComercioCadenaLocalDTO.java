package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MaestroPaisComercioCadenaLocalDTO {
    
    @EmbeddedId
    private MaestroPaisComercioDTOPK id;  // Debes ajustar el tipo de dato según tu base de datos y estructura.
    
    @Column(name = "sistema_cod")
    private String sistemaCod;
    
    @Column(name = "sistema_cyl")
    private String sistemaCyl;


    // Getters and setters

    public MaestroPaisComercioDTOPK getId() {
        return id;
    }

    public void setId(MaestroPaisComercioDTOPK id) {
        this.id = id;
    }

    public String getSistemaCod() {
        return sistemaCod;
    }

    public void setSistemaCod(String sistemaCod) {
        this.sistemaCod = sistemaCod;
    }

    public String getSistemaCyl() {
        return sistemaCyl;
    }

    public void setSistemaCyl(String sistemaCyl) {
        this.sistemaCyl = sistemaCyl;
    }
}