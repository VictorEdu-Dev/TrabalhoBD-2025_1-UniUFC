package org.equipe_9.uniufc.core.security;

import org.equipe_9.uniufc.domain.model.Usuario.Regra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

@Configuration
public class RoleHierarchyConfig {
    @Bean
    public RoleHierarchy roleHierarchy() {
        return RoleHierarchyImpl.withDefaultRolePrefix()
                .role(Regra.DBA.name()).implies(Regra.PROFESSOR.name(), Regra.SERVIDOR.name())
                .role(Regra.PROFESSOR.name()).implies(Regra.ALUNO.name())
                .build();
    }
}