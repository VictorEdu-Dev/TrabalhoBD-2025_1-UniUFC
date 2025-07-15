package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.Departamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CursoMapper.class, ProfessorMapper.class})
public interface DepartamentoMapper {
    DepartamentoDTO toDTO(Departamento departamento);
    Departamento toEntity(DepartamentoDTO departamentoDTO);
}
