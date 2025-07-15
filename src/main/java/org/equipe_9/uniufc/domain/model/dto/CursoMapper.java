package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.Curso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DepartamentoMapper.class)
public interface CursoMapper {
    CursoDTO toDTO(Curso curso);
    Curso toEntity(CursoDTO cursoDTO);
}
