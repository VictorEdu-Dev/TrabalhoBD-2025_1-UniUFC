package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@Entity(name = "aluno_pos_graduacao")
@Table(name = "alunos_pos_graduacao")
@PrimaryKeyJoinColumn(name = "aluno_id")
@DiscriminatorValue("POS_GRADUACAO")
public final class AlunoPosGraduacao extends Aluno {
}
