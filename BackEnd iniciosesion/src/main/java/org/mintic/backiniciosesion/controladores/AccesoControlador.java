package org.mintic.backiniciosesion.controladores;

import org.mintic.backiniciosesion.dtos.DTOAcceso;
import org.mintic.backiniciosesion.dtos.DTOAccesoRespuesta;
import org.mintic.backiniciosesion.seguridad.GenerarJWT;
import org.mintic.backiniciosesion.servicios.AccesoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/acceso")
@CrossOrigin(origins = "*")
public class AccesoControlador {

    @Autowired
    private AccesoServicio accesoServicio;

    @Autowired
    private GenerarJWT generarJWT;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/verificar", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Object> crearCategoria(@RequestBody DTOAcceso miObjeto) throws Exception {
        Short estadoInicial = 1;
        List<DTOAccesoRespuesta> arrUsuario = accesoServicio.verificarDatos(estadoInicial, miObjeto.getCorreo(), miObjeto.getClave());
        Map<String, Object> respuesta = new HashMap<>();

        if (arrUsuario.isEmpty()) {
            respuesta.put("status", HttpStatus.UNAUTHORIZED);
            respuesta.put("message", "Credenciales incorrectas");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta);
        } else {
            String miToken = generarJWT.obtener(arrUsuario);
            respuesta.put("status", HttpStatus.OK);
            respuesta.put("message", "Autenticación correcta");
            respuesta.put("token", miToken);

            return ResponseEntity.ok(respuesta);
        }
    }

}
