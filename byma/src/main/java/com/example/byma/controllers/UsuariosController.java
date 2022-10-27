package com.example.byma.controllers;

import com.example.byma.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.byma.services.IUsuarioService;

@RequestMapping("/usuarios/api")
@RestController
public class UsuariosController {

    @Autowired
    IUsuarioService userService;


    @GetMapping
    public ResponseEntity<Usuario> listarUsuarios(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Long id){
        try {
            return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity(userService.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity modificarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuarioModificado){
        return new ResponseEntity(userService.updateUser(id, usuarioModificado), HttpStatus.OK);
    }
    @DeleteMapping({"/{id}"})
    public ResponseEntity eliminarUsuario(@PathVariable("id") Long id){
        boolean deleted = userService.deleteUserById(id);
        if(deleted){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
