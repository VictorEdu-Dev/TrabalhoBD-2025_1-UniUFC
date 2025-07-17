package org.equipe_9.uniufc.domain.repository;

import org.equipe_9.uniufc.domain.model.Curso;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO.DisciplinasInfoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoDAO extends CrudRepository<Curso, Long> {
    @Query(
            value = "SELECT DISTINCT d.nome, d.codigo " +
                    "FROM disciplina AS d " +
                    "INNER JOIN curso AS c " +
                    "ON d.curso_id = c.id " +
                    "WHERE d.tipo = 'OBRIGATORIA' AND (c.nome = :nomeCurso OR c.codigo = :nomeCurso OR c.nome LIKE :nomeCurso)",
            nativeQuery = true)
    List<DisciplinasInfoDTO> findDisciplinasObrigatorias(@Param("nomeCurso") String nomeCurso);

}
