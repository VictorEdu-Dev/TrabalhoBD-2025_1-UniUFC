package org.equipe_9.uniufc.domain.model;


import org.equipe_9.uniufc.domain.model.dto.UsuarioDTO;
import org.equipe_9.uniufc.domain.model.Usuario.Regra;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UniUserDetails implements UserDetails {

    private final UsuarioDTO user;

    public UniUserDetails(UsuarioDTO userDTO) {
        this.user = userDTO;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Regra role = user.regra();
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    public String getPassword() {
        return user.senha();
    }

    public String getUsername() {
        return user.login();
    }

    public Regra getRole() {
        return user.regra();
    }
}

