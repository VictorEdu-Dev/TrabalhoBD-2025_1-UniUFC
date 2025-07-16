package org.equipe_9.uniufc.domain.restful;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.equipe_9.uniufc.domain.model.dto.AlunoGraduacaoDTO;
import org.equipe_9.uniufc.domain.model.dto.DisciplinaDTO;
import org.equipe_9.uniufc.domain.service.AlunoQueryService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Aluno", description = "Consultas relacionadas ao aluno")
@Validated
@RestController
@RequestMapping("/uniufc")
public class AlunoQuery {

    private AlunoQueryService alunoQueryService;

    @Operation(summary = "Buscar disciplinas do aluno", description = "Retorna todas as disciplinas que o aluno está cursando ou cursou.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AlunoGraduacaoDTO.AGDisciplinasDTO.class)
            )),
            @ApiResponse(responseCode = "400", description = "Matrícula inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping(value = "/disciplinas-aluno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasByMat(
            @Parameter(description = "Matrícula do aluno", required = true)
            @ParameterObject
            @ModelAttribute
            MatriculaDTO matricula) {
        return ResponseEntity.ok(alunoQueryService.getDisciciplinasByMat(matricula.mat));
    }

    @Operation(summary = "Buscar disciplinas concluídas", description = "Retorna as disciplinas já concluídas pelo aluno.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DisciplinaDTO.DisciplinaMiniatureDTO.class)
            )),
            @ApiResponse(responseCode = "400", description = "Matrícula inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping(value = "/disciplinas-concluidas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDisciplinasConcluidasByMat(
            @Parameter(description = "Matrícula do aluno", required = true)
            @ParameterObject
            @ModelAttribute
            MatriculaDTO matricula) {
        return ResponseEntity.ok(alunoQueryService.getDisciplinasConcluidasByMat(matricula.mat));
    }

    @Operation(summary = "Buscar informações do aluno", description = "Retorna nome, endereço e telefones do aluno.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AlunoGraduacaoDTO.AlunoInfoDTO.class)
            )),
            @ApiResponse(responseCode = "400", description = "Matrícula inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping(value = "/info-aluno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlunoInfoByMat(
            @Parameter(description = "Matrícula do aluno", required = true)
            @ParameterObject
            @ModelAttribute
            MatriculaDTO matricula) {
        return ResponseEntity.ok(alunoQueryService.getAlunoInfo(matricula.mat));
    }

    @Operation(summary = "Buscar curso do aluno", description = "Retorna o curso atual em que o aluno está matriculado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso",  content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AlunoGraduacaoDTO.CursoAlunoDTO.class)
            )),
            @ApiResponse(responseCode = "400", description = "Matrícula inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping(value = "/curso-aluno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCursoalunoByMat(
            @Parameter(description = "Matrícula do aluno", required = true)
            @ParameterObject
            @ModelAttribute
            MatriculaDTO matricula) {
        return ResponseEntity.ok(alunoQueryService.getCursoByMat(matricula.mat));
    }

    @Autowired
    private void setAlunoQueryService(AlunoQueryService alunoQueryService) {
        this.alunoQueryService = alunoQueryService;
    }

    public record MatriculaDTO(
            @NotBlank(message = "Matrícula não pode ser vazia")
            @Pattern(regexp = "^[0-9]{6}$", message = "Matrícula deve conter exatamente 6 dígitos numéricos")
            String mat) {}
}
