package org.equipe_9.uniufc.domain.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

public record ProfessorDTO(
        Long id,
        String siape,
        String nomeCompleto,
        LocalDateTime dataNascimento,
        LocalDateTime dataIngresso,
        Set<String> emails,
        Set<String> telefones,
        DepartamentoDTO departamento,
        UsuarioDTO usuario
) {
    public record ProfessoresInfoDTO(
            String nome
    ) {}
}
