-- Departamento
INSERT INTO departamento (id, nome, codigo) VALUES (1, 'Engenharia', 'DC0');
INSERT INTO departamento (id, nome, codigo) VALUES (2, 'Saúde', 'DS0');

-- Curso
INSERT INTO curso (id, codigo, nome, creditos, departamento_id) VALUES (1, '203', 'Engenharia de Computação', 228, 1);
INSERT INTO curso (id, codigo, nome, creditos, departamento_id) VALUES (2, '204', 'Engenharia Elétrica', 228, 1);
INSERT INTO curso (id, codigo, nome, creditos, departamento_id) VALUES (3, '205', 'Odontologia', 294, 2);

-- Usuário
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (1, '', 'root', 'root', 'DBA');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (2, 'Moana Bedê', 'moanabede', '123456', 'SERVIDOR');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (3, 'Fernado Rodrigues', 'fernandor', '123456', 'PROFESSOR');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (4, 'Ricardo Pires', 'rpires', '123456', 'PROFESSOR');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (5, 'Wendley Souza', 'wendleys', '123456', 'PROFESSOR');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (6, 'Jacques Antonio', 'jacquesant', '123456', 'PROFESSOR');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (7, 'José Roberto', 'joseroberto', '123456', 'PROFESSOR');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (8, 'Erick Donato', 'erickd', '123456', 'PROFESSOR');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (9, 'Victor Eduardo', 'victorepc', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (10, 'Renato Ferreira', 'renatof', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (11, 'Francisco Antônio', 'fcoantonio', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (12, 'Jarbas Joaci', 'jarbasj', '123456', 'PROFESSOR');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (13, 'Fulano de Tal', 'fulanot', '123456', 'ALUNO');

-- Professor
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
VALUES (1, '111111', 'Fernando Rodrigues de Almeida Júnior', '2000-01-01', '2007-01-01', 3, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
VALUES (2, '111112', 'Ricardo Pires dos Santos', '1890-01-10', '2007-01-01', 4, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
VALUES (3, '111113', 'Wendley Sousa da Silva', '1890-01-10', '2007-01-01', 5, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
VALUES (4, '111114', 'Jacques Antonio Cavalcante Maciel', '1990-01-10', '2010-01-01', 6, 2);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
VALUES (5, '111115', 'José Roberto Viana Silva', '1990-01-10', '2010-01-01', 7, 2);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
VALUES (6, '111116', 'Erick Aguiar Donato', '2000-01-01', '2007-01-01', 8, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
VALUES (7, '111117', 'Jarbas Joaci de Mesquits Sa Júnior', '2000-01-01', '2007-01-01', 12, 1);

-- Emails e Telefones dos professores
INSERT INTO emails_professor VALUES (1, 'fernandorodrigues@sobral.ufc.br');
INSERT INTO emails_professor VALUES (1, 'fernandorodrigues@gmail.com');
INSERT INTO emails_professor VALUES (2, 'rpsantos2007@gmail.com');
INSERT INTO emails_professor VALUES (2, 'rpsantos2007@outlook.com');
INSERT INTO emails_professor VALUES (3, 'wendley@ufc.br');
INSERT INTO emails_professor VALUES (3, 'wendley@gmail.br');
INSERT INTO emails_professor VALUES (4, 'jacquesant@gmail.com');
INSERT INTO emails_professor VALUES (4, 'jacquesant@outlook.com');
INSERT INTO emails_professor VALUES (5, 'joseroberto@sobral.ufc.br');
INSERT INTO emails_professor VALUES (5, 'joseroberto@gmail.com');
INSERT INTO emails_professor VALUES (6, 'aguiardonato@ufc.br');
INSERT INTO emails_professor VALUES (7, 'jarbas_joaci@yahoo.com.br');

-- Telefones dos professores
INSERT INTO telefones_professor VALUES (1, '(88)99999-1111');
INSERT INTO telefones_professor VALUES (1, '(88)99999-1112');
INSERT INTO telefones_professor VALUES (2, '(88)99999-2222');
INSERT INTO telefones_professor VALUES (2, '(88)99999-2223');
INSERT INTO telefones_professor VALUES (3, '(88)99999-3333');
INSERT INTO telefones_professor VALUES (3, '(88)99999-3334');
INSERT INTO telefones_professor VALUES (4, '(88)99999-4444');
INSERT INTO telefones_professor VALUES (4, '(88)99999-4445');
INSERT INTO telefones_professor VALUES (5, '(88)99999-5555');
INSERT INTO telefones_professor VALUES (5, '(88)99999-5556');
INSERT INTO telefones_professor VALUES (6, '(88)99999-6666');
INSERT INTO telefones_professor VALUES (7, '(88)99999-6667');

-- Disciplina
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id, professor_secondary_id)
VALUES (1, 'Programação Computacional', 'SBL0086', ' Introdução à computação; sistemas de numeração; introdução aos algoritmos; tipos básicos de dados; estruturas de controle; operadores; estruturas de dados homogêneas; tipos de dados definidos pelos usuários; funções e procedimentos; arquivos; linguagem de programação C.',
        6, 'OBRIGATORIA', 1, 1, 6);
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (2, 'Bando de Dados', 'ECO0031', 'Visão geral de Banco de Dados; Conceitos básicos do Modelo Entidade Relacionamento, Modelo Relacional: Álgebra Relacional x Cálculo Relacional; A Linguagem SQL; Modelagem de Dados; Normalização; Projeto Lógico de Banco de Dados.',
        4, 'OBRIGATORIA', 1, 1);
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (3, 'Estruturas de Dados', 'ECO0016', 'Listas Lineares, Árvores, Árvores binárias de busca e Árvores balanceadas.',
        4, 'OBRIGATORIA', 1, 1);

-- Disciplina Pré-requisito
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (2, 3);
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (3, 1);

-- Aluno
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id, tipo_aluno)
VALUES (1, '555616', 'Victor Eduardo', 'Rua Blá Blá Blá, 123, Bloco Z', 1, 9, 'GRADUACAO');
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id, tipo_aluno)
VALUES (2, '495228', 'Renato Ferreira Gomes Rodrigues', 'Rua Blé Blé Blé, 321, Bloco Y', 1, 10, 'GRADUACAO');
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id, tipo_aluno)
VALUES (3, '569944', 'Francisco Antonio Paiva de Sousa', 'Rua Blu Blu Blu, 132, Bloco X', 1, 11, 'GRADUACAO');
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id, tipo_aluno)
VALUES (4, '777777', 'Fulano de Tal da Silva', 'Rua Ayrton Senna, 666, Bloco Céu', 1, 13, 'POS_GRADUACAO');


-- Aluno Graduação
INSERT INTO alunos_graduacao VALUES (1, '2023-03-06');
INSERT INTO alunos_graduacao VALUES (2, '2021-03-06');
INSERT INTO alunos_graduacao VALUES (3, '2022-03-06');

-- Aluno Pós-Graduação
INSERT INTO alunos_pos_graduacao (aluno_id, professor_orientador_id) VALUES (4, 1);

-- Formação Básica Aluno Pós Graduação
INSERT INTO pg_formacao_basica (aluno_pos_graduacao_id, curso_id)
VALUES (4, 3);


-- Telefones Aluno
INSERT INTO telefones_aluno VALUES (1, '(88)98875-7777', 'Principal');
INSERT INTO telefones_aluno VALUES (1, '(88)3653-1952', 'Comercial');

-- Matrícula em disciplina
INSERT INTO aluno_has_disciplinas VALUES (1, 2);
INSERT INTO aluno_has_disciplinas VALUES (1, 1);
INSERT INTO aluno_has_disciplinas VALUES (1, 3);
INSERT INTO aluno_has_disciplinas VALUES (2, 2);
INSERT INTO aluno_has_disciplinas VALUES (2, 1);
INSERT INTO aluno_has_disciplinas VALUES (2, 3);
INSERT INTO aluno_has_disciplinas VALUES (3, 2);
INSERT INTO aluno_has_disciplinas VALUES (3, 1);
INSERT INTO aluno_has_disciplinas VALUES (3, 3);
