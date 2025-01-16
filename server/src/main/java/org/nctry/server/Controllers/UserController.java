package org.nctry.server.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/user")
public class UserController {
    private Map<String, Object> data;

    @GetMapping("/all")
    public ResponseEntity<Object> getAll() {
        /*TODO:
           1° Obtener todos los objetos
           2° Realizar paginacion
           3° Manejo de Excepciones si la lista está vacia
       */
        return null;
    }

    @GetMapping("/id")
    public ResponseEntity<Object> getByID(@RequestParam Long id) {
        /*
        TODO:
           1° Obtener una entidad en especifica
           2° Tirar los datos especificos necesarios del producto
           3° Manejo de Excepciones si el objeto no existe o el login no autoriza a dicho elemento
           4° Control de acceso
       */
        return null;
    }

    @GetMapping("/name")
    public ResponseEntity<Object> getByName(@RequestParam String name) {
        /*
        TODO:
           1° Obtener una lista de entidades correspondientes a name
           2° Realizar paginacion
           3° Manejo de Excepciones si el objeto no existe
           4° Control de Acceso
       */
        return null;
    }
}
