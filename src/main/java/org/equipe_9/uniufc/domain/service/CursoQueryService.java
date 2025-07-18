package org.equipe_9.uniufc.domain.service;

import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoDTO.AlunoSimpleDTO;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO;
import org.equipe_9.uniufc.domain.repository.CursoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoQueryService {
    private CursoDAO cursoDAO;

    public List<DisciplinaDTO.DisciplinasInfoDTO> getDisciplinasByTipo(String nomeCurso, String tipo) {
        return cursoDAO.findDisciplinasObrigatorias(nomeCurso, tipo);
    }

    public List<AlunoSimpleDTO> findAlunosCurso(String nomeCurso) {
        return cursoDAO.findAlunosCurso(nomeCurso);
    }

    public List<AlunoSimpleDTO> findAlunosObrigatorias(String nomeCurso) {
        return cursoDAO.findAlunosObrigatorias(nomeCurso);
    }

    public List<AlunoSimpleDTO> findAlunosOptativas(String nomeCurso) {
        return cursoDAO.findAlunosCursoOp(nomeCurso);
    }

    @Autowired
    private void setCursoDAO(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }
}
