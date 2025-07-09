package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.equipe_9.uniufc.domain.CommonData;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
public class Usuario extends CommonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String nome;

    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @Column(length = 15, nullable = false)
    private String senha;

    @Enumerated(EnumType.ORDINAL)
    private Regra regra;

    public enum Regra {
        DBA,
        SERVIDOR,
        PROFESSOR,
        ALUNO
    }
}
