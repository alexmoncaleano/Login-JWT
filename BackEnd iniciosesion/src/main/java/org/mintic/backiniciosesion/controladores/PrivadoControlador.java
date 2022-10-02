package org.mintic.backiniciosesion.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/privado")
@CrossOrigin(origins = "*")
public class PrivadoControlador {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/prueba", method = RequestMethod.GET)
    public ResponseEntity<Object> crearCategoria(){
        return ResponseEntity.ok("Todo bien mano");
    }
}
