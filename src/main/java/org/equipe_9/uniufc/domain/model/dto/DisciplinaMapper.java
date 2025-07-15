package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.Disciplina;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CursoMapper.class, ProfessorMapper.class})
public interface DisciplinaMapper {
    DisciplinaDTO toDTO(Disciplina disciplina);
    Disciplina toEntity(DisciplinaDTO disciplinaDTO);
}
