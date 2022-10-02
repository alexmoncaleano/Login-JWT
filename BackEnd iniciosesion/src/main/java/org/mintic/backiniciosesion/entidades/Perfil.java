package org.mintic.backiniciosesion.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "perfiles")
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_perfil")
    private Integer codPerfil;

    @Column(name = "nombre_perfil")
    private String nombrePerfil;

    public Perfil() {
    }

    public Perfil(Integer codPerfil) {
        this.codPerfil = codPerfil;
    }

    public Perfil(Integer codPerfil, String nombrePerfil) {
        this.codPerfil = codPerfil;
        this.nombrePerfil = nombrePerfil;
    }

    public Integer getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(Integer codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPerfil != null ? codPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        return !((this.codPerfil == null && other.codPerfil != null) || (this.codPerfil != null && !this.codPerfil.equals(other.codPerfil)));
    }

    @Override
    public String toString() {
        return "org.mintic.backiniciosesion.entidades.Perfiles[ codPerfil=" + codPerfil + " ]";
    }

}
