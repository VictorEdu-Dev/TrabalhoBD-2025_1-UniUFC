package org.equipe_9.uniufc.domain.service;

import org.equipe_9.uniufc.domain.model.AlunoGraduacao;
import org.equipe_9.uniufc.domain.model.Disciplina;
import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoDTO;
import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoMapper;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaMapper;
import org.equipe_9.uniufc.domain.repository.AlunoDAO;
import org.equipe_9.uniufc.domain.repository.DisciplinaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoQueryService {
    private AlunoDAO alunoDAO;
    private AlunoGraduacaoMapper alunoGraduacaoMapper;
    private DisciplinaDAO disciplinaDAO;
    private DisciplinaMapper disciplinaMapper;

    @Transactional
    public List<AlunoGraduacaoDTO> getAlunoGraduacao() {
        List<AlunoGraduacao> alunos = (List<AlunoGraduacao>) alunoDAO.findAll();
        return alunos
                .stream()
                .map(alunoGraduacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<DisciplinaDTO> getDisciplinas() {
        List<Disciplina> disciplinas = (List<Disciplina>) disciplinaDAO.findAll();
        return disciplinas
                .stream()
                .map(disciplinaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Autowired @Lazy
    private void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    @Autowired @Lazy
    private void setAlunoGraduacaoMapper(AlunoGraduacaoMapper alunoGraduacaoMapper) {
        this.alunoGraduacaoMapper = alunoGraduacaoMapper;
    }

    @Autowired @Lazy
    private void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }

    @Autowired @Lazy
    private void setDisciplinaMapper(DisciplinaMapper disciplinaMapper) {
        this.disciplinaMapper = disciplinaMapper;
    }
}
