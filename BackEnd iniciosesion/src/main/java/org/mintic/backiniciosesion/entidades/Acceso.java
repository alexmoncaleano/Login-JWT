package org.mintic.backiniciosesion.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accesos")
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_usuario")
    private Integer codUsuario;

    @Column(name = "estado_acceso")
    private short estadoAcceso;

    @Column(name = "correo_acceso")
    private String correoAcceso;

    @Column(name = "clave_acceso")
    private String claveAcceso;

    @Lob
    @Column(name = "avatar_acceso")
    private String avatarAcceso;

    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuarios;

    public Acceso() {
    }

    public Acceso(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Acceso(Integer codUsuario, short estadoAcceso, String correoAcceso, String claveAcceso, String avatarAcceso) {
        this.codUsuario = codUsuario;
        this.estadoAcceso = estadoAcceso;
        this.correoAcceso = correoAcceso;
        this.claveAcceso = claveAcceso;
        this.avatarAcceso = avatarAcceso;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public short getEstadoAcceso() {
        return estadoAcceso;
    }

    public void setEstadoAcceso(short estadoAcceso) {
        this.estadoAcceso = estadoAcceso;
    }

    public String getCorreoAcceso() {
        return correoAcceso;
    }

    public void setCorreoAcceso(String correoAcceso) {
        this.correoAcceso = correoAcceso;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getAvatarAcceso() {
        return avatarAcceso;
    }

    public void setAvatarAcceso(String avatarAcceso) {
        this.avatarAcceso = avatarAcceso;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        return !((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario)));
    }

    @Override
    public String toString() {
        return "org.mintic.backiniciosesion.entidades.Accesos[ codUsuario=" + codUsuario + " ]";
    }

}
