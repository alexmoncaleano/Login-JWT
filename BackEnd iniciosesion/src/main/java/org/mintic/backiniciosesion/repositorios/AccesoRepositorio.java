package org.mintic.backiniciosesion.repositorios;

import org.mintic.backiniciosesion.entidades.Acceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface AccesoRepositorio extends JpaRepository<Acceso, Integer> {

    @Query(nativeQuery = true, name = "Acceso.verificar")
    public List<Tuple> consultaAcceso(
            @Param("est") Short estado,
            @Param("cor") String correo,
            @Param("cla") String clave
    );
}
