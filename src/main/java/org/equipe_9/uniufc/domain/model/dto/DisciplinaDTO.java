package org.equipe_9.uniufc.domain.model.dto;

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
}
