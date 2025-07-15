package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DepartamentoMapper.class, UsuarioMapper.class})
public interface ProfessorMapper {
    ProfessorDTO toDTO(Professor professor);
    Professor toEntity(ProfessorDTO professorDTO);
}
