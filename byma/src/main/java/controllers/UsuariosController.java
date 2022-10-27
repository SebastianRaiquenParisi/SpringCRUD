package controllers;

import models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.IUsuarioService;

import java.util.List;

@RequestMapping("/usuarios")
@RestController
public class UsuariosController {

    @Autowired
    IUsuarioService userService;


    @RequestMapping(value = "", method=RequestMethod.GET)
    public ResponseEntity<Usuario> get(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Usuario usuario){
        return new ResponseEntity(userService.save(usuario), HttpStatus.CREATED);
    }


}
