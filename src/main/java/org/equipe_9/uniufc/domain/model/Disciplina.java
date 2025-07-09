package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.equipe_9.uniufc.domain.CommonData;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "disciplina")
public class Disciplina extends CommonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String nome;

    @Column(length = 10, unique = true)
    private String codigo;

    @Column(length = 500)
    private String ementa;

    private Integer creditos;

    @Enumerated(EnumType.ORDINAL)
    private TipoDisciplina tipo;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "disciplina_prerequisito",
            joinColumns = @JoinColumn(name = "disciplina_requerente_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_prerequisito_id"))
    @Fetch(FetchMode.SELECT)
    private List<Disciplina> prerequisito;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "professor_primary_id")
    private Professor professorPrimary;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "professor_secondary_id")
    private Professor professorSecondary;

    public enum TipoDisciplina {
        OBRIGATORIA,
        OPTATIVA
    }
}
