package org.equipe_9.uniufc.domain.model.dto;

import lombok.Builder;

import java.util.List;
@Builder(toBuilder = true)
public record DepartamentoDTO(
        Long id,
        String nome,
        String codigo
) {
    @Builder(toBuilder = true)
    public record CursoDepDTO(
            String codigoCurso,
            String nome,
            Integer creditos
    ) {}
    @Builder(toBuilder = true)
    public record DepartamentoInfoDTO(
            DepartamentoInfoNonDistinctDTO infoDepartamento,
            List<CursoDTO.CursoInfoDTO> cursosOferecidos,
            List<ProfessorDTO.ProfessoresInfoDTO> professores
    ) {
        @Builder(toBuilder = true)
        public record DepartamentoInfoNonDistinctDTO(
                String nome,
                String codigo,
                Long quantidadeCursos,
                Long quantidadeprofessores
        ) {}
    }
}
