package org.equipe_9.uniufc.domain.repository;

import org.equipe_9.uniufc.domain.model.Departamento;
import org.equipe_9.uniufc.domain.model.dto.CursoDTO;
import org.equipe_9.uniufc.domain.model.dto.DepartamentoDTO.DepartamentoInfoDTO.DepartamentoInfoNonDistinctDTO;
import org.equipe_9.uniufc.domain.model.dto.DepartamentoDTO.CursoDepDTO;
import org.equipe_9.uniufc.domain.model.dto.ProfessorDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartamentoDAO extends CrudRepository<Departamento, Long> {


    @Query(value =
            "SELECT c.codigo AS codigoCurso, c.nome, c.creditos " +
            "FROM curso AS c " +
            "INNER JOIN departamento AS d ON d.id = c.departamento_id " +
            "WHERE d.codigo = :codigo",
            nativeQuery = true)
    List<CursoDepDTO> getCursosDepartamentoByCodigo(@Param("codigo") String codigo);

    @Query(value =
            "SELECT d.nome, d.codigo, COUNT(DISTINCT c.id) AS quantidadeCursos, COUNT(DISTINCT p.id) AS quantidadeProfessores " +
            "FROM departamento AS d " +
            "INNER JOIN curso AS c ON d.id = c.departamento_id " +
            "INNER JOIN professor AS p ON d.id = p.departamento_id " +
            "WHERE d.codigo = :codigo " +
            "GROUP BY d.nome, d.codigo",
            nativeQuery = true)
    Optional<DepartamentoInfoNonDistinctDTO> getDepartamentoInfo(@Param("codigo") String codigo);

    @Query(value =
            "SELECT c.nome AS nomeCurso " +
            "FROM curso AS c " +
            "INNER JOIN departamento AS d " +
            "ON c.departamento_id = d.id " +
            "WHERE d.codigo = :codDepart " +
            "ORDER BY c.nome",
            nativeQuery = true)
    List<CursoDTO.CursoInfoDTO> getNomeCursosDepartamento(@Param("codDepart") String codDepart);

    @Query(value =
            "SELECT p.full_name FROM professor AS p " +
            "INNER JOIN departamento AS d " +
            "ON p.departamento_id = d.id " +
            "WHERE d.codigo = :codDepart " +
            "ORDER BY p.full_name",
            nativeQuery = true)
    List<ProfessorDTO.ProfessoresInfoDTO> getProfessoresDepartamento(@Param("codDepart") String codDepart);


}