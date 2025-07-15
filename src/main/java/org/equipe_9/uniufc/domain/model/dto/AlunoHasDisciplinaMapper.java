package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.AlunoHasDisciplina;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DisciplinaMapper.class})
public interface AlunoHasDisciplinaMapper {
    AlunoHasDisciplinaDTO toDTO(AlunoHasDisciplina alunoHasDisciplina);
    AlunoHasDisciplina toEntity(AlunoHasDisciplinaDTO alunoHasDisciplinaDTO);
}
