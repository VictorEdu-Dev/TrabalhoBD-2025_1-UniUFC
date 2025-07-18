package org.equipe_9.uniufc.domain.model.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder(toBuilder = true)
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
    @Builder(toBuilder = true)
    public record TelefoneAlunoDTO(String numero, String descricao) {}

    @Builder(toBuilder = true)
    public record AGDisciplinasDTO(
            String nomeDisciplina,
            String codigoDisciplina,
            Integer creditosDisciplina
    ) {}

    @Builder(toBuilder = true)
    public record CursoAlunoDTO(
            String nome,
            String matricula,
            String curso,
            String codigoCurso
    ) {}

    @Builder(toBuilder = true)
    public record AlunoInfoNonDistinctDTO(
            String nome,
            String endereco,
            String telefone,
            String descricao
    ) {}

    @Builder(toBuilder = true)
    public record AlunoInfoDTO(
            String nome,
            String endereco,
            Set<TelefoneAlunoDTO> telefones
    ) {}

    @Builder(toBuilder = true)
    public record AlunoSimpleDTO(
            String nome
    ) {}
}