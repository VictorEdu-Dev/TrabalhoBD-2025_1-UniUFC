package org.equipe_9.uniufc.domain.restful;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.equipe_9.uniufc.domain.service.DisciplinaQueryService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Disciplinas", description = "Consultas relacionadas às disciplinas. Acesso permitido para usuários com uma das seguintes permissões: DBA, SERVIDOR, PROFESSOR.")
@RestController()
@RequestMapping("/uniufc")
public class DisciplinaQuery {
    private DisciplinaQueryService disciplinaQueryService;


    @Operation(
            summary = "Busca alunos matriculados em uma disciplina",
            description = "Retorna a lista de alunos matriculados na disciplina informada pelo parâmetro.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DisciplinaStrDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Parâmetro inválido ou ausente"),
                    @ApiResponse(responseCode = "404", description = "Disciplina não encontrada")
            }
    )
    @GetMapping(value = "/alunos-matriculados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunosDisciplina(
            @Parameter(description = "Código do departamento", required = true)
            @ParameterObject
            @Valid
            @ModelAttribute
            DisciplinaStrDTO disciplina) {
        return ResponseEntity.ok(disciplinaQueryService.findAlunosMatriculadosByDisciplina(disciplina.dis));
    }

    @Operation(
            summary = "Busca pré-requisitos de uma disciplina",
            description = "Retorna a lista de disciplinas pré-requisito para a disciplina informada.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de pré-requisitos retornada com sucesso",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DisciplinaStrDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Parâmetro inválido ou ausente"),
                    @ApiResponse(responseCode = "404", description = "Disciplina não encontrada")
            }
    )
    @GetMapping(value = "/pre-requisitos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasPR(
            @Parameter(description = "Código do departamento", required = true)
            @ParameterObject
            @Valid
            @ModelAttribute
            DisciplinaStrDTO disciplina) {
        return ResponseEntity.ok(disciplinaQueryService.findDisciplinasPRByDisciplina(disciplina.dis));
    }

    @Operation(
            summary = "Busca disciplinas abertas relacionadas a uma disciplina",
            description = "Retorna as disciplinas abertas vinculadas à disciplina informada.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de disciplinas abertas retornada com sucesso",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = DisciplinaStrDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Parâmetro inválido ou ausente"),
                    @ApiResponse(responseCode = "404", description = "Disciplina não encontrada")
            }
    )
    @GetMapping(value = "/open-disciplinas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasOpen(
            @Parameter(description = "Código do departamento", required = true)
            @ParameterObject
            @Valid
            @ModelAttribute
            DisciplinaStrDTO disciplina) {
        return ResponseEntity.ok(disciplinaQueryService.findDisciplinasOpenByDisciplina(disciplina.dis));
    }

    @Autowired
    private void setDisciplinaQueryService(DisciplinaQueryService disciplinaQueryService) {
        this.disciplinaQueryService = disciplinaQueryService;
    }

    public record DisciplinaStrDTO(
            @Schema(description = "Código da disciplina", example = "ECO0025", requiredMode = Schema.RequiredMode.REQUIRED)
            @NotBlank
            @Pattern(regexp = "^[A-Z]{3}\\d{4}$", message = "Código de disciplina inválido")
            String dis
    ) {}
}
