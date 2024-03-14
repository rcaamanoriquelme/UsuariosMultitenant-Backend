package com.tesoreria.cyl.conciliacion.mediosdepago.consultatransacciones.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "cyl", name = "pw_usuario")
public class PwUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usuario", length = 38, nullable = false)
    @SequenceGenerator(name = "seq_id_usuario", sequenceName = "seq_id_usuario", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_usuario")
    private Long idUsuario;

    @Column(name = "id_perfil", length = 38, nullable = false)
    private Long idPerfil;

    @Column(name = "usu_login", length = 100)
    private String usuLogin;

    @Column(name = "usu_passwd", length = 100)
    private String usuPasswd;

    @Column(name = "usu_nombre", length = 100)
    private String usuNombre;

    @Column(name = "usu_apellido", length = 100)
    private String usuApellido;

    @Column(name = "usu_email", length = 100)
    private String usuEmail;

    @Column(name = "usu_fcrea")
    private Date usuFcrea;

    @Column(name = "usu_fmod")
    private Date usuFmod;

    @Column(name = "usu_ucrea", length = 100)
    private String usuUcrea;

    @Column(name = "usu_umod", length = 100)
    private String usuUmod;

    @Column(name = "activo", length = 1)
    private String activo;

    @Column(name = "usu_intentos")
    private Integer usuIntentos;

    @Column(name = "usu_fechaintentos")
    private Date usuFechaIntentos;

    @Column(name = "usu_bloqueado")
    private String usuBloqueado;

    @Column(name = "roles", length = 255)
    private String roles;

    // Otros campos si es necesario

    // Getters y Setters generados automáticamente
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPasswd() {
        return usuPasswd;
    }

    public void setUsuPasswd(String usuPasswd) {
        this.usuPasswd = usuPasswd;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public Date getUsuFcrea() {
        return usuFcrea;
    }

    public void setUsuFcrea(Date usuFcrea) {
        this.usuFcrea = usuFcrea;
    }

    public Date getUsuFmod() {
        return usuFmod;
    }

    public void setUsuFmod(Date usuFmod) {
        this.usuFmod = usuFmod;
    }

    public String getUsuUcrea() {
        return usuUcrea;
    }

    public void setUsuUcrea(String usuUcrea) {
        this.usuUcrea = usuUcrea;
    }

    public String getUsuUmod() {
        return usuUmod;
    }

    public void setUsuUmod(String usuUmod) {
        this.usuUmod = usuUmod;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Integer getUsuIntentos() {
        return usuIntentos;
    }

    public void setUsuIntentos(Integer usuIntentos) {
        this.usuIntentos = usuIntentos;
    }

    public Date getUsuFechaIntentos() {
        return usuFechaIntentos;
    }

    public void setUsuFechaIntentos(Date usuFechaIntentos) {
        this.usuFechaIntentos = usuFechaIntentos;
    }

    public String getUsuBloqueado() {
        return usuBloqueado;
    }

    public void setUsuBloqueado(String usuBloqueado) {
        this.usuBloqueado = usuBloqueado;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
