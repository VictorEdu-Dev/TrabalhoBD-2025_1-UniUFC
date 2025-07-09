package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.equipe_9.uniufc.domain.CommonData;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "aluno_has_disciplinas")
public class AlunoHasDisciplina extends CommonData {
    @EmbeddedId
    private AlunoDisciplinaId id = new AlunoDisciplinaId();

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("disciplinaId")
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @Column(precision = 4, scale = 2)
    private BigDecimal mediaFinal;

    private Integer frequencia;

    @Transient
    private Long Id;

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class AlunoDisciplinaId implements Serializable {
        @Column(name = "aluno_id")
        private Long alunoId;

        @Column(name = "disciplina_id")
        private Long disciplinaId;
    }
}