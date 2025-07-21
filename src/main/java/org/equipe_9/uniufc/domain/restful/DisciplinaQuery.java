package org.equipe_9.uniufc.domain.restful;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.equipe_9.uniufc.domain.service.DisciplinaQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Disciplinas", description = "Consultas relacionadas às disciplinas")
@RestController()
@RequestMapping("/uniufc")
public class DisciplinaQuery {
    private DisciplinaQueryService disciplinaQueryService;


    @GetMapping(value = "/alunos-matriculados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunosDisciplina(@RequestParam("dis") String disciplina) {
        return ResponseEntity.ok(disciplinaQueryService.findAlunosMatriculadosByDisciplina(disciplina));
    }

    @GetMapping(value = "/pre-requisitos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasPR(@RequestParam("dis") String disciplina) {
        return ResponseEntity.ok(disciplinaQueryService.findDisciplinasPRByDisciplina(disciplina));
    }

    @GetMapping(value = "/open-disciplinas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasOpen(@RequestParam("dis") String disciplina) {
        return ResponseEntity.ok(disciplinaQueryService.findDisciplinasOpenByDisciplina(disciplina));
    }

    @Autowired
    private void setDisciplinaQueryService(DisciplinaQueryService disciplinaQueryService) {
        this.disciplinaQueryService = disciplinaQueryService;
    }
}
