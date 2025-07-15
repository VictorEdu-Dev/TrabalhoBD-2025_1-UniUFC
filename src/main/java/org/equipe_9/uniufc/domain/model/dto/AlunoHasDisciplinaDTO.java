package org.equipe_9.uniufc.domain.model.dto;

import java.math.BigDecimal;

public record AlunoHasDisciplinaDTO(
        AlunoDisciplinaId ids,
        DisciplinaDTO disciplina,
        BigDecimal mediaFinal,
        BigDecimal frequencia
) {
    public record AlunoDisciplinaId(
            Long alunoId,
            Long disciplinaId
    ) {}
}
