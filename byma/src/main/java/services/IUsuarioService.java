package services;

import models.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    Optional<Usuario> getUserById(Long userId);
    Usuario updateUser(Long id, Usuario userToModify);
    boolean deleteUserById(Long id);
}
