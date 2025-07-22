package org.equipe_9.uniufc.domain.restful;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.equipe_9.uniufc.domain.model.dto.DepartamentoDTO;
import org.equipe_9.uniufc.domain.service.DepartamentoQueryService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Departamentos", description = "Consultas relacionadas aos departamentos. Acesso permitido para usuários com as regras: DBA, SERVIDOR.")
@Validated
@RestController
@RequestMapping("/uniufc")
public class DepartamentoQuery {
    private DepartamentoQueryService departamentoQueryService;

    @Operation(summary = "Buscar cursos de um departamento", description = "Retorna todos os cursos existentes em um departamento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DepartamentoDTO.CursoDepDTO.class)
            )),
            @ApiResponse(responseCode = "400", description = "Departamento inválido"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/cursos-dep")
    public ResponseEntity<?> getCursosDepartamento(
            @Parameter(description = "Código do departamento", required = true)
            @ParameterObject
            @Valid
            @ModelAttribute
            CodigoDepartDTO codigo) {
        return ResponseEntity.ok(departamentoQueryService.getCursosDepartamento(codigo.dep));
    }

    @Operation(summary = "Buscar informações de um departamento", description = "Retorna informações úteis de um departamento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DepartamentoDTO.CursoDepDTO.class)
            )),
            @ApiResponse(responseCode = "400", description = "Departamento inválido"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/departamento-info")
    public ResponseEntity<?> getDepartamentoInfo(
            @Parameter(description = "Código do departamento", required = true)
            @ParameterObject
            @Valid
            @ModelAttribute
            CodigoDepartDTO codigo) {
        return ResponseEntity.ok(departamentoQueryService.getDepartamentoInfo(codigo.dep));
    }

    public record CodigoDepartDTO(
            @NotBlank(message = "O código de departamento não pode ser vazio")
            @Pattern(regexp = "^[A-Za-z0-9]+$", message = "O código do departamento precisa de letras e númetos")
            String dep
    ) {}

    @Autowired
    private void setDepartamentoQueryService(DepartamentoQueryService departamentoQueryService) {
        this.departamentoQueryService = departamentoQueryService;
    }
}
