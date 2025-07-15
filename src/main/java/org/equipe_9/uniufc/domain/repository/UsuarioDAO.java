package org.equipe_9.uniufc.domain.repository;

import org.equipe_9.uniufc.domain.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String username);
}
