package org.equipe_9.uniufc.domain.restful;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.equipe_9.uniufc.domain.model.dto.LoginRequest;
import org.equipe_9.uniufc.domain.model.dto.TokenInfoDTO;
import org.equipe_9.uniufc.domain.service.AuthCmdService;
import org.equipe_9.uniufc.domain.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticação", description = "Autenticação e autorização de usuários. O acesso é permitido para usuários com as regras: ANONYMOUS.")
@RestController
@RequestMapping("/uniufc/auth")
public class AuthQuery {
    private JwtTokenService jwtService;
    private AuthenticationManager authManager;
    private AuthCmdService authCmdService;

    @Operation(
            summary = "Autenticar usuário",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = { @Content(
                            schema = @Schema(implementation = LoginRequest.class),
                            examples = @ExampleObject(value = """
                            {
                              "username": "victorepc",
                              "password": "Vv_12345@"
                            }
                            """)),
                            @Content(
                                    mediaType = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                                    schema = @Schema(implementation = LoginRequest.class)
                            )}
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Token gerado com sucesso"),
                    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
            },
            security = @SecurityRequirement(name = "")
    )

    @PostMapping(
            value = "/login",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<?> login(@RequestBody @ModelAttribute LoginRequest login) {
        TokenInfoDTO token = authCmdService.getToken(login, authManager, jwtService);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(token);
    }

    @Operation(
            summary = "Atualizar token",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    description = "Token de refresh JWT",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TokenInfoDTO.RefreshTokenDTO.class),
                            examples = @ExampleObject(value = """
                    {
                      "token": "2d4994b9-5fc5-4cd0-ba78-c567c73680a7"
                    }
                    """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Token renovado com sucesso",
                            content = @Content(schema = @Schema(implementation = TokenInfoDTO.class))),
                    @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
            },
            security = @SecurityRequirement(name = "")
    )
    @PostMapping(path = "/refresh", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> refreshToken(@RequestBody @Valid TokenInfoDTO.RefreshTokenDTO refreshToken) {
        TokenInfoDTO response = authCmdService.refresh(refreshToken.token(), jwtService);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @Operation(
            summary = "Revogar token",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    description = "Token de refresh a ser revogado",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TokenInfoDTO.RefreshTokenDTO.class),
                            examples = @ExampleObject(value = """
                    {
                      "token": "2d4994b9-5fc5-4cd0-ba78-c567c73680a7"
                    }
                    """)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "204", description = "Token revogado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Token inválido")
            },
            security = @SecurityRequirement(name = "")
    )
    @PostMapping(path = "/revoke", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> revokeToken(@RequestBody @Valid TokenInfoDTO.RefreshTokenDTO refreshToken) {
        TokenInfoDTO response = authCmdService.revoke(refreshToken.token());
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(response);
    }

    @Autowired @Lazy
    public void setJwtService(JwtTokenService jwtService) {
        this.jwtService = jwtService;
    }

    @Autowired @Lazy
    public void setAuthCmdService(AuthCmdService authCmdService) {
        this.authCmdService = authCmdService;
    }

    @Autowired
    public void setAuthManager(AuthenticationManager authManager) {
        this.authManager = authManager;
    }
}
