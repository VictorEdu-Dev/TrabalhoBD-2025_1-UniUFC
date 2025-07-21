package org.equipe_9.uniufc.domain.repository;

import org.equipe_9.uniufc.domain.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
    @Query("SELECT u FROM usuario u WHERE u.login = :username")
    Optional<Usuario> findByUsername(@Param("username") String username);
}
