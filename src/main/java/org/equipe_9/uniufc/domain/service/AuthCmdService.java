package org.equipe_9.uniufc.domain.service;

import org.equipe_9.uniufc.domain.exception.InvalidTokenException;
import org.equipe_9.uniufc.domain.exception.UserNotFoundException;
import org.equipe_9.uniufc.domain.model.RefreshToken;
import org.equipe_9.uniufc.domain.model.Usuario;
import org.equipe_9.uniufc.domain.model.dto.LoginRequest;
import org.equipe_9.uniufc.domain.model.dto.TokenInfoDTO;
import org.equipe_9.uniufc.domain.repository.RefreshTokenDAO;
import org.equipe_9.uniufc.domain.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthCmdService {
    private static final String DEFAULT_ROLE = "ROLE_STUDENT";
    private UsuarioDAO userDAO;
    private RefreshTokenDAO refreshTokenDAO;

    public TokenInfoDTO getToken(LoginRequest request,
                                 AuthenticationManager authManager,
                                 JwtTokenService jwtService) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username().toLowerCase(), request.password())
        );

        String username = authentication.getName();
        Usuario user = userDAO.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + username));
        String role = Optional.ofNullable(user.getRegra())
                .map(r -> "ROLE_" + r.name())
                .orElse(DEFAULT_ROLE);

        return jwtService.generateTokenInfo(authentication.getName(), role);
    }

    public TokenInfoDTO refresh(UUID token, JwtTokenService jwtService) {
        RefreshToken refreshToken = refreshTokenDAO.findByRefreshToken(token)
                .filter(rt -> !rt.isRevoked())
                .filter(rt -> rt.getExpiresAt().isAfter(Instant.now()))
                .orElseThrow(() -> new InvalidTokenException("Invalid or expired refresh token: " + token));

        String username = refreshToken.getUser().getLogin();
        String role = "ROLE_" + refreshToken.getUser().getRegra().name();

        refreshToken.setRevoked(true);
        refreshTokenDAO.save(refreshToken);

        return jwtService.generateTokenInfo(username, role);
    }

    public TokenInfoDTO revoke(UUID token) {
        RefreshToken refreshToken = refreshTokenDAO.findByRefreshToken(token)
                .orElseThrow(() -> new InvalidTokenException("Refresh token not found: " + token));

        if (refreshToken.isRevoked()) {
            throw new InvalidTokenException("Refresh token already revoked: " + token);
        }

        refreshToken.setRevoked(true);
        refreshTokenDAO.save(refreshToken);

        return TokenInfoDTO
                .builder()
                .meta("Refresh token revoked successfully.")
                .build();
    }

    @Autowired @Lazy
    public void setUserDAO(UsuarioDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired @Lazy
    public void setRefreshTokenDAO(RefreshTokenDAO refreshTokenDAO) {
        this.refreshTokenDAO = refreshTokenDAO;
    }
}
