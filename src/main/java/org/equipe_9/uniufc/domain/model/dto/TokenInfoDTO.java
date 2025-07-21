package org.equipe_9.uniufc.domain.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder(toBuilder = true)
public record TokenInfoDTO(
        String meta,
        RefreshTokenDTO refreshTokenDTO,
        TokenInfoValueDTO tokenInfoValue
) {
    @Builder(toBuilder = true)
    public record TokenInfoValueDTO(
            String username,
            String token,
            Instant expiresAt
    ) {}

    @Builder(toBuilder = true)
    public record RefreshTokenDTO(
            Long id,

            @NotNull(message = "{auth.refresh_token.not_null}")
            UUID token,

            UserBasicDTO userbasicDTO,
            boolean revoked,
            Instant expiresAt,
            Instant createdAt
    ) {}
}
