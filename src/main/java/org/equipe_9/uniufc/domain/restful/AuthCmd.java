package org.equipe_9.uniufc.domain.restful;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.equipe_9.uniufc.core.security.AuthenticatedUserProvider;
import org.equipe_9.uniufc.domain.model.dto.AlunoDTO;
import org.equipe_9.uniufc.domain.model.dto.ProfessorDTO;
import org.equipe_9.uniufc.domain.model.dto.UsuarioDTO;
import org.equipe_9.uniufc.domain.service.AuthUserCmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticação e Gerenciamento de Usuários", description = "Endpoints para registro e gerenciamento de perfis de usuários (alunos, professores e usuários genéricos) no sistema UniUFC.")
@RestController
@RequestMapping("/uniufc/auth")
public class AuthCmd {
    private AuthenticatedUserProvider authenticatedUserProvider;
    private AuthUserCmdService authUserCmdService;

    @Operation(
            summary = "Registra um novo usuário genérico",
            description = "Permite o registro de um novo usuário com credenciais básicas. O nível de acesso inicial pode ser definido pelo sistema ou pelo DBA posteriormente.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados para registro do usuário",
                    required = true,
                    content = @Content(schema = @Schema(implementation = UsuarioDTO.UsuarioRegisterDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuário registrado com sucesso.",
                            content = @Content(schema = @Schema(type = "string", example = "Usuário registrado."))),
                    @ApiResponse(responseCode = "400", description = "Dados de registro inválidos."),
                    @ApiResponse(responseCode = "409", description = "Conflito: Usuário já existe.")
            }
    )
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UsuarioDTO.UsuarioRegisterDTO registrationDto) {
        return ResponseEntity.ok(authUserCmdService.registerUser(registrationDto, authenticatedUserProvider.currentUser()));
    }

    @Operation(
            summary = "Registra um novo professor",
            description = "Permite o registro de um novo professor no sistema, incluindo seus dados específicos como SIAPE e departamento.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados para registro do professor",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ProfessorDTO.ProfessorRegisterDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Professor registrado com sucesso.",
                            content = @Content(schema = @Schema(type = "string", example = "Usuário registrado."))),
                    @ApiResponse(responseCode = "400", description = "Dados de registro inválidos."),
                    @ApiResponse(ref = "409", description = "Conflito: Professor já existe ou SIAPE duplicado.")
            }
    )
    @PostMapping("/register-professor")
    public ResponseEntity<?> registerUser(@Valid @RequestBody ProfessorDTO.ProfessorRegisterDTO registrationDto) {
        return ResponseEntity.ok(authUserCmdService.registerProfessor(registrationDto, authenticatedUserProvider.currentUser()));
    }

    @Operation(
            summary = "Registra um novo aluno",
            description = "Permite o registro de um novo aluno no sistema, diferenciando entre alunos de graduação e pós-graduação.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados para registro do aluno",
                    required = true,
                    content = @Content(schema = @Schema(implementation = AlunoDTO.AlunoRegisterDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Aluno registrado com sucesso.",
                            content = @Content(schema = @Schema(type = "string", example = "Usuário registrado."))),
                    @ApiResponse(responseCode = "400", description = "Dados de registro inválidos."),
                    @ApiResponse(ref = "409", description = "Conflito: Aluno já existe ou matrícula duplicada.")
            }
    )
    @PostMapping("/register-aluno")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AlunoDTO.AlunoRegisterDTO registrationDto) {
        return ResponseEntity.ok(authUserCmdService.registerAluno(registrationDto, authenticatedUserProvider.currentUser()));
    }

    @Operation(
            summary = "Atualiza o perfil de um usuário genérico",
            description = "Permite que um usuário autenticado atualize suas informações de perfil genéricas. Requer autenticação.",
            security = @SecurityRequirement(name = "bearerAuth"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Novos dados do perfil do usuário",
                    required = true,
                    content = @Content(schema = @Schema(implementation = UsuarioDTO.UsuarioRegisterDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Perfil atualizado com sucesso.",
                            content = @Content(schema = @Schema(type = "string", example = "Perfil atualizado."))),
                    @ApiResponse(responseCode = "400", description = "Dados de atualização inválidos."),
                    @ApiResponse(responseCode = "401", description = "Não autorizado: Token de autenticação ausente ou inválido."),
                    @ApiResponse(responseCode = "403", description = "Proibido: Usuário não tem permissão para atualizar este perfil."),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado.")
            }
    )
    @PatchMapping("/change-profile")
    public ResponseEntity<?> updateProfile(
            @Valid @RequestBody UsuarioDTO.UsuarioRegisterDTO profileDto) {
        return ResponseEntity.ok(authUserCmdService.updateProfile(profileDto, authenticatedUserProvider.currentUser()));
    }

    @Operation(
            summary = "Atualiza o perfil de um professor",
            description = "Permite que um professor autenticado atualize suas informações de perfil específicas. Requer autenticação.",
            security = @SecurityRequirement(name = "bearerAuth"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Novos dados do perfil do professor",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ProfessorDTO.ProfessorRegisterDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Perfil do professor atualizado com sucesso.",
                            content = @Content(schema = @Schema(type = "string", example = "Perfil atualizado."))),
                    @ApiResponse(responseCode = "400", description = "Dados de atualização inválidos."),
                    @ApiResponse(responseCode = "401", description = "Não autorizado: Token de autenticação ausente ou inválido."),
                    @ApiResponse(responseCode = "403", description = "Proibido: Usuário não tem permissão para atualizar este perfil (não é o professor logado)."),
                    @ApiResponse(responseCode = "404", description = "Professor não encontrado.")
            }
    )
    @PatchMapping("/change-profile-professor")
    public ResponseEntity<?> updateProfileProfessor(
            @Valid @RequestBody ProfessorDTO.ProfessorRegisterDTO profileDto) {
        return ResponseEntity.ok(authUserCmdService.updateProfileProfessor(profileDto, authenticatedUserProvider.currentUser()));
    }

    @Operation(
            summary = "Atualiza o perfil de um aluno",
            description = "Permite que um aluno autenticado atualize suas informações de perfil específicas (graduação/pós-graduação). Requer autenticação.",
            security = @SecurityRequirement(name = "bearerAuth"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Novos dados do perfil do aluno",
                    required = true,
                    content = @Content(schema = @Schema(implementation = AlunoDTO.AlunoRegisterDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Perfil do aluno atualizado com sucesso.",
                            content = @Content(schema = @Schema(type = "string", example = "Perfil atualizado."))),
                    @ApiResponse(responseCode = "400", description = "Dados de atualização inválidos."),
                    @ApiResponse(responseCode = "401", description = "Não autorizado: Token de autenticação ausente ou inválido."),
                    @ApiResponse(responseCode = "403", description = "Proibido: Usuário não tem permissão para atualizar este perfil (não é o aluno logado)."),
                    @ApiResponse(responseCode = "404", description = "Aluno não encontrado.")
            }
    )
    @PatchMapping("/change-profile-aluno")
    public ResponseEntity<?> updateProfileAluno(
            @Valid @RequestBody AlunoDTO.AlunoRegisterDTO profileDto){
        return ResponseEntity.ok(authUserCmdService.updateProfileAluno(profileDto, authenticatedUserProvider.currentUser()));
    }

    @Operation(
            summary = "Exclui um usuário (Apenas para DBA)",
            description = "Permite que um usuário com privilégios de DBA exclua qualquer usuário do sistema. Requer autenticação de DBA.",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso (No Content)."),
                    @ApiResponse(responseCode = "400", description = "ID do usuário inválido."),
                    @ApiResponse(responseCode = "401", description = "Não autorizado: Token de autenticação ausente ou inválido."),
                    @ApiResponse(responseCode = "403", description = "Proibido: Usuário não tem privilégios de DBA."),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado para exclusão.")
            }
    )
    @DeleteMapping("/admin/user/{userId}")
    public ResponseEntity<?> deleteUser(
            @Parameter(description = "ID do usuário a ser excluído. Deve ser um número positivo.", required = true, example = "123")
            @Valid
            @Positive(message = "ID do usuário deve ser um número positivo.")
            @PathVariable
            Long userId) {
        authUserCmdService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Autowired
    private void setAuthenticatedUserProvider(AuthenticatedUserProvider authenticatedUserProvider) {
        this.authenticatedUserProvider = authenticatedUserProvider;
    }

    @Autowired
    private void setAuthUserCmdService(AuthUserCmdService authUserCmdService) {
        this.authUserCmdService = authUserCmdService;
    }
}
