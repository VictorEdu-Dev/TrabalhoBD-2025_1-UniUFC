package org.equipe_9.uniufc.domain.repository;

import org.equipe_9.uniufc.domain.model.Curso;
import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoDTO.AlunoSimpleDTO;
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
                    "WHERE d.tipo = :tipo AND (c.nome = :nomeCurso OR c.codigo = :nomeCurso OR c.nome LIKE :nomeCurso)",
            nativeQuery = true)
    List<DisciplinasInfoDTO> findDisciplinasObrigatorias(@Param("nomeCurso") String nomeCurso, @Param("tipo") String tipo);


    @Query(value =
                    "SELECT a.nome " +
                    "FROM alunos a " +
                    "JOIN curso c ON a.curso_id = c.id " +
                    "WHERE (c.nome = :nomeCurso OR c.codigo = :nomeCurso) " +
                    "AND NOT EXISTS ( " +
                    "    SELECT 1 " +
                    "    FROM disciplina d " +
                    "    WHERE d.curso_id = c.id AND d.tipo = 'OBRIGATORIA'" +
                    "    AND d.id NOT IN ( " +
                    "        SELECT ad.disciplina_id " +
                    "        FROM aluno_has_disciplinas ad " +
                    "        WHERE ad.aluno_id = a.id " +
                    "))",
            nativeQuery = true)
    List<AlunoSimpleDTO> findAlunosObrigatorias(@Param("nomeCurso") String nomeCurso);

    @Query(value =
            "SELECT a.nome " +
                    "FROM curso AS c " +
                    "INNER JOIN alunos AS a " +
                    "ON a.curso_id = c.id  " +
                    "WHERE (c.nome = :nomeCurso OR c.codigo = :nomeCurso)",
            nativeQuery = true)
    List<AlunoSimpleDTO> findAlunosCurso(@Param("nomeCurso") String nomeCurso);

    @Query(value =
            "SELECT a.nome " +
                    "FROM alunos a " +
                    "JOIN curso c ON a.curso_id = c.id " +
                    "WHERE (c.nome = :nomeCurso OR c.codigo = :nomeCurso) " +
                    "AND NOT EXISTS ( " +
                    "    SELECT 1 " +
                    "    FROM aluno_has_disciplinas ahd " +
                    "    JOIN disciplina d ON d.id = ahd.disciplina_id " +
                    "    WHERE ahd.aluno_id = a.id AND d.tipo = 'OPTATIVA' AND d.curso_id = c.id " +
                    ")",
            nativeQuery = true)
    List<AlunoSimpleDTO>  findAlunosCursoOp(@Param("nomeCurso") String nomeCurso);
}
