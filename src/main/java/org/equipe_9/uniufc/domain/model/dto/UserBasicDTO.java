package org.equipe_9.uniufc.domain.model.dto;

import lombok.Builder;
import org.equipe_9.uniufc.domain.model.Usuario.Regra;

@Builder(toBuilder = true)
public record UserBasicDTO(
        Long id,
        String login,
        Regra regra
) {
}
