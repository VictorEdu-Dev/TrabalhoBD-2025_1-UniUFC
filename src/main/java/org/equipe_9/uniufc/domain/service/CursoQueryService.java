package org.equipe_9.uniufc.domain.service;

import org.equipe_9.uniufc.domain.model.dto.CursoDTO;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO;
import org.equipe_9.uniufc.domain.repository.CursoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoQueryService {
    private CursoDAO cursoDAO;

    public List<DisciplinaDTO.DisciplinasInfoDTO> getDisciplinasObrigatorias(String nomeCurso) {
        return cursoDAO.findDisciplinasObrigatorias(nomeCurso);
    }

    @Autowired
    private void setCursoDAO(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

}
