package org.equipe_9.uniufc.domain.model.dto;

import java.math.BigDecimal;
import java.util.List;

public record DisciplinaDTO(
        Long id,
        String nome,
        String codigo,
        String ementa,
        Integer creditos,
        String tipo,
        List<DisciplinaDTO> preRequisito,
        CursoDTO curso,
        List<ProfessorDTO> professores
) {
    public record DisciplinaMiniatureDTO(
            String nomeDisciplina,
            String codigoDisciplina,
            BigDecimal mediaFinal,
            BigDecimal frequencia
    ) {}

    public record DisciplinasInfoDTO(
            String nome,
            String codigo
    ) {}
}
