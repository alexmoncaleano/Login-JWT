package org.mintic.backiniciosesion.dtos;

import java.io.Serializable;

public class DTOAcceso implements Serializable {

    private String correo;
    private String clave;

    public DTOAcceso() {
    }

    public DTOAcceso(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
