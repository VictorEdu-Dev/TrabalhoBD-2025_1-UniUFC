package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.Usuario.Regra;

public record UsuarioDTO(
        Long id,
        String nome,
        String login,
        String senha,
        Regra regra
) {
}
