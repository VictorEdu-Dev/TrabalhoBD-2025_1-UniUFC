package org.equipe_9.uniufc.domain.repository;

import org.equipe_9.uniufc.domain.model.AlunoGraduacao;
import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoDTO.AlunoInfoNonDistinctDTO;
import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoDTO.CursoAlunoDTO;
import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoDTO.AGDisciplinasDTO;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO.DisciplinaMiniatureDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlunoDAO extends CrudRepository<AlunoGraduacao, Long> {
    @Query(value = "SELECT d.nome AS nome_disciplina, d.codigo AS codigo_disciplina, d.creditos AS creditos_disciplina " +
            "FROM alunos a " +
            "JOIN aluno_has_disciplinas ahd ON a.id = ahd.aluno_id " +
            "JOIN disciplina d ON ahd.disciplina_id = d.id " +
            "WHERE a.matricula = :matricula", nativeQuery = true)
    List<AGDisciplinasDTO> getDisciplinasByMatricula(@Param("matricula") String matricula);

    @Query(value = "SELECT d.nome AS nome_disciplina, d.codigo AS codigo_disciplina, ahd.media_final, ahd.frequencia " +
            "FROM alunos a " +
            "JOIN aluno_has_disciplinas ahd ON a.id = ahd.aluno_id " +
            "JOIN disciplina d ON ahd.disciplina_id = d.id " +
            "WHERE a.matricula = :matricula " +
            "AND ahd.media_final >= 7.00 " +
            "AND ahd.frequencia >= 0.75", nativeQuery = true)
    List<DisciplinaMiniatureDTO> getDisciplinasConcluidasByMatricula(@Param("matricula") String matricula);

    @Query(value = "SELECT a.nome, a.matricula, c.nome AS curso, c.codigo AS codigoCurso FROM alunos AS a " +
            "INNER JOIN curso AS c ON c.id = a.curso_id " +
            "WHERE a.matricula = :matricula", nativeQuery = true)
    Optional<CursoAlunoDTO> getCursoByMatricula(@Param("matricula") String matricula);

    @Query(value = "SELECT a.nome, a.endereco, t.telefone, t.descricao " +
            "FROM alunos AS a " +
            "LEFT JOIN telefones_aluno AS t ON t.aluno_id = a.id " +
            "WHERE a.matricula = :matricula", nativeQuery = true)
    List<AlunoInfoNonDistinctDTO> findAlunoInfoByMatricula(@Param("matricula") String matricula);

    AlunoGraduacao findByUsuarioId(Long userIdToDelete);
}
