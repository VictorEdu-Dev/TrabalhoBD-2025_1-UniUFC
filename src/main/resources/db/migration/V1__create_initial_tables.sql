-- Cria departamento
CREATE TABLE IF NOT EXISTS departamento (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200),
    codigo VARCHAR(32) UNIQUE,
    version TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- Cria curso somente após departamento
CREATE TABLE IF NOT EXISTS curso (
    id BIGINT NOT NULL AUTO_INCREMENT,
    codigo VARCHAR(10) UNIQUE,
    nome VARCHAR(200),
    creditos INT,
    departamento_id BIGINT NOT NULL,
    version TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- Cria a chave estrangeira para o departamento
ALTER TABLE curso
    ADD CONSTRAINT fk_curso_departamento
        FOREIGN KEY (departamento_id) REFERENCES departamento(id);

-- Cria usuario, necessario para existência de partes do sistema
CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200),
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(60) NOT NULL,
    regra VARCHAR(20),
    version TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- Cria professor
CREATE TABLE IF NOT EXISTS professor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    siape VARCHAR(10) NOT NULL UNIQUE,
    full_name VARCHAR(200),
    dataNascimento DATETIME,
    dataIngresso DATETIME,
    usuario_id BIGINT NOT NULL,
    departamento_id BIGINT,
    version TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Adiciona as chaves estrangeiras para usuario e departamento
ALTER TABLE professor
    ADD CONSTRAINT fk_professor_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario(id);

ALTER TABLE professor
    ADD CONSTRAINT fk_professor_departamento
        FOREIGN KEY (departamento_id) REFERENCES departamento(id);


-- Cria campos de email e telefone para professor
CREATE TABLE IF NOT EXISTS emails_professor (
    professor_id BIGINT NOT NULL,
    email VARCHAR(255),
    PRIMARY KEY (professor_id, email)
);

ALTER TABLE emails_professor
    ADD CONSTRAINT fk_emails_professor_professor
        FOREIGN KEY (professor_id) REFERENCES professor(id);

CREATE TABLE IF NOT EXISTS telefones_professor (
    professor_id BIGINT NOT NULL,
    telefone VARCHAR(255),
    PRIMARY KEY (professor_id, telefone)
);

ALTER TABLE telefones_professor
    ADD CONSTRAINT fk_telefones_professor_professor
        FOREIGN KEY (professor_id) REFERENCES professor(id);

-- Cria disciplina
CREATE TABLE IF NOT EXISTS disciplina (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    codigo VARCHAR(10) UNIQUE,
    ementa VARCHAR(1000),
    creditos INT,
    tipo VARCHAR(20),
    curso_id BIGINT,
    professor_primary_id BIGINT,
    professor_secondary_id BIGINT,
    version TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS disciplina_prerequisito (
    disciplina_requerente_id BIGINT NOT NULL,
    disciplina_prerequisito_id BIGINT NOT NULL,
    PRIMARY KEY (disciplina_requerente_id, disciplina_prerequisito_id)
);

ALTER TABLE disciplina
    ADD CONSTRAINT fk_disciplina_curso FOREIGN KEY (curso_id) REFERENCES curso(id);

ALTER TABLE disciplina
    ADD CONSTRAINT fk_disciplina_professor_primary FOREIGN KEY (professor_primary_id) REFERENCES professor(id);

ALTER TABLE disciplina
    ADD CONSTRAINT fk_disciplina_professor_secondary FOREIGN KEY (professor_secondary_id) REFERENCES professor(id);

ALTER TABLE disciplina_prerequisito
    ADD CONSTRAINT fk_dp_requerente FOREIGN KEY (disciplina_requerente_id) REFERENCES disciplina(id);

ALTER TABLE disciplina_prerequisito
    ADD CONSTRAINT fk_dp_prerequisito FOREIGN KEY (disciplina_prerequisito_id) REFERENCES disciplina(id);


-- Cria aluno
CREATE TABLE IF NOT EXISTS alunos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(6) NOT NULL UNIQUE,
    nome VARCHAR(200),
    endereco VARCHAR(500),
    curso_id BIGINT,
    usuario_id BIGINT NOT NULL,
    version TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS aluno_graduacao (
    aluno_id BIGINT PRIMARY KEY,
    data_ingresso DATETIME,
    version TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS aluno_pos_graduacao (
    aluno_id BIGINT PRIMARY KEY,
    professor_orientador_id BIGINT NOT NULL,
    version TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS pg_formacao_basica (
    aluno_pos_graduacao_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    PRIMARY KEY (aluno_pos_graduacao_id, curso_id)
);

CREATE TABLE IF NOT EXISTS aluno_has_disciplinas (
    aluno_id BIGINT NOT NULL,
    disciplina_id BIGINT NOT NULL,
    media_final DECIMAL(4,2) DEFAULT 0.00,
    frequencia DECIMAL(4,2) DEFAULT 0.00,
    version TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (aluno_id, disciplina_id)
);

CREATE TABLE IF NOT EXISTS telefones_aluno (
    aluno_id BIGINT NOT NULL,
    telefone VARCHAR(15),
    descricao VARCHAR(45)
);

ALTER TABLE alunos
    ADD CONSTRAINT fk_aluno_curso FOREIGN KEY (curso_id) REFERENCES curso(id);

ALTER TABLE alunos
    ADD CONSTRAINT fk_aluno_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id);

ALTER TABLE aluno_graduacao
    ADD CONSTRAINT fk_graduacao_aluno FOREIGN KEY (aluno_id) REFERENCES alunos(id);

ALTER TABLE aluno_pos_graduacao
    ADD CONSTRAINT fk_pos_aluno FOREIGN KEY (aluno_id) REFERENCES alunos(id);

ALTER TABLE aluno_pos_graduacao
    ADD CONSTRAINT fk_pos_professor FOREIGN KEY (professor_orientador_id) REFERENCES professor(id);

ALTER TABLE pg_formacao_basica
    ADD CONSTRAINT fk_pg_aluno FOREIGN KEY (aluno_pos_graduacao_id) REFERENCES aluno_pos_graduacao(aluno_id);

ALTER TABLE pg_formacao_basica
    ADD CONSTRAINT fk_pg_curso FOREIGN KEY (curso_id) REFERENCES curso(id);

ALTER TABLE aluno_has_disciplinas
    ADD CONSTRAINT fk_ahd_aluno FOREIGN KEY (aluno_id) REFERENCES alunos(id);

ALTER TABLE aluno_has_disciplinas
    ADD CONSTRAINT fk_ahd_disciplina FOREIGN KEY (disciplina_id) REFERENCES disciplina(id);

ALTER TABLE telefones_aluno
    ADD CONSTRAINT fk_telefone_aluno FOREIGN KEY (aluno_id) REFERENCES alunos(id);