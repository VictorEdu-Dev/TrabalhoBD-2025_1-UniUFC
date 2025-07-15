package org.equipe_9.uniufc.domain.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record AlunoGraduacaoDTO(
        Long id,
        String matricula,
        String nome,
        String endereco,
        CursoDTO curso,
        UsuarioDTO usuario,
        List<AlunoHasDisciplinaDTO> disciplinas,
        Set<TelefoneAlunoDTO> telefones,
        LocalDateTime dataIngresso
) {
    public record TelefoneAlunoDTO(String numero, String descricao) {}
}