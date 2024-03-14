package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cua_pais", schema = "ct")
public class CuaPais {

    @Id
    private Long paCodigo;

    private String paNombre;

    private char paActivo;

    public CuaPais() {
        // Constructor vacío requerido por JPA
    }

    // Constructor con parámetros, getters y setters

    public Long getPaCodigo() {
        return paCodigo;
    }

    public void setPaCodigo(Long paCodigo) {
        this.paCodigo = paCodigo;
    }

    public String getPaNombre() {
        return paNombre;
    }

    public void setPaNombre(String paNombre) {
        this.paNombre = paNombre;
    }

    public char getPaActivo() {
        return paActivo;
    }

    public void setPaActivo(char paActivo) {
        this.paActivo = paActivo;
    }
}
