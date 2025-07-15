package org.equipe_9.uniufc.domain.model.dto;

import org.equipe_9.uniufc.domain.model.AlunoGraduacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CursoMapper.class, UsuarioMapper.class, AlunoHasDisciplinaMapper.class})
public interface AlunoGraduacaoMapper {
    AlunoGraduacaoDTO toDTO(AlunoGraduacao alunoGraduacao);
    AlunoGraduacao toEntity(AlunoGraduacaoDTO alunoGraduacaoDTO);
}
