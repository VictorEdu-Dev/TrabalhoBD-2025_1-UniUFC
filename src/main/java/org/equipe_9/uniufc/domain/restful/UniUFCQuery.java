package org.equipe_9.uniufc.domain.restful;

import org.equipe_9.uniufc.domain.service.AlunoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uniufc")
public class UniUFCQuery {
    private AlunoQueryService alunoQueryService;


    public ResponseEntity<?> getAlunosGraduacao() {
        return ResponseEntity.ok(alunoQueryService.getAlunoGraduacao());
    }

    public ResponseEntity<?> getDisciplinas() {
        return ResponseEntity.ok(alunoQueryService.getDisciplinas());
    }

    @Autowired @Lazy
    private void setAlunoQueryService(AlunoQueryService alunoQueryService) {
        this.alunoQueryService = alunoQueryService;
    }
}
