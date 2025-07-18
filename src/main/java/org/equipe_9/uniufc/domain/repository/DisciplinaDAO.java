package org.equipe_9.uniufc.domain.repository;

import org.equipe_9.uniufc.domain.model.Disciplina;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO.DisciplinasPRDTO;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO.AlunosMatriculadosDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisciplinaDAO extends CrudRepository<Disciplina, Long> {

    @Query(value =
            "SELECT a.nome FROM disciplina AS d " +
            "INNER JOIN aluno_has_disciplinas AS ahd ON d.id = ahd.disciplina_id " +
            "INNER JOIN alunos AS a ON a.id = ahd.aluno_id " +
            "WHERE (d.nome LIKE :disciplina OR d.codigo = :disciplina)",
    nativeQuery = true)
    List<AlunosMatriculadosDTO> findAlunosMatriculadosByDisciplina(@Param("disciplina") String disciplina);

    @Query(value =
            "SELECT d.nome, d.codigo " +
            "FROM disciplina AS d " +
            "WHERE d.id IN " +
                "(SELECT pr.disciplina_prerequisito_id " +
                "FROM disciplina AS d " +
                "INNER JOIN disciplina_prerequisito AS pr ON d.id = pr.disciplina_requerente_id " +
                "WHERE (d.nome = :disciplina OR d.codigo = :disciplina))",
            nativeQuery = true)
    List<DisciplinasPRDTO> findDisciplinasPR(@Param("disciplina") String disciplina);

    @Query(value =
            "SELECT d.nome, d.codigo " +
            "FROM disciplina AS d " +
            "WHERE d.id IN " +
                    "(SELECT pr.disciplina_requerente_id " +
                    "FROM disciplina AS d " +
                    "INNER JOIN disciplina_prerequisito AS pr ON d.id = pr.disciplina_prerequisito_id " +
                    "WHERE (d.nome = :disciplina OR d.codigo = :disciplina))",
            nativeQuery = true)
    List<DisciplinasPRDTO> findDisciplinasOpen(@Param("disciplina") String disciplina);
}
