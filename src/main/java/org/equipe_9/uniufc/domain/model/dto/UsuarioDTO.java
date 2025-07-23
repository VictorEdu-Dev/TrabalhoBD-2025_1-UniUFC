package org.equipe_9.uniufc.domain.model.dto;

import lombok.Builder;
import org.equipe_9.uniufc.domain.model.Usuario.Regra;

@Builder(toBuilder = true)
public record UsuarioDTO(
        Long id,
        String nome,
        String login,
        String senha,
        Regra regra
) {
    @Builder(toBuilder = true)
    public record UsuarioRegisterDTO(
            String nome,
            String login,
            String senha
    ) {}
}
