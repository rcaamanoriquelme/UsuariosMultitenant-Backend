package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "irs_perfiles", schema = "ctm")
public class IrsPerfiles {

    @Id
    @Column(name = "per_codigo", nullable = false, length = 30)
    private String perCodigo;

    @Column(name = "per_nombre", nullable = false, length = 50)
    private String perNombre;

    @Column(name = "per_sistema", length = 3)
    private String perSistema;

    @Column(name = "per_desc", length = 500)
    private String perDesc;

    @Column(name = "per_fcrea")
    private Timestamp perFcrea;

    @Column(name = "per_fmod")
    private Timestamp perFmod;

    @Column(name = "per_ucrea", length = 100)
    private String perUcrea;

    @Column(name = "per_umod", length = 100)
    private String perUmod;

    @Column(name = "activo", length = 1)
    private String activo;

    // Getters and setters

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerSistema() {
        return perSistema;
    }

    public void setPerSistema(String perSistema) {
        this.perSistema = perSistema;
    }

    public String getPerDesc() {
        return perDesc;
    }

    public void setPerDesc(String perDesc) {
        this.perDesc = perDesc;
    }

    public Timestamp getPerFcrea() {
        return perFcrea;
    }

    public void setPerFcrea(Timestamp perFcrea) {
        this.perFcrea = perFcrea;
    }

    public Timestamp getPerFmod() {
        return perFmod;
    }

    public void setPerFmod(Timestamp perFmod) {
        this.perFmod = perFmod;
    }

    public String getPerUcrea() {
        return perUcrea;
    }

    public void setPerUcrea(String perUcrea) {
        this.perUcrea = perUcrea;
    }

    public String getPerUmod() {
        return perUmod;
    }

    public void setPerUmod(String perUmod) {
        this.perUmod = perUmod;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}