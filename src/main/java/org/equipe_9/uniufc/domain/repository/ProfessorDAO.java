package org.equipe_9.uniufc.domain.repository;

import org.equipe_9.uniufc.domain.model.Professor;
import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoDTO.AlunoSimpleNMDTO;
import org.equipe_9.uniufc.domain.model.dto.ProfessorDTO.PDInfoDTO.ProfessoresDisciplinasInfoDTO.ProfessoresDisciplinasDTO;
import org.equipe_9.uniufc.domain.model.dto.ProfessorDTO.PDInfoDTO.ProfessoresDisciplinasInfoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessorDAO extends CrudRepository<Professor, Long> {


    @Query(value =
            "SELECT a.nome, a.matricula " +
            "FROM alunos a " +
            "INNER JOIN aluno_pos_graduacao apg ON a.id = apg.aluno_id " +
            "INNER JOIN professor p ON apg.professor_orientador_id = p.id " +
            "WHERE (p.siape = :id_orientador OR p.full_name = :id_orientador)",
            nativeQuery = true)
    List<AlunoSimpleNMDTO> findAlunosOrientados(@Param("id_orientador") String orientador);


    @Query(value =
            "SELECT d.nome AS nomeDisciplina, d.codigo AS codigoDisciplina " +
            "FROM professor p " +
            "INNER JOIN disciplina_has_professores dhpr ON dhpr.professor_id = p.id " +
            "INNER JOIN disciplina d ON dhpr.disciplina_id = d.id " +
            "WHERE (p.siape = :identificador OR p.full_name = :identificador)",
            nativeQuery = true)
    List<ProfessoresDisciplinasDTO> findDisciplinasByProfessor(@Param("identificador") String identificador);

    @Query(value =
            "SELECT p.full_name AS nomeProfessor, SUM(d.creditos) AS somaCreditos " +
            "FROM professor AS p " +
            "INNER JOIN disciplina_has_professores AS dhpr ON dhpr.professor_id = p.id " +
            "INNER JOIN disciplina AS d ON dhpr.disciplina_id = d.id " +
            "WHERE (p.siape = :identificador OR p.full_name = :identificador) " +
            "GROUP BY p.full_name",
            nativeQuery = true)
    Optional<ProfessoresDisciplinasInfoDTO> findTotalCreditos(@Param("identificador") String orientador);


}
