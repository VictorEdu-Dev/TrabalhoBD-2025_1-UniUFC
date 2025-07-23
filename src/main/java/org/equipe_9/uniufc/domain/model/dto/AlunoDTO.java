package org.equipe_9.uniufc.domain.model.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Builder(toBuilder = true)
public record AlunoDTO(
        Long id,
        String matricula,
        String nome,
        String endereco,
        CursoDTO curso,
        UsuarioDTO usuario,
        List<AlunoHasDisciplinaDTO> disciplinas,
        List<AlunoGraduacaoDTO.TelefoneAlunoDTO> telefones
) {
    @Builder(toBuilder = true)
    public record AlunoRegisterDTO(
            UsuarioDTO.UsuarioRegisterDTO usuario,
            String matricula,
            String nome,
            String endereco,
            String cursoNomeCodigo,
            LocalDate dataIngresso,
            List<String> disciplinas,
            Set<AlunoGraduacaoDTO.TelefoneAlunoDTO> telefones
    ) {
    }
}
