package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "aluno_graduacao")
@PrimaryKeyJoinColumn(name = "aluno_id")
public final class AlunoGraduacao extends Aluno {
    @Column(columnDefinition = "datetime")
    private LocalDateTime dataIngresso;
}

