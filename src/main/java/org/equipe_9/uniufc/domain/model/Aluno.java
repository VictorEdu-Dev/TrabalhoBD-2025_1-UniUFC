package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.equipe_9.uniufc.domain.CommonData;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity(name = "aluno")
@Table(name = "alunos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_aluno", discriminatorType = DiscriminatorType.STRING)
public class Aluno extends CommonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6, nullable = false, unique = true)
    private String matricula;

    @Column(length = 200)
    private String nome;

    @Column(length = 500)
    private String endereco;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "aluno_has_disciplinas",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
    @Fetch(FetchMode.SELECT)
    private List<Disciplina> disciplinas;

    @ToString.Exclude
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "telefones_aluno",
            joinColumns = @JoinColumn(name = "aluno_id"))
    private Set<TelefoneAluno> telefones = new HashSet<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    @Embeddable
    public static class TelefoneAluno {

        @Column(name = "telefone", length = 15)
        private String numero;

        @Column(name = "descricao", length = 45)
        private String descricao;
    }
}
