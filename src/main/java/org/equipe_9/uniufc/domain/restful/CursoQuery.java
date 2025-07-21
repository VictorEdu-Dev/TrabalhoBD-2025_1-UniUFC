package org.equipe_9.uniufc.domain.restful;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.equipe_9.uniufc.domain.service.CursoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cursos", description = "Consultas relacionadas aos cursos")
@RestController
@RequestMapping("/uniufc")
public class CursoQuery {
    private CursoQueryService cursoQueryService;

    @GetMapping(value = "/disciplinas-obrigatorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasObrigatorias(@RequestParam("curso") Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.getDisciplinasByTipo(nomeCurso.getNome(), "OBRIGATORIA"));
    }

    @GetMapping(value = "/disciplinas-optativas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasOptativas(@RequestParam("curso") Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.getDisciplinasByTipo(nomeCurso.getNome(), "OPTATIVA"));
    }

    @GetMapping(value = "/alunos-curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunosCurso(@RequestParam("curso") Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.findAlunosCurso(nomeCurso.getNome()));
    }

    @GetMapping(value = "/alunos-curso-obrigatorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunosCursoOp(@RequestParam("curso") Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.findAlunosObrigatorias(nomeCurso.getNome()));
    }

    @GetMapping(value = "/alunos-curso-optativas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunosCursoOb(@RequestParam("curso") Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.findAlunosOptativas(nomeCurso.getNome()));
    }

    @Autowired
    private void  setCursoQueryService(CursoQueryService cursoQueryService) {
        this.cursoQueryService = cursoQueryService;
    }

    public enum Curso {
        ENG_COMPT("Engenharia de Computação"),
        ENG_ELET("Engenharia Elétrica"),
        ODONTO("Odontologia");

        private final String curso;

        Curso(String curso) {
            this.curso = curso;
        }

        public String getNome() {
            return curso;
        }
    }
}
