package org.equipe_9.uniufc.domain.restful;

import org.equipe_9.uniufc.domain.service.ProfessorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uniufc")
public class ProfessorQuery {
    private ProfessorQueryService professorQueryService;

    @GetMapping(value = "/professor-disciplinas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfessorDisciplinas(@RequestParam("identificador") String professor) {
        return ResponseEntity.ok(professorQueryService.findDisciplinasInfo(professor));
    }

    @GetMapping(value = "/professor-alunos", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfessorAlunos(@RequestParam("identificador") String professor) {
        return ResponseEntity.ok(professorQueryService.findAlunosByProfessor(professor));
    }

    @Autowired
    private void setProfessorQueryService(ProfessorQueryService professorQueryService) {
        this.professorQueryService = professorQueryService;
    }
}
