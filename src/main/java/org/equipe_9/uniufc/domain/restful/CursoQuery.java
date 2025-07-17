package org.equipe_9.uniufc.domain.restful;

import org.equipe_9.uniufc.domain.service.CursoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uniufc")
public class CursoQuery {
    private CursoQueryService cursoQueryService;

    @GetMapping(value = "/disciplinas-obrigatorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasObrigatorias(@RequestParam("curso") String nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.getDisciplinasObrigatorias(nomeCurso));
    }



    @Autowired
    private void  setCursoQueryService(CursoQueryService cursoQueryService) {
        this.cursoQueryService = cursoQueryService;
    }
}
