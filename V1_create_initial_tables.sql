CREATE TABLE IF NOT EXISTS `equipe569944`.`departamento` (
  `id` BIGINT NOT NULL,
  `codigo` VARCHAR(32) NOT NULL,
  `nome` VARCHAR(200) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `equipe569944`.`curso` (
`id` BIGINT NOT NULL,
`codigo` VARCHAR(10) NOT NULL,
`nome` VARCHAR(200) NULL,
`creditos` INT NULL,
`departamento_id` BIGINT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
INDEX `fk_curso_departamento_idx` (`departamento_id` ASC) VISIBLE,
CONSTRAINT `fk_curso_departamento`
FOREIGN KEY (`departamento_id`)
REFERENCES `mydb`.`departamento` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`disciplina` (
  `id` BIGINT NOT NULL,
  `codigo` VARCHAR(10) NOT NULL,
  `nome` VARCHAR(200) NULL,
  `ementa` VARCHAR(200) NULL,
  `creditos` INT NULL,
  `tipo` ENUM('OPTATIVA', 'OBRIGATORIA') NULL,
  `curso_id` BIGINT NULL,
  `professor_primary_id` BIGINT NULL,
  `professor_secondary_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_disciplina_curso1_idx` (`curso_id` ASC) VISIBLE,
  INDEX `fk_disciplina_professor1_idx` (`professor_primary_id` ASC) VISIBLE,
  INDEX `fk_disciplina_professor2_idx` (`professor_secondary_id` ASC) VISIBLE,
  CONSTRAINT `fk_disciplina_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `equipe569944`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_professor1`
    FOREIGN KEY (`professor_primary_id`)
    REFERENCES `equipe569944`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_professor2`
    FOREIGN KEY (`professor_secondary_id`)
    REFERENCES `equipe569944`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`disciplina_pre_requisito` (
  `disciplina_requerente_id` BIGINT NULL,
  `disciplina_pre_requisito_id` BIGINT NULL,
  PRIMARY KEY (`disciplina_requerente_id`, `disciplina_pre_requisito_id`),
  INDEX `fk_disciplina_has_disciplina_disciplina2_idx` (`disciplina_pre_requisito_id` ASC) VISIBLE,
  INDEX `fk_disciplina_has_disciplina_disciplina1_idx` (`disciplina_requerente_id` ASC) VISIBLE,
  CONSTRAINT `fk_disciplina_has_disciplina_disciplina1`
    FOREIGN KEY (`disciplina_requerente_id`)
    REFERENCES `mydb`.`disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_has_disciplina_disciplina2`
    FOREIGN KEY (`disciplina_pre_requisito_id`)
    REFERENCES `mydb`.`disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`professor` (
  `id` BIGINT NOT NULL,
  `siape` VARCHAR(10) NOT NULL,
  `full_name` VARCHAR(200) NULL,
  `data_nascimento` TIMESTAMP NULL,
  `data_ingresso` TIMESTAMP NULL,
  `departamento_id` BIGINT NULL,
  `usuario_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `siape_UNIQUE` (`siape` ASC) VISIBLE,
  INDEX `fk_professor_departamento1_idx` (`departamento_id` ASC) VISIBLE,
  INDEX `fk_professor_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  UNIQUE INDEX `usuario_id_UNIQUE` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_professor_departamento1`
    FOREIGN KEY (`departamento_id`)
    REFERENCES `equipe569944`.`departamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `equipe569944`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`telefones_professor` (
  `telefone` VARCHAR(15) NULL,
  `professor_id` BIGINT NULL,
  UNIQUE INDEX `id_UNIQUE` (`telefone` ASC) VISIBLE,
  PRIMARY KEY (`professor_id`),
  CONSTRAINT `fk_telefones_professor_professor1`
    FOREIGN KEY (`professor_id`)
    REFERENCES `equipe569944`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`emails_professor` (
  `email` VARCHAR(255) NULL,
  `professor_id` BIGINT NULL,
  UNIQUE INDEX `id_UNIQUE` (`email` ASC) VISIBLE,
  PRIMARY KEY (`professor_id`),
  CONSTRAINT `fk_emails_professor_professor1`
    FOREIGN KEY (`professor_id`)
    REFERENCES `equipe569944`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`usuario` (
  `id` BIGINT NOT NULL,
  `nome` VARCHAR(200) NULL,
  `login` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(15) NOT NULL,
  `regra` ENUM('DBA', 'SERVIDOR', 'ALUNO', 'PROFESSOR') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE);


CREATE TABLE IF NOT EXISTS `equipe569944`.`aluno` (
  `id` BIGINT NOT NULL,
  `matricula` VARCHAR(6) NOT NULL,
  `nome` VARCHAR(200) NULL,
  `endereco` VARCHAR(500) NULL,
  `curso_id` BIGINT NULL,
  `usuario_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC) VISIBLE,
  INDEX `fk_aluno_curso1_idx` (`curso_id` ASC) VISIBLE,
  INDEX `fk_aluno_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `equipe569944`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `equipe569944`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`telefones_aluno` (
  `telefone` VARCHAR(15) NULL,
  `descricao` VARCHAR(45) NULL,
  `aluno_id` BIGINT NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`telefone` ASC) VISIBLE,
  PRIMARY KEY (`aluno_id`),
  CONSTRAINT `fk_telefones_aluno_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `equipe569944`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`aluno_has_disciplina` (
  `aluno_id` BIGINT NOT NULL,
  `disciplina_id` BIGINT NULL,
  `media_final` DECIMAL(4,2) NULL,
  `frequencia` INT NULL,
  PRIMARY KEY (`aluno_id`, `disciplina_id`),
  INDEX `fk_aluno_has_disciplina_disciplina1_idx` (`disciplina_id` ASC) VISIBLE,
  INDEX `fk_aluno_has_disciplina_aluno1_idx` (`aluno_id` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_has_disciplina_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `equipe569944`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_has_disciplina_disciplina1`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `equipe569944`.`disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`aluno_graduacao` (
  `data_ingresso` TIMESTAMP NULL,
  `aluno_id` BIGINT NOT NULL,
  PRIMARY KEY (`aluno_id`),
  CONSTRAINT `fk_aluno_graduacao_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `equipe569944`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`aluno_pos_graduacao` (
  `aluno_id` BIGINT NOT NULL,
  `professor_id` BIGINT NULL,
  PRIMARY KEY (`aluno_id`),
  INDEX `fk_aluno_pos_graduacao_aluno1_idx` (`aluno_id` ASC) VISIBLE,
  INDEX `fk_aluno_pos_graduacao_professor1_idx` (`professor_id` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_pos_graduacao_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `equipe569944`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_pos_graduacao_professor1`
    FOREIGN KEY (`professor_id`)
    REFERENCES `equipe569944`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `equipe569944`.`pos_graduacao_formacao_basica` (
  `aluno_pos_graduacao_aluno_id` BIGINT NOT NULL,
  `curso_id` BIGINT NULL,
  PRIMARY KEY (`aluno_pos_graduacao_aluno_id`, `curso_id`),
  INDEX `fk_aluno_pos_graduacao_has_curso_curso1_idx` (`curso_id` ASC) VISIBLE,
  INDEX `fk_aluno_pos_graduacao_has_curso_aluno_pos_graduacao1_idx` (`aluno_pos_graduacao_aluno_id` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_pos_graduacao_has_curso_aluno_pos_graduacao1`
    FOREIGN KEY (`aluno_pos_graduacao_aluno_id`)
    REFERENCES `equipe569944`.`aluno_pos_graduacao` (`aluno_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_pos_graduacao_has_curso_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `equipe569944`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);