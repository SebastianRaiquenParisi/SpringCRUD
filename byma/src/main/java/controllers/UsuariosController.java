package controllers;

import models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.IUsuarioService;

import java.util.List;

@RequestMapping("/usuarios/api")
@RestController
public class UsuariosController {

    @Autowired
    IUsuarioService userService;


    @RequestMapping(value = "", method=RequestMethod.GET)
    public ResponseEntity<Usuario> listarUsuarios(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Long id){
        try {
            return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity(userService.save(usuario), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity modificarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuarioModificado){
        return new ResponseEntity(userService.updateUser(id, usuarioModificado), HttpStatus.OK);
    }
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity eliminarUsuario(@PathVariable("id") Long id){
        boolean deleted = userService.deleteUserById(id);
        if(deleted){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
