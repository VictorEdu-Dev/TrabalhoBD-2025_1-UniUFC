package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "aluno_pos_graduacao")
@Table(name = "alunos_pos_graduacao")
@PrimaryKeyJoinColumn(name = "aluno_id")
@DiscriminatorValue("POS_GRADUACAO")
public final class AlunoPosGraduacao extends Aluno {
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_orientador_id", nullable = false)
    private Professor professorOrientador;
}
