package org.equipe_9.uniufc.domain.restful;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.equipe_9.uniufc.domain.service.CursoQueryService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cursos", description = "Retorna as disciplinas já concluídas pelo aluno. Acesso permitido para usuários com as regras: DBA, SERVIDOR, PROFESSOR, ALUNO.")
@Validated
@RestController
@RequestMapping("/uniufc")
public class CursoQuery {
    private CursoQueryService cursoQueryService;

    @Operation(
            summary = "Obter disciplinas obrigatórias de um curso",
            description = "Retorna a lista de disciplinas obrigatórias associadas ao curso especificado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Disciplinas obrigatórias retornadas com sucesso",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Curso.class)
                    ),
                            @Content(mediaType = MediaType.APPLICATION_XML_VALUE,
                                    schema = @Schema(implementation = Curso.class)
                            ) }),
            @ApiResponse(responseCode = "400", description = "Curso inválido", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    @GetMapping(value = "/disciplinas-obrigatorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasObrigatorias(
            @Parameter(
                    description = "Nome do curso para buscar as disciplinas obrigatórias",
                    required = true,
                    example = "Engenharia de Computação",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", allowableValues = {"Engenharia de Computação", "Engenharia Elétrica", "Odontologia"})
            )
            @ModelAttribute
            @ParameterObject
            @Valid
            Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.getDisciplinasByTipo(nomeCurso.curso, "OBRIGATORIA"));
    }

    @Operation(
            summary = "Obter disciplinas optativas de um curso",
            description = "Retorna a lista de disciplinas optativas associadas ao curso especificado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Disciplinas optativas retornadas com sucesso",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Curso.class)
                    ),
                            @Content(mediaType = MediaType.APPLICATION_XML_VALUE,
                                    schema = @Schema(implementation = Curso.class)
                            ) }),
            @ApiResponse(responseCode = "400", description = "Curso inválido", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    @GetMapping(value = "/disciplinas-optativas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasOptativas(
            @Parameter(
                    description = "Nome do curso para buscar as disciplinas optativas",
                    required = true,
                    example = "ENG_COMPT",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", allowableValues = {"ENG_COMPT", "ENG_ELET", "ODONTO"})
            )
            @ModelAttribute
            @ParameterObject
            @Valid
            Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.getDisciplinasByTipo(nomeCurso.curso, "OPTATIVA"));
    }

    @Operation(
            summary = "Listar alunos matriculados em um curso",
            description = "Retorna a lista de alunos matriculados no curso especificado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alunos retornados com sucesso",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Curso.class)
                    ),
                            @Content(mediaType = MediaType.APPLICATION_XML_VALUE,
                                    schema = @Schema(implementation = Curso.class)
                            ) }),
            @ApiResponse(responseCode = "400", description = "Curso inválido", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    @GetMapping(value = "/alunos-curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunosCurso(
            @Parameter(
                    description = "Nome do curso para buscar alunos",
                    required = true,
                    example = "ENG_COMPT",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", allowableValues = {"ENG_COMPT", "ENG_ELET", "ODONTO"})
            )
            @ModelAttribute
            @ParameterObject
            @Valid
            Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.findAlunosCurso(nomeCurso.curso));
    }

    @Operation(
            summary = "Listar alunos matriculados em disciplinas obrigatórias de um curso",
            description = "Retorna a lista de alunos matriculados nas disciplinas obrigatórias do curso especificado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alunos em disciplinas obrigatórias retornados com sucesso",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Curso.class)
                    ),
                            @Content(mediaType = MediaType.APPLICATION_XML_VALUE,
                                    schema = @Schema(implementation = Curso.class)
                            ) }),
            @ApiResponse(responseCode = "400", description = "Curso inválido", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    @GetMapping(value = "/alunos-curso-obrigatorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunosCursoOp(
            @Parameter(
                    description = "Nome do curso para buscar alunos em disciplinas obrigatórias",
                    required = true,
                    example = "ENG_COMPT",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", allowableValues = {"ENG_COMPT", "ENG_ELET", "ODONTO"})
            )
            @ModelAttribute
            @ParameterObject
            @Valid
            Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.findAlunosObrigatorias(nomeCurso.curso));
    }

    @Operation(
            summary = "Listar alunos matriculados em disciplinas optativas de um curso",
            description = "Retorna a lista de alunos matriculados nas disciplinas optativas do curso especificado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alunos em disciplinas optativas retornados com sucesso",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Curso.class)
                    ),
                            @Content(mediaType = MediaType.APPLICATION_XML_VALUE,
                                    schema = @Schema(implementation = Curso.class)
                            ) }),
            @ApiResponse(responseCode = "400", description = "Curso inválido", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    @GetMapping(value = "/alunos-curso-optativas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunosCursoOb(
            @Parameter(
                    description = "Nome do curso para buscar alunos em disciplinas optativas",
                    required = true,
                    example = "ENG_COMPT",
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", allowableValues = {"ENG_COMPT", "ENG_ELET", "ODONTO"})
            )
            @ModelAttribute
            @ParameterObject
            @Valid
            Curso nomeCurso) {
        return ResponseEntity.ok(cursoQueryService.findAlunosOptativas(nomeCurso.curso));
    }

    @Autowired
    private void  setCursoQueryService(CursoQueryService cursoQueryService) {
        this.cursoQueryService = cursoQueryService;
    }

    public record Curso(
            @Parameter(description = "Nome do curso", required = true, example = "Engenharia de Computação")
            String curso) {
    }
}
