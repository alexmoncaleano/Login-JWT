package org.mintic.backiniciosesion.servicios;

import org.mintic.backiniciosesion.dtos.DTOAccesoRespuesta;
import org.mintic.backiniciosesion.repositorios.AccesoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.List;
import java.util.stream.Collectors;

@Service("serviceAccess")
public class AccesoServicio {

    @Autowired
    private AccesoRepositorio accesoRepo;

    public List<DTOAccesoRespuesta> verificarDatos(Short estado, String correo, String clave) {
        List<Tuple> miTupla = accesoRepo.consultaAcceso(estado, correo, clave);

        List<DTOAccesoRespuesta> miDTO = miTupla.stream().map(
                campo -> new DTOAccesoRespuesta(
                        campo.get(0, Integer.class),
                        campo.get(1, String.class),
                        campo.get(2, String.class),
                        campo.get(3, String.class),
                        campo.get(4, String.class),
                        campo.get(5, String.class)
                )).collect(Collectors.toList());

        return miDTO;
    }

}
