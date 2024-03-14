package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MaestroPaisComercioLocalDTO {
    
    @Id
    private Long id;
    
    @Column(name = "sistema_cod")
    private String sistemaCod;
    
    @Column(name = "sistema_cyl")
    private String sistemaCyl;


    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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