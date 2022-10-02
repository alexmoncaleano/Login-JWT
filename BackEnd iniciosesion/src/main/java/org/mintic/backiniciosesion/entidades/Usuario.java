package org.mintic.backiniciosesion.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario")
    private Integer codUsuario;

    @Column(name = "tipo_documento_usuario")
    private String tipoDocumentoUsuario;

    @Column(name = "documento_usuario")
    private String documentoUsuario;

    @Column(name = "genero_usuario")
    private short generoUsuario;

    @Column(name = "nombres_usuario")
    private String nombresUsuario;

    @Column(name = "apellidos_usuario")
    private String apellidosUsuario;

    @Column(name = "telefono_usuario")
    private String telefonoUsuario;

    @JoinColumn(name = "cod_perfil", referencedColumnName = "cod_perfil")
    @ManyToOne(optional = false)
    private Perfil codPerfil;

    public Usuario() {
    }

    public Usuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Usuario(Integer codUsuario, String tipoDocumentoUsuario, String documentoUsuario, short generoUsuario, String nombresUsuario, String apellidosUsuario, String telefonoUsuario) {
        this.codUsuario = codUsuario;
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
        this.documentoUsuario = documentoUsuario;
        this.generoUsuario = generoUsuario;
        this.nombresUsuario = nombresUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.telefonoUsuario = telefonoUsuario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getTipoDocumentoUsuario() {
        return tipoDocumentoUsuario;
    }

    public void setTipoDocumentoUsuario(String tipoDocumentoUsuario) {
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public short getGeneroUsuario() {
        return generoUsuario;
    }

    public void setGeneroUsuario(short generoUsuario) {
        this.generoUsuario = generoUsuario;
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

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public Perfil getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(Perfil codPerfil) {
        this.codPerfil = codPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return !((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario)));
    }

    @Override
    public String toString() {
        return "org.mintic.backiniciosesion.entidades.Usuarios[ codUsuario=" + codUsuario + " ]";
    }

}
