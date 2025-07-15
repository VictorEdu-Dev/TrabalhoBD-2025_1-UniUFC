package org.equipe_9.uniufc.domain.repository;

import org.equipe_9.uniufc.domain.model.AlunoGraduacao;
import org.springframework.data.repository.CrudRepository;

public interface AlunoDAO extends CrudRepository<AlunoGraduacao, Long> {
}
