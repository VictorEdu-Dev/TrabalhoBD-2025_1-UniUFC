package org.equipe_9.uniufc.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.equipe_9.uniufc.domain.CommonData;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "professor")
public class Professor extends CommonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, unique = true, nullable = false)
    private String siape;

    @Column(name = "full_name", length = 200)
    private String nomeCompleto;

    @Column(columnDefinition = "datetime")
    private LocalDateTime dataNascimento;

    @Column(columnDefinition = "datetime")
    private LocalDateTime dataIngresso;

    @ToString.Exclude
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "emails_professor",
            joinColumns = @JoinColumn(name = "professor_id"))
    @Column(name = "email", nullable = false)
    private Set<String> emails = new HashSet<>();
}
