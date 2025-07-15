package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.Aluno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CursoMapper.class, UsuarioMapper.class, AlunoHasDisciplinaMapper.class})
public interface AlunoMapper {
    AlunoDTO toDTO(Aluno aluno);
    Aluno toEntity(AlunoDTO alunoDTO);
}
