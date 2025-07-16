package org.equipe_9.uniufc.domain.restful;

import org.equipe_9.uniufc.domain.service.AlunoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uniufc")
public class AlunoQuery {

    private AlunoQueryService alunoQueryService;

    @GetMapping(value = "/disciplinas-aluno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasByMat(@RequestParam("mat") String matricula) {
        return ResponseEntity.ok(alunoQueryService.getDisciciplinasByMat(matricula));
    }

    @GetMapping(value = "/disciplinas-concluidas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasConcluidasByMat(@RequestParam("mat") String matricula) {
        return ResponseEntity.ok(alunoQueryService.getDisciplinasConcluidasByMat(matricula));
    }

    @GetMapping(value = "/info-aluno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunoInfoByMat(@RequestParam("mat") String matricula) {
        return ResponseEntity.ok(alunoQueryService.getAlunoInfo(matricula));
    }

    @GetMapping(value = "/curso-aluno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCursoalunoByMat(@RequestParam("mat") String matricula) {
        return ResponseEntity.ok(alunoQueryService.getCursoByMat(matricula));
    }

    @Autowired
    private void setAlunoQueryService(AlunoQueryService alunoQueryService) {
        this.alunoQueryService = alunoQueryService;
    }
}
