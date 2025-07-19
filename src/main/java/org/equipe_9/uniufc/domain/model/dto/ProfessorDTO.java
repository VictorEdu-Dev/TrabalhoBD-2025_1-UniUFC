package org.equipe_9.uniufc.domain.model.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder(toBuilder = true)
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
    @Builder(toBuilder = true)
    public record ProfessoresInfoDTO(
            String nome
    ) {}

    @Builder(toBuilder = true)
    public record PDInfoDTO(
            ProfessoresDisciplinasInfoDTO info,
            List<ProfessoresDisciplinasInfoDTO.ProfessoresDisciplinasDTO> disciplinas
    ) {

        @Builder(toBuilder = true)
        public record ProfessoresDisciplinasInfoDTO(
                String nomeProfessor,
                BigDecimal somaCreditos
        ) {
            @Builder(toBuilder = true)
            public record ProfessoresDisciplinasDTO(
                    String nomeDisciplina,
                    String codigoDisciplina
            ) {
            }
        }
    }
}
