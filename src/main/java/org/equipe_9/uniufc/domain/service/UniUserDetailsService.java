package org.equipe_9.uniufc.domain.service;

import org.equipe_9.uniufc.domain.model.UniUserDetails;
import org.equipe_9.uniufc.domain.model.Usuario;
import org.equipe_9.uniufc.domain.model.dto.UsuarioDTO;
import org.equipe_9.uniufc.domain.model.dto.UsuarioMapper;
import org.equipe_9.uniufc.domain.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UniUserDetailsService implements UserDetailsService {
    private UsuarioDAO userDAO;
    private UsuarioMapper usuarioMapper;

    @Override
    public UniUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = userDAO.findByUsername(username);

        UsuarioDTO userDTO = usuarioMapper.toDTO(user.orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username)));
        return new UniUserDetails(userDTO);
    }

    @Autowired
    public void setUserDAO(UsuarioDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setUsuarioMapper(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }
}
