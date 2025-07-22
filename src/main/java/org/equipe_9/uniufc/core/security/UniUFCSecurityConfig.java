package org.equipe_9.uniufc.core.security;

import org.equipe_9.uniufc.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class UniUFCSecurityConfig {
    private final JwtDecoder jwtDecoder;
    private final JwtAuthenticationConverter jwtAuthenticationConverter;

    @Autowired
    public UniUFCSecurityConfig(JwtDecoder jwtDecoder, JwtAuthenticationConverter jwtAuthenticationConverter) {
        this.jwtDecoder = jwtDecoder;
        this.jwtAuthenticationConverter = jwtAuthenticationConverter;
    }

    private void commonSecurityConfig(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .decoder(jwtDecoder)
                                .jwtAuthenticationConverter(jwtAuthenticationConverter)
                        )
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable);
    }

    @Bean
    @Order(0)
    public SecurityFilterChain loginSecurityFilterChain(HttpSecurity http) throws Exception {
        commonSecurityConfig(http);

        http.securityMatcher("/uniufc/**")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/uniufc/auth/login",
                                "/uniufc/auth/refresh",
                                "/uniufc/auth/revoke"
                        ).permitAll()

                        .requestMatchers(
                                "/uniufc/cursos-dep",
                                "/uniufc/departamento-info"
                        ).hasAnyRole(Usuario.Regra.DBA.name(), Usuario.Regra.SERVIDOR.name())

                        .requestMatchers(
                                "/uniufc/professor-alunos",
                                "/uniufc/alunos-matriculados",
                                "/uniufc/professor-disciplinas",
                                "/uniufc/pre-requisitos",
                                "/uniufc/open-disciplinas"
                        ).hasAnyRole(Usuario.Regra.DBA.name(), Usuario.Regra.SERVIDOR.name(), Usuario.Regra.PROFESSOR.name())

                        .requestMatchers(
                                "/uniufc/info-aluno",
                                "/uniufc/disciplinas-concluidas",
                                "/uniufc/disciplinas-aluno",
                                "/uniufc/curso-aluno"
                        ).hasAnyRole(Usuario.Regra.DBA.name(), Usuario.Regra.SERVIDOR.name(), Usuario.Regra.PROFESSOR.name(), Usuario.Regra.ALUNO.name())

                        .requestMatchers(
                                "/uniufc/disciplinas-optativas",
                                "/uniufc/disciplinas-obrigatorias",
                                "/uniufc/alunos-curso",
                                "/uniufc/alunos-curso-optativas",
                                "/uniufc/alunos-curso-obrigatorias"
                        ).hasAnyRole(Usuario.Regra.DBA.name(), Usuario.Regra.SERVIDOR.name(), Usuario.Regra.PROFESSOR.name(), Usuario.Regra.ALUNO.name())

                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(authenticationEntryPoint())
                        .accessDeniedHandler(accessDeniedHandler())
                );

        return http.build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                        auth
                                .anyRequest().permitAll())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            String json = "{\"error\": \"N\u00e3o autenticado\", \"message\": \"Credenciais incorretas, token inv\u00e1lido, expirado ou ausente.\"}";
            response.getWriter().write(json);
        };
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType("application/json");
            String json = "{\"error\": \"Acesso negado\", \"message\": \"Voc\u00ea no tem permiss\u00e3o para acessar este recurso.\"}";
            response.getWriter().write(json);
        };
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(List.of(
                "http://localhost:3000",
                "http://localhost:8080"
        ));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "Accept", "Origin", "Cache-Control", "X-Requested-With"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
