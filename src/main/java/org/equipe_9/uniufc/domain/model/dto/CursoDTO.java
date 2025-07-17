package org.equipe_9.uniufc.domain.model.dto;

public record CursoDTO(
        Long id,
        String codigo,
        String nome,
        Integer creditos,
        DepartamentoDTO departamento
) {
    public record CursoInfoDTO(
            String nome
    ) {}
}
