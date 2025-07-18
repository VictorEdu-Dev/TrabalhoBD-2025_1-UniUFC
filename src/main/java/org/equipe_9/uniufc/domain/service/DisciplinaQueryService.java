package org.equipe_9.uniufc.domain.service;

import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO.DisciplinasPRDTO;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO.AlunosMatriculadosDTO;
import org.equipe_9.uniufc.domain.repository.DisciplinaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaQueryService {
    private DisciplinaDAO disciplinaDAO;


    public List<AlunosMatriculadosDTO> findAlunosMatriculadosByDisciplina(String disciplina) {
        return disciplinaDAO.findAlunosMatriculadosByDisciplina(disciplina);
    }

    public List<DisciplinasPRDTO> findDisciplinasPRByDisciplina(String disciplina) {
        return disciplinaDAO.findDisciplinasPR(disciplina);
    }

    public List<DisciplinasPRDTO> findDisciplinasOpenByDisciplina(String disciplina) {
        return disciplinaDAO.findDisciplinasOpen(disciplina);
    }


    @Autowired
    private void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }
}
