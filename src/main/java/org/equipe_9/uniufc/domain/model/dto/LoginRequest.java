package org.equipe_9.uniufc.domain.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder(toBuilder = true)
public record LoginRequest(
        @NotBlank(message = "{user.username.notblank}")
        @Size(min = 3, max = 50, message = "{user.username.size}")
        @Pattern(
                regexp = "^[a-zA-Z][a-zA-Z0-9._-]*$",
                message = "{user.username.pattern}"
        )
        String username,

        @NotBlank(message = "{user.password.not.blank}")
        @Size(min = 6, message = "{user.password.size}")
        @Pattern(regexp = ".*[A-Z].*", message = "{user.password.pattern.uppercase}")
        @Pattern(regexp = ".*[a-z].*", message = "{user.password.pattern.lowercase}")
        @Pattern(regexp = ".*\\d.*", message = "{user.password.pattern.digit}")
        @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "{user.password.pattern.special}")
        String password) {}
