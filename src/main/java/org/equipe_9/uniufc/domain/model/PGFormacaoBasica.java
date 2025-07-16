package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pg_formacao_basica")
public class PGFormacaoBasica extends CommonData {
    @Transient
    private Long id;

    @EmbeddedId
    private PGFormacaoBasicaId idFormacaoBasica;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alunoPosGraduacaoId")
    @JoinColumn(name = "aluno_pos_graduacao_id", nullable = false)
    private AlunoPosGraduacao alunoPosGraduacao;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class PGFormacaoBasicaId {
        @Column(name = "aluno_pos_graduacao_id")
        private Long alunoPosGraduacaoId;

        @Column(name = "curso_id")
        private Long cursoId;
    }
}
