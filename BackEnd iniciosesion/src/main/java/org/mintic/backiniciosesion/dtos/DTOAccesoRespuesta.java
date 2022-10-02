package org.mintic.backiniciosesion.dtos;

import java.io.Serializable;

public class DTOAccesoRespuesta implements Serializable {

    private Integer codUsuario;
    private String nombrePerfil;
    private String nombresUsuario;
    private String apellidosUsuario;
    private String correoUsuario;
    private String avatarAcceso;

    public DTOAccesoRespuesta() {
    }

    public DTOAccesoRespuesta(Integer codUsuario, String nombrePerfil, String nombresUsuario, String apellidosUsuario, String correoUsuario, String avatarAcceso) {
        this.codUsuario = codUsuario;
        this.nombrePerfil = nombrePerfil;
        this.nombresUsuario = nombresUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.correoUsuario = correoUsuario;
        this.avatarAcceso = avatarAcceso;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getAvatarAcceso() {
        return avatarAcceso;
    }

    public void setAvatarAcceso(String avatarAcceso) {
        this.avatarAcceso = avatarAcceso;
    }

}
