package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "aluno_has_disciplinas")
public class AlunoHasDisciplina extends CommonData {
    @Transient
    private Long Id;
    
    @EmbeddedId
    private AlunoDisciplinaId ids = new AlunoDisciplinaId();

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

    @Column(precision = 4, scale = 2)
    private BigDecimal frequencia;

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