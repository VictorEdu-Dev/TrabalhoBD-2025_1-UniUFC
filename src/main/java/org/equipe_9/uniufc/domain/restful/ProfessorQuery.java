package org.equipe_9.uniufc.domain.restful;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.equipe_9.uniufc.domain.service.ProfessorQueryService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Professores", description = "Consultas relacionadas aos professores. Acesso permitido para usuários com as regras: DBA, SERVIDOR, PROFESSOR.")
@RestController
@RequestMapping("/uniufc")
public class ProfessorQuery {
    private ProfessorQueryService professorQueryService;

    @Operation(
            summary = "Retorna as disciplinas vinculadas a um professor",
            description = "Consulta as disciplinas que o professor, identificado pelo parâmetro, ministra.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Disciplinas retornadas com sucesso",
                            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProfessorStrDTO.class)
                            )}
                    ),
                    @ApiResponse(responseCode = "400", description = "Parâmetro inválido ou ausente"),
                    @ApiResponse(responseCode = "404", description = "Professor não encontrado")
            }
    )
    @GetMapping(
            value = "/professor-disciplinas",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfessorDisciplinas(
            @Parameter(description = "SIAPE ou nome extao do professor", required = true)
            @ModelAttribute
            @ParameterObject
            @Valid
            ProfessorStrDTO professor) {
        return ResponseEntity.ok(professorQueryService.findDisciplinasInfo(professor.siape));
    }

    @Operation(
            summary = "Retorna alunos da pós-graduação vinculados a um professor orientador",
            description = "Consulta os alunos associados ao professor identificado pelo parâmetro.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Alunos retornados com sucesso",
                            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ProfessorStrDTO.class)
                            ) }
                    ),
                    @ApiResponse(responseCode = "400", description = "Parâmetro inválido ou ausente"),
                    @ApiResponse(responseCode = "404", description = "Professor não encontrado")
            }
    )
    @GetMapping(
            value = "/professor-alunos",
            produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfessorAlunos(
            @Parameter(description = "SIAPE ou nome extao do professor", required = true)
            @ModelAttribute
            @ParameterObject
            @Valid
            ProfessorStrDTO professor) {
        return ResponseEntity.ok(professorQueryService.findAlunosByProfessor(professor.siape));
    }

    @Autowired
    private void setProfessorQueryService(ProfessorQueryService professorQueryService) {
        this.professorQueryService = professorQueryService;
    }

    public record ProfessorStrDTO(
            @Schema(description = "SIAPE ou nome exato do professor", example = "111111")
            @Pattern(regexp = "^[0-9]{6}$|^[a-zA-Z\\s]+$",
                     message = "O SIAPE deve conter 6 dígitos ou o nome do professor.")
            String siape
    ) {}
}
