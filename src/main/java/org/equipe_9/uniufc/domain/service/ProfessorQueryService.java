package org.equipe_9.uniufc.domain.service;

import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoDTO.AlunoSimpleNMDTO;
import org.equipe_9.uniufc.domain.model.dto.ProfessorDTO.PDInfoDTO;
import org.equipe_9.uniufc.domain.model.dto.ProfessorDTO.PDInfoDTO.ProfessoresDisciplinasInfoDTO.ProfessoresDisciplinasDTO;
import org.equipe_9.uniufc.domain.repository.ProfessorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorQueryService {
    private ProfessorDAO professorDAO;

    public PDInfoDTO findDisciplinasInfo(String professor) {
        List<ProfessoresDisciplinasDTO> disciplinas = professorDAO.findDisciplinasByProfessor(professor);
        PDInfoDTO.ProfessoresDisciplinasInfoDTO somaCreditos = professorDAO.findTotalCreditos(professor).orElse(null);
        return PDInfoDTO.builder()
                .info(somaCreditos)
                .disciplinas(disciplinas)
                .build();
    }

    public List<AlunoSimpleNMDTO> findAlunosByProfessor(String professor) {
        return professorDAO.findAlunosOrientados(professor);
    }

    @Autowired
    private void setProfessorDAO(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }
}
