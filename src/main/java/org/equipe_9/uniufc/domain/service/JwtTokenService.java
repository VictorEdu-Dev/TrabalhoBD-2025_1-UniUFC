package org.equipe_9.uniufc.domain.service;

import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.equipe_9.uniufc.domain.exception.UserNotFoundException;
import org.equipe_9.uniufc.domain.model.RefreshToken;
import org.equipe_9.uniufc.domain.model.Usuario;
import org.equipe_9.uniufc.domain.model.dto.RefreshTokenMapper;
import org.equipe_9.uniufc.domain.model.dto.TokenInfoDTO;
import org.equipe_9.uniufc.domain.model.dto.UserBasicDTO;
import org.equipe_9.uniufc.domain.repository.RefreshTokenDAO;
import org.equipe_9.uniufc.domain.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class JwtTokenService {
    private static final String ISSUER = "UNI-UFC";
    private final JwtEncoder jwtEncoder;
    private UsuarioDAO userDAO;
    private RefreshTokenDAO refreshTokenDAO;
    private RefreshTokenMapper refreshTokenMapper;

    public JwtTokenService(JWKSource<SecurityContext> jwkSource) {
        this.jwtEncoder = new NimbusJwtEncoder(jwkSource);
    }

    public TokenInfoDTO generateTokenInfo(String username, String role) throws UserNotFoundException {
        Instant now = Instant.now();
        Instant accessTokenExpiresAt = now.plusSeconds(900);
        Instant refreshTokenExpiresAt = now.plus(7, DAYS);

        String accessToken = jwtEncoder.encode(JwtEncoderParameters.from(
                JwtClaimsSet.builder()
                        .issuer(ISSUER)
                        .issuedAt(now)
                        .expiresAt(accessTokenExpiresAt)
                        .subject(username)
                        .claim("role", role)
                        .build()
        )).getTokenValue();

        Usuario user = userDAO.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + username));
        UserBasicDTO userBasicDTO = UserBasicDTO.builder()
                .id(user.getId())
                .login(user.getLogin())
                .regra(user.getRegra())
                .build();

        TokenInfoDTO tokenInfoDTO = new TokenInfoDTO(
                "access_token",
                TokenInfoDTO.RefreshTokenDTO.builder()
                        .userbasicDTO(userBasicDTO)
                        .token(UUID.randomUUID())
                        .revoked(false)
                        .createdAt(now)
                        .expiresAt(refreshTokenExpiresAt)
                        .build(),
                TokenInfoDTO.TokenInfoValueDTO.builder()
                        .username(username)
                        .token(accessToken)
                        .expiresAt(accessTokenExpiresAt)
                        .build()
        );

        RefreshToken refreshToken = refreshTokenMapper.toEntity(tokenInfoDTO.refreshTokenDTO());
        refreshToken.setUser(user);
        refreshTokenDAO.save(refreshToken);

        TokenInfoDTO.RefreshTokenDTO refreshTokenDTO = tokenInfoDTO
                .refreshTokenDTO()
                .toBuilder()
                .id(refreshToken.getId())
                .build();
        return tokenInfoDTO
                .toBuilder()
                .refreshTokenDTO(refreshTokenDTO)
                .build();
    }

    @Autowired
    public void setRefreshTokenDAO(UsuarioDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setRefreshTokenDAO(RefreshTokenDAO refreshTokenDAO) {
        this.refreshTokenDAO = refreshTokenDAO;
    }

    @Autowired
    public void setRefreshTokenMapper(RefreshTokenMapper refreshTokenMapper) {
        this.refreshTokenMapper = refreshTokenMapper;
    }
}
