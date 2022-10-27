package com.example.byma.services;

import lombok.AllArgsConstructor;
import com.example.byma.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.byma.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private final UsuarioRepository userDao;

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        userDao.findAll().forEach(usuarios::add);
        return usuarios;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return userDao.save(usuario);
    }


    @Override
    public Optional<Usuario> getUserById(Long userId) {
        return userDao.findById(userId);
    }

    @Override
    public Usuario updateUser(Long id, Usuario userToModify) {
        Usuario usuarioBuscado = userDao.findById(id).get();
        usuarioBuscado.setDni(userToModify.getDni());
        usuarioBuscado.setLocalidad(userToModify.getLocalidad());
        usuarioBuscado.setName(userToModify.getName());
        usuarioBuscado.setLast_name(userToModify.getLast_name());
        return userDao.save(usuarioBuscado);
    }

    @Override
    public boolean deleteUserById(Long id) {
        try{
            userDao.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
