package org.equipe_9.uniufc.domain.model.dto;

import java.util.List;

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
}
