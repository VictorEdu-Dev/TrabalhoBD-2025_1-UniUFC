START TRANSACTION;

-- Departamento
INSERT INTO departamento (id, nome, codigo) VALUES (1, 'Engenharia', 'DC0');
INSERT INTO departamento (id, nome, codigo) VALUES (2, 'Saúde', 'DS0');

-- Curso
INSERT INTO curso (id, codigo, nome, creditos, departamento_id) VALUES (1, '203', 'Engenharia de Computação', 228, 1);
INSERT INTO curso (id, codigo, nome, creditos, departamento_id) VALUES (2, '204', 'Engenharia Elétrica', 228, 1);
INSERT INTO curso (id, codigo, nome, creditos, departamento_id) VALUES (3, '205', 'Odontologia', 294, 2);

-- Usuário
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (1, '', 'root', 'root', 'DBA'); -- Usuário root para acesso ao sistema
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (2, 'Moana Bedê', 'moanabede', '123456', 'SERVIDOR'); -- Servidora Moana Bedê
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (3, 'Fernado Rodrigues', 'fernandor', '123456', 'PROFESSOR'); -- Professor Fernando Rodrigues
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (4, 'Ricardo Pires', 'rpires', '123456', 'PROFESSOR'); -- Professor Ricardo Pires
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (5, 'Wendley Souza', 'wendleys', '123456', 'PROFESSOR'); -- Professor Wendley Souza
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (6, 'Jacques Antonio', 'jacquesant', '123456', 'PROFESSOR'); -- Professor Jacques Antonio
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (7, 'José Roberto', 'joseroberto', '123456', 'PROFESSOR'); -- Professor José Roberto
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (8, 'Erick Donato', 'erickd', '123456', 'PROFESSOR'); -- Professor Erick Donato
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (9, 'Victor Eduardo', 'victorepc', '123456', 'ALUNO'); -- Aluno Victor Eduardo
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (10, 'Renato Ferreira', 'renatof', '123456', 'ALUNO'); -- Aluno Renato Ferreira
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (11, 'Francisco Antônio', 'fcoantonio', '123456', 'ALUNO'); -- Aluno Francisco Antônio
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (12, 'Jarbas Joaci', 'jarbasj', '123456', 'PROFESSOR'); -- Professor Jarbas Joaci
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (13, 'Fulano de Tal', 'fulanot', '123456', 'ALUNO'); -- Aluno Fulano de Tal
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (14, 'Evilásio Costa', 'evilasioc', '123456', 'PROFESSOR'); -- Professor Evilásio Costa

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
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
VALUES (8, '111118', 'Evilásio Costa Júnior', '1980-05-15', '2015-08-01', 14, 1);

-- Emails e Telefones dos professores
INSERT INTO emails_professor (professor_id, email) VALUES (1, 'fernandorodrigues@sobral.ufc.br'),
                                                          (1, 'fernandorodrigues@gmail.com');
INSERT INTO emails_professor (professor_id, email) VALUES (2, 'rpsantos2007@gmail.com'),
                                                          (2, 'rpsantos2007@outlook.com');
INSERT INTO emails_professor (professor_id, email) VALUES (3, 'wendley@ufc.br'),
                                                          (3, 'wendley@gmail.br');
INSERT INTO emails_professor (professor_id, email) VALUES (4, 'jacquesant@gmail.com'),
                                                          (4, 'jacquesant@outlook.com');
INSERT INTO emails_professor (professor_id, email) VALUES (5, 'joseroberto@sobral.ufc.br'),
                                                          (5, 'joseroberto@gmail.com');
INSERT INTO emails_professor (professor_id, email) VALUES (6, 'aguiardonato@ufc.br');
INSERT INTO emails_professor (professor_id, email) VALUES (7, 'jarbas_joaci@yahoo.com.br');
INSERT INTO emails_professor (professor_id, email) VALUES (8, 'evilasiojunior@ufc.br');

-- Telefones dos professores
INSERT INTO telefones_professor (professor_id, telefone) VALUES (1, '(88)99999-1111'),
                                                                (1, '(88)99999-1112');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (2, '(88)99999-2222'),
                                                                (2, '(88)99999-2223');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (3, '(88)99999-3333'),
                                                                (3, '(88)99999-3334');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (4, '(88)99999-4444'),
                                                                (4, '(88)99999-4445');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (5, '(88)99999-5555'),
                                                                (5, '(88)99999-5556');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (6, '(88)99999-6666');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (7, '(88)99999-6667');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (8, '(88)99999-7777');

-- Disciplina de Engenharia de Computação (Obrigatórias)
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id, professor_secondary_id)
VALUES (1, 'Programação Computacional', 'SBL0086', ' Introdução à computação; sistemas de numeração; introdução aos algoritmos; tipos básicos de dados; estruturas de controle; operadores; estruturas de dados homogêneas; tipos de dados definidos pelos usuários; funções e procedimentos; arquivos; linguagem de programação C.',
        6, 'OBRIGATORIA', 1, 1, 6); -- Professor Primary: Fernando Rodrigues de Almeida Júnior, Professor Secondary: Erick Aguiar Donato
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (2, 'Bando de Dados', 'ECO0031', 'Visão geral de Banco de Dados; Conceitos básicos do Modelo Entidade Relacionamento, Modelo Relacional: Álgebra Relacional x Cálculo Relacional; A Linguagem SQL; Modelagem de Dados; Normalização; Projeto Lógico de Banco de Dados.',
        4, 'OBRIGATORIA', 1, 1); -- Professor Primary: Fernando Rodrigues de Almeida Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (3, 'Estruturas de Dados', 'ECO0016', 'Listas Lineares, Árvores, Árvores binárias de busca e Árvores balanceadas.',
        4, 'OBRIGATORIA', 1, 7); -- Professor Primary: Jarbas Joaci de Mesquits Sa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (4, 'Técnicas de Programação', 'ECO0015', 'Introdução ao conceito de subprogramas, passagem de parâmetros, variáveis locais e globais, recursividade. Aprofundamento nos conceitos de estruturas básicas de dados, variáveis dinâmicas, ponteiros. O conceito de abstração. Programação estruturada. Refinamentos sucessivos. Manipulação de arquivos. Programação orientada a objetos.',
        4, 'OBRIGATORIA', 1, 2); -- Professor Primary: Ricardo Pires dos Santos
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (5, 'Paradigmas de Linguagem de Programação', 'ECO0020', 'Introdução aos paradigmas de programação. Evolução das linguagens de programação. Sintaxe e semântica. Nomes, ligações, checagem de tipos e escopos. Tipos de dados. Expressões e a declaração de atribuição. Estruturas de controle. Subprogramas. Tipos de dados abstratos. Programação funcional. Programação lógica.',
        4, 'OBRIGATORIA', 1, 8); -- Professor Primary: Evilásio Costa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (6, 'Sistemas Operacionais', 'ECO0022', 'Conceitos básicos de sistemas operacionais. Gerência do processador. Entrada e saída. Gerência de memória. Memória virtual. Gerência de arquivos.',
        4, 'OBRIGATORIA', 1, 6); -- Professor Primary: Erick Aguiar Donato
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (7, 'Redes de Computadores', 'ECO0027', 'Princípios de comunicação de dados. Conceitos básicos de redes: modelos, camadas, protocolos, serviços e arquiteturas; noções de endereçamento; tipos de rede: SAN, LAN, PAN, MAN, WAN, RAN e CAN; funcionalidade específica das camadas do software de redes: níveis (1 a 7 – modelo ISO; e 1 a 5 – modelo TCP/IP); conceitos básicos de comutação (switching), principais soluções tecnológicas para a camada física; principais tecnologias de redes locais (LAN) e de redes de longa distância (WAN); princípios de roteamento; protocolo IP: princípio de operação e endereçamento; protocolo TCP/ UDP; protocolos de aplicação da família TCP/IP: funcionalidades básicas e operação dos protocolos de correio eletrônico, transferência de arquivos, emulação de terminais, serviços de diretório de redes, suporte à aplicações Web e outros. Redes Multimídia. Confiabilidade e segurança de redes. Gerenciamento de redes. Redes sem fio e redes móveis. Introdução a comunicação óptica.',
        4, 'OBRIGATORIA', 1, 3); -- Professor Primary: Wendley Sousa da Silva
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (8, 'Arquitetura e Organização de Computadores', 'ECO0021', 'Revisão de conceitos básicos de organização de máquinas CISC e introdução de organização de máquinas RISC. Organização de processadores: bloco operacional e bloco de controle. Organização de pipelines. Máquinas super escalares. Organização de Memória: memória cache e memória virtual. Introdução a máquinas paralelas.',
        4, 'OBRIGATORIA', 1, 3); -- Professor Primary: Wendley Sousa da Silva
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (9, 'Engenharia de Software', 'ECO0028', 'Processo e Modelos de Processo. Gerenciamento de projeto. Estimativa de custos. Análise e especificação de requisitos. Especificações formais. Interface com o usuário. Modelagem de dados. Técnicas e modelagens para projeto. Verificação: testes, revisões e inspeções. Validação e certificação de qualidade. Gerenciamento de versões e configurações. Manutenção. Documentação.',
        4, 'OBRIGATORIA', 1, 8); -- Professor Primary: Evilásio Costa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (11, 'Inteligência Computacional', 'ECO0029', 'Algoritmos Genéticos. Redes Neurais Artificiais. Lógica Nebulosa. Aplicações em engenharia.',
        4, 'OBRIGATORIA', 1, 7); -- Professor Primary: Jarbas Joaci de Mesquits Sa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (12, 'Software em Tempo Real', 'ECO0036', 'Definição e classificação de sistemas de tempo real. Tempo global. Modelando sistemas de tempo real. Entidades e imagens de tempo real. Tolerância a falhas. Comunicação em tempo real. Protocolos engatilhados a tempo. Entrada e saída. Sistemas operacionais de tempo real.',
        4, 'OBRIGATORIA', 1, 8); -- Professor Primary: Evilásio Costa Júnior

-- Disciplinas de Engenharia de Computação (Optativas)
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (13, 'Teoria dos Autômatos e Linguagens Formais', 'ECO0042', 'Introdução e Conceitos Básicos. Linguagens Regulares. Linguagens Livres de Contexto. Linguagens Enumeráveis Recursivamente e Sensíveis ao Contexto. Hierarquia de Classes de Linguagens.',
        4, 'OPTATIVA', 1, 2); -- Professor Primary: Ricardo Pires dos Santos
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (14, 'Algoritmos em Grafos', 'ECO0046', 'Conceitos de grafos, busca, caminhos mínimos e fluxos máximos.',
        4, 'OPTATIVA', 1, 7); -- Professor Primary: Jarbas Joaci de Mesquits Sa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id, professor_primary_id)
VALUES (15, 'Sistemas de Gerenciamento de Banco de Dados', 'ECO0049', 'Projeto de Banco de Dados Relacional. Sistema de armazenamento. Processamento de consultas. Otimização de consultas. Transações. Controle de concorrência. Reconstrução após falha. Segurança.',
        4, 'OPTATIVA', 1, 1); -- Professor Primary: Fernando Rodrigues de Almeida Júnior

-- Disciplina Pré-requisito
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (2, 3); -- Bando de Dados requer Estruturas de Dados
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (3, 1); -- Estruturas de Dados requer Programação Computacional
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (4, 1); -- Técnicas de Programação requer Programação Computacional
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (5, 4); -- Paradigmas de Linguagem de Programação requer Técnicas de Programação
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (6, 3); -- Sistemas Operacionais requer Estruturas de Dados
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (7, 8); -- Redes de Computadores requer Arquitetura e Organização de Computadores
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (8, 1); -- Arquitetura e Organização de Computadores requer Programação Computacional
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (9, 5); -- Engenharia de Software requer Paradigmas de Linguagem de Programação
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (11, 5); -- Inteligência Computacional requer Paradigmas de Linguagem de Programação
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (11, 3); -- Inteligência Computacional requer Estruturas de Dados

-- Aluno
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
VALUES (1, '555616', 'Victor Eduardo', 'Rua Blá Blá Blá, 123, Bloco Z', 1, 9);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
VALUES (2, '495228', 'Renato Ferreira Gomes Rodrigues', 'Rua Blé Blé Blé, 321, Bloco Y', 1, 10);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
VALUES (3, '569944', 'Francisco Antonio Paiva de Sousa', 'Rua Blu Blu Blu, 132, Bloco X', 1, 11);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
VALUES (4, '777777', 'Fulano de Tal da Silva', 'Rua Ayrton Senna, 666, Bloco Céu', 1, 13);


-- Aluno Graduação
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (1, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (2, '2021-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (3, '2022-03-06');

-- Aluno Pós-Graduação
INSERT INTO aluno_pos_graduacao (aluno_id, professor_orientador_id) VALUES (4, 1);

-- Formação Básica Aluno Pós Graduação
INSERT INTO pg_formacao_basica (aluno_pos_graduacao_id, curso_id)
VALUES (4, 3);


-- Telefones Aluno
INSERT INTO telefones_aluno VALUES (1, '(88)98875-7777', 'Principal');
INSERT INTO telefones_aluno VALUES (1, '(88)3653-1952', 'Comercial');

-- Matrícula em disciplina
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
VALUES (1, 2, 2.67, 0.25),
       (1, 1, 3.50, 0.67),
       (1, 3, 4.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
VALUES (2, 2, 8.68, 0.25),
       (2, 1, 7.50, 0.67),
       (2, 3, 5.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
VALUES (3, 2, 8.67, 0.75),
       (3, 1, 3.50, 0.87),
       (3, 3, 8.00, 0.95);

COMMIT;