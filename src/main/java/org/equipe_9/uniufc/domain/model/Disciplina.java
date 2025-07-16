package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;

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

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoDisciplina tipo;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "disciplina_prerequisito",
            joinColumns = @JoinColumn(name = "disciplina_requerente_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_prerequisito_id"))
    private List<Disciplina> preRequisito;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "disciplina_has_professores",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> professores;

    public enum TipoDisciplina {
        OBRIGATORIA,
        OPTATIVA
    }
}