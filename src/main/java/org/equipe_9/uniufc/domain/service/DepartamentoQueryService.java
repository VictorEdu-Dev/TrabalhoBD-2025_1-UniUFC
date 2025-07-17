package org.equipe_9.uniufc.domain.service;

import org.equipe_9.uniufc.domain.exception.ResourceNotFoundException;
import org.equipe_9.uniufc.domain.model.dto.CursoDTO;
import org.equipe_9.uniufc.domain.model.dto.DepartamentoDTO.DepartamentoInfoDTO;
import org.equipe_9.uniufc.domain.model.dto.DepartamentoDTO.DepartamentoInfoDTO.DepartamentoInfoNonDistinctDTO;
import org.equipe_9.uniufc.domain.model.dto.DepartamentoDTO.CursoDepDTO;
import org.equipe_9.uniufc.domain.model.dto.ProfessorDTO;
import org.equipe_9.uniufc.domain.repository.DepartamentoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoQueryService {
    private DepartamentoDAO departamentoDAO;

    @Transactional
    public List<CursoDepDTO> getCursosDepartamento(String codigo) {
        return departamentoDAO.getCursosDepartamentoByCodigo(codigo);
    }


    public DepartamentoInfoDTO getDepartamentoInfo(String codigo) {
        Optional<DepartamentoInfoNonDistinctDTO> dep = departamentoDAO.getDepartamentoInfo(codigo);
        dep.orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado."));
        List<CursoDTO.CursoInfoDTO> cursosDep = departamentoDAO.getNomeCursosDepartamento(codigo);
        List<ProfessorDTO.ProfessoresInfoDTO> professoresDep = departamentoDAO.getProfessoresDepartamento(codigo);

        return DepartamentoInfoDTO.builder()
                .infoDepartamento(dep.get())
                .cursosOferecidos(cursosDep)
                .professores(professoresDep)
                .build();
    }


    @Autowired
    private void setDepartamentoDAO(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }
}
