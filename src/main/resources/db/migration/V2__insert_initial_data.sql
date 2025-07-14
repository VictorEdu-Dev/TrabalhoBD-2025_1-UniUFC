-- Os IDs adicionados às inserções são redundantes, servindo apenas para organização e clareza, pois são gerados automaticamente pelo banco de dados.
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
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (9, 'Victor Eduardo', 'victorepc', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (10, 'Renato Ferreira', 'renatof', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (11, 'Francisco Antônio', 'fcoantonio', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (12, 'Jarbas Joaci', 'jarbasj', '123456', 'PROFESSOR'); -- Professor Jarbas Joaci
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (13, 'Fulano de Tal', 'fulanot', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (14, 'Evilásio Costa', 'evilasioc', '123456', 'PROFESSOR'); -- Professor Evilásio Costa
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (15, 'Luis Araripson', 'arapipson', '123456', 'PROFESSOR'); -- Professor Luis Araripe
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (16, 'José Valdenir', 'valdenir', '123456', 'PROFESSOR'); -- Professor José Valdenir
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (17, 'Rui Vigelis', 'ruivigelis', '123456', 'PROFESSOR'); -- Professor Rui Facundo
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (18, 'Nilena Brito', 'nilenabrito', '123456', 'PROFESSOR'); -- Professor Nilena Brito
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (19, 'Rômulo Nunes', 'romulonunes', '123456', 'PROFESSOR'); -- Professor Rômulo Nunes
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (20, 'Rosana Maria', 'rosanamaria', '123456', 'PROFESSOR'); -- Professor Rosana Maria
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (21, 'Juan Carlos', 'juancarlos', '123456', 'PROFESSOR'); -- Professor Juan Carlos
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (22, 'José Cláudio', 'claudionascimento', '123456', 'PROFESSOR'); -- Professor José Cláudio
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (23, 'Euclimar Passos', 'euclimarpassos', '123456', 'PROFESSOR'); -- Professor Euclimar Passos
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (24, 'Alberto Instantâneo', 'albertoinstantaneo', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (25, 'Nikola Peste', 'nikolapeste', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (26, 'Niggolau', 'niggolau', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (27, 'Tommy Lee', 'tommylee', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (28, 'Walter Black', 'walterblack', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (29, 'Mark Heisemberg', 'markheisemberg', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (30, 'Jair Inácio', 'jairinacio', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (31, 'Lula Messias', 'lulamessias', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (32, 'Albert Einstein', 'alberteinstein', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (33, 'Isaac Newton', 'isaacnewton', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (34, 'Nikola Tesla', 'nikolatesla', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (35, 'Alan Turing', 'alanturing', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (36, 'Ada Lovelace', 'adalovelace', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (37, 'Grace Hopper', 'gracehopper', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (38, 'John Von', 'johnvon', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (39, 'Charles Babbage', 'charlesbabbage', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (40, 'Michael Faraday', 'michaelfaraday', '123456', 'ALUNO');
INSERT INTO usuario (id, nome, login, senha, regra) VALUES (41, 'Richard Feynman', 'richardfeynman', '123456', 'ALUNO');

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
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
    VALUES (9, '111119', 'Luis Eduardo Araripe', '1945-09-02', '2007-08-01', 15, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
    VALUES (10, '111120', 'José Valdenir Silveira', '2004-06-26', '2007-08-01', 16, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
    VALUES (11, '111121', 'Rui Facundo Vigelis', '1980-05-15', '2007-08-01', 17, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
    VALUES (12, '111122', 'Nilena Brito Maciel Dias', '1980-05-15', '2007-08-01', 18, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
    VALUES (13, '111123', 'Rômulo Nunes de Carvalho Almeida', '1980-05-15', '2007-08-01', 19, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
    VALUES (14, '111124', 'Rosana Maria Alves Saboya', '1980-05-15', '2007-08-01', 20, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
    VALUES (15, '111125', 'Juan Carlos Peqquena Suni', '1980-05-15', '2007-08-01', 21, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
    VALUES (16, '111126', 'José Cláudio do Nascimento', '1980-05-15', '2007-08-01', 22, 1);
INSERT INTO professor (id, siape, full_name, dataNascimento, dataIngresso, usuario_id, departamento_id)
    VALUES (17, '111127', 'Euclimar Passos da Silva', '1980-05-15', '2007-08-01', 23, 1);

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
INSERT INTO emails_professor (professor_id, email) VALUES (9, 'luis@ufc.br');
INSERT INTO emails_professor (professor_id, email) VALUES (10, 'josevaldenir@gmail.com');
INSERT INTO emails_professor (professor_id, email) VALUES (11, 'ruivigelis@ufc.br');
INSERT INTO emails_professor (professor_id, email) VALUES (12, 'nilenabrito@ufc.br');
INSERT INTO emails_professor (professor_id, email) VALUES (13, 'romulonunes@ufc.br');
INSERT INTO emails_professor (professor_id, email) VALUES (14, 'rosanamaria@ufc.br');
INSERT INTO emails_professor (professor_id, email) VALUES (15, 'juancarlos@ufc.br');
INSERT INTO emails_professor (professor_id, email) VALUES (16, 'claudionascimento@ufc.br');
INSERT INTO emails_professor (professor_id, email) VALUES (17, 'euclimarpassos@ufc.br');

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
INSERT INTO telefones_professor (professor_id, telefone) VALUES (9, '(88)99999-8888');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (10, '(88)99999-9999');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (11, '(88)99999-0000');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (12, '(88)99999-1113');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (13, '(88)99999-2224');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (14, '(88)99999-3335');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (15, '(88)99999-4446');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (16, '(88)99999-5557');
INSERT INTO telefones_professor (professor_id, telefone) VALUES (17, '(88)99999-6668');

-- Disciplina de Engenharia de Computação (Obrigatórias)
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (1, 'Programação Computacional', 'SBL0086', ' Introdução à computação; sistemas de numeração; introdução aos algoritmos; tipos básicos de dados; estruturas de controle; operadores; estruturas de dados homogêneas; tipos de dados definidos pelos usuários; funções e procedimentos; arquivos; linguagem de programação C.',
        6, 'OBRIGATORIA', 1); -- Professor Primary: Fernando Rodrigues de Almeida Júnior, Professor Secondary: Erick Aguiar Donato
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (2, 'Bando de Dados', 'ECO0031', 'Visão geral de Banco de Dados; Conceitos básicos do Modelo Entidade Relacionamento, Modelo Relacional: Álgebra Relacional x Cálculo Relacional; A Linguagem SQL; Modelagem de Dados; Normalização; Projeto Lógico de Banco de Dados.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Fernando Rodrigues de Almeida Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (3, 'Estruturas de Dados', 'ECO0016', 'Listas Lineares, Árvores, Árvores binárias de busca e Árvores balanceadas.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Jarbas Joaci de Mesquits Sa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (4, 'Técnicas de Programação', 'ECO0015', 'Introdução ao conceito de subprogramas, passagem de parâmetros, variáveis locais e globais, recursividade. Aprofundamento nos conceitos de estruturas básicas de dados, variáveis dinâmicas, ponteiros. O conceito de abstração. Programação estruturada. Refinamentos sucessivos. Manipulação de arquivos. Programação orientada a objetos.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Ricardo Pires dos Santos
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (5, 'Paradigmas de Linguagem de Programação', 'ECO0020', 'Introdução aos paradigmas de programação. Evolução das linguagens de programação. Sintaxe e semântica. Nomes, ligações, checagem de tipos e escopos. Tipos de dados. Expressões e a declaração de atribuição. Estruturas de controle. Subprogramas. Tipos de dados abstratos. Programação funcional. Programação lógica.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Evilásio Costa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (6, 'Sistemas Operacionais', 'ECO0022', 'Conceitos básicos de sistemas operacionais. Gerência do processador. Entrada e saída. Gerência de memória. Memória virtual. Gerência de arquivos.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Erick Aguiar Donato
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (7, 'Redes de Computadores', 'ECO0027', 'Princípios de comunicação de dados. Conceitos básicos de redes: modelos, camadas, protocolos, serviços e arquiteturas; noções de endereçamento; tipos de rede: SAN, LAN, PAN, MAN, WAN, RAN e CAN; funcionalidade específica das camadas do software de redes: níveis (1 a 7 – modelo ISO; e 1 a 5 – modelo TCP/IP); conceitos básicos de comutação (switching), principais soluções tecnológicas para a camada física; principais tecnologias de redes locais (LAN) e de redes de longa distância (WAN); princípios de roteamento; protocolo IP: princípio de operação e endereçamento; protocolo TCP/ UDP; protocolos de aplicação da família TCP/IP: funcionalidades básicas e operação dos protocolos de correio eletrônico, transferência de arquivos, emulação de terminais, serviços de diretório de redes, suporte à aplicações Web e outros. Redes Multimídia. Confiabilidade e segurança de redes. Gerenciamento de redes. Redes sem fio e redes móveis. Introdução a comunicação óptica.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Wendley Sousa da Silva
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (8, 'Arquitetura e Organização de Computadores', 'ECO0021', 'Revisão de conceitos básicos de organização de máquinas CISC e introdução de organização de máquinas RISC. Organização de processadores: bloco operacional e bloco de controle. Organização de pipelines. Máquinas super escalares. Organização de Memória: memória cache e memória virtual. Introdução a máquinas paralelas.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Wendley Sousa da Silva
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (9, 'Engenharia de Software', 'ECO0028', 'Processo e Modelos de Processo. Gerenciamento de projeto. Estimativa de custos. Análise e especificação de requisitos. Especificações formais. Interface com o usuário. Modelagem de dados. Técnicas e modelagens para projeto. Verificação: testes, revisões e inspeções. Validação e certificação de qualidade. Gerenciamento de versões e configurações. Manutenção. Documentação.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Evilásio Costa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (10, 'Inteligência Computacional', 'ECO0029', 'Algoritmos Genéticos. Redes Neurais Artificiais. Lógica Nebulosa. Aplicações em engenharia.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Jarbas Joaci de Mesquits Sa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (11, 'Software em Tempo Real', 'ECO0036', 'Definição e classificação de sistemas de tempo real. Tempo global. Modelando sistemas de tempo real. Entidades e imagens de tempo real. Tolerância a falhas. Comunicação em tempo real. Protocolos engatilhados a tempo. Entrada e saída. Sistemas operacionais de tempo real.',
        4, 'OBRIGATORIA', 1); -- Professor Primary: Evilásio Costa Júnior

-- Disciplinas de Engenharia de Computação (Optativas)
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (12, 'Teoria dos Autômatos e Linguagens Formais', 'ECO0042', 'Introdução e Conceitos Básicos. Linguagens Regulares. Linguagens Livres de Contexto. Linguagens Enumeráveis Recursivamente e Sensíveis ao Contexto. Hierarquia de Classes de Linguagens.',
        4, 'OPTATIVA', 1); -- Professor Primary: Ricardo Pires dos Santos
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (13, 'Algoritmos em Grafos', 'ECO0046', 'Conceitos de grafos, busca, caminhos mínimos e fluxos máximos.',
        4, 'OPTATIVA', 1); -- Professor Primary: Jarbas Joaci de Mesquits Sa Júnior
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (14, 'Sistemas de Gerenciamento de Banco de Dados', 'ECO0049', 'Projeto de Banco de Dados Relacional. Sistema de armazenamento. Processamento de consultas. Otimização de consultas. Transações. Controle de concorrência. Reconstrução após falha. Segurança.',
        4, 'OPTATIVA', 1); -- Professor Primary: Fernando Rodrigues de Almeida Júnior

-- Disciplinas de Engenharia Elétrica (Obrigatórias)
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (15, 'Mecânica dos Materiais', 'EEL014', 'Introdução à Mecânica dos Materiais. Estruturas Isostáticas. Propriedades Geométricas das Seções. Tensões e Deformações. Tração e Compressão. Torção. Flexão em Vigas. Cisalhamento Puro. Cabos. Aplicações em Engenharia Elétrica.',
        4, 'OBRIGATORIA', 2); -- Professor Primary: Luis Eduardo Araripe, Professor Secondary: Ricardo Pires dos Santos
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (16, 'Variáveis Complexa', 'EEL017', 'Funções complexas. Condições de Cauchy-Riemann. Fórmula integral de Cauchy. Série de Laurent. Teorema dos resíduos. Transformação conforme. Aplicações em Engenharia Elétrica',
        4, 'OBRIGATORIA', 2); -- Professor Primary: Juan Carlos Peqquena Suni
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (17, 'Eletrônica Digital', 'EEL019', 'Sistemas de Numeração e Códigos. Portas Lógicas e Algebra Booleana. Circuitos Lógicos Combinacionais. Flip-Flops e Dispositivos Correlatos. Aritmética Digital: Operações e Circuitos. Contadores e Registradores. Contadores e Registradores. Circuitos Lógicos MSI. Interface com o Mundo Analógico. Dispositivos de Memória. Aplicações de um Dispositivo de Lógica Programável.',
        6, 'OBRIGATORIA', 2); -- Professor Primary: Rômulo Nunes de Carvalho Almeida
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (18, 'Elementos de Fenômenos de Transporte', 'EEL020', 'Conceitos fundamentais. Equações gerais da cinemática e dinâmica dos fluidos. Equações básicas para conservação de massa, momentum e energia. Escoamento externo e Interno. Transferência de calor. Condução, convecção radiação. Aplicações.',
        4, 'OBRIGATORIA', 2); -- Professor Primary: José Valdenir Silveira
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (19, 'Circuitos Elétricos I', 'EEL021', 'Introdução, definições, leis experimentais, circuitos simples. Técnicas básicas de análise de circuitos. Circuitos usando amplificadores operacionais. Indutância e capacitância. Circuitos RL e RC. Resposta de circuitos à função senoidal. Os conceitos de fasor, impedância e admitância. Resposta de circuitos em regime permanente senoidal.',
        6, 'OBRIGATORIA', 2); -- Professor Primary: Rui Facundo Vigelis
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (20, 'Eletromagnetismo Aplicado', 'EEL024', 'Análise vetorial. Campos elétricos estacionários. Energia e potencial. Materiais elétricos. Capacitancia. Equações de Poisson e Laplace. Campos magnéticos estacionários. Materiais magnéticos. Indutância e força magnética. Campos variáveis no tempo e equações de Maxwell. Propagação de ondas eletromagnéticas.',
        6, 'OBRIGATORIA', 2); -- Professor Primary: Euclimar Passos da Silva, Professor Secondary: Luis Eduardo Araripe
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (21, 'Microprocessadores', 'EEL022', 'O microprocessador como elemento da arquitetura básica de um computador digital. Microprocessadores, memória, dispositivos de entrada/saída, ciclos de máquina, conceito de interrupções, DMA. Conjunto de instruções assembly, montadores, programadores e simuladores. Exemplos de familias de Microprocessadores. exemplos de aplicações.',
        6, 'OBRIGATORIA', 2); -- Professor Primary: Rômulo Nunes de Carvalho Almeida
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (22, 'Sistemas Lineares', 'EEL025', 'Sinais e Sistemas. Sistemas lineares invariantes no tempo. Representação de Fourier para sinais e sistemas de tempo contínuo e de tempo discreto. Amostragem de sinais. Caracterização de sistemas por meio da transformada de Laplace e da transformada Z. Representação e análise de sistemas no espaço de estados. Aplicações em sistemas com realimentação.',
        4, 'OBRIGATORIA', 2); -- Professor Primary: Rômulo Nunes de Carvalho Almeida
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (23, 'Eletrônica Analógica', 'EEL026', 'Diodos Semicondutores. Aplicações do Diodo. Transitores Bipolares de Tensão. Polarização CC - TBJ. Transitores de Efeitos de Campo. Polarização do FET. Modelagem do Transitor TBJ. Análise do TBJ para Pequenos Sinais. Análise do FET para Pequenos Sinais. Análise de Sistemas - Efeito de Rs e Rl. Resposta em Freqüência do TBJ e JFET. Configurações Compostas. Amplificadores Operacionais. Amplificações do AMP-OP. Amplificadores de Potência. Cls Lineares/Digitais. Realimentação e Circuitos Osciladores. Fontes de Tensão (Reguladores de Tensão). Outros Dispositivos de Dois Terminais. pnpn e Outros Dispositivos. Osciloscópios e Outros Instrumentos de Medida.',
        6, 'OBRIGATORIA', 2); -- Professor Primary: Euclimar Passos da Silva
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (24, 'Circuitos Elétricos II', 'EEL027', 'Algebra Vetorial. Fundamentos Matemáticos da Senóide. Circuitos Básicos em CA. Potência em Circuitos CA. Ressonância Série e Paralela. Circuitos Polifásicos Equilibrados. Circuitos Trifásicos Desequilibrados. Ondas Não-Senoidais.',
        6, 'OBRIGATORIA', 2); -- Professor Primary: José Cláudio do Nascimento
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (25, 'Instrumentação, Medidas e Instalações Elétricas', 'EEL018', 'Grandezas Elétricas. Produção de Força Eletromotriz. Principais Tipos de Circuitos de Corrente Alternada. Principais Tipos de Ligação. Tecnologia dos Equipamentos e Dispositivos de Instalações Elétricas Residenciais e Respectivos Símbolos Normalizados. Circuitos Fundamentais de Instalações Elétricas Residenciais. principais tópicos da NBR 5410/1997.',
        4, 'OBRIGATORIA', 2); -- Professor Primary: Rosana Maria Alves Saboya
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (26, 'Engenharia dos Materiais', 'EEL033', 'Estrutura dos materiais. Comportamento Mecânico. Processo termomecânico. Classes de Materiais. Seleção de materiais e considerações de projeto.',
        4, 'OBRIGATORIA', 2); -- Professor Primary: Rosana Maria Alves Saboya

-- Disciplinas de Engenharia Elétrica (Optativas)
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (27, 'Fontes Alternativas de Energia', 'EEL044', 'Recurso eólico. Gerador eólico. Sistemas eólicos autónomos. Sistemas eólicos interligados à rede elétrica. Uso de ferramentas computacionais para modelagem de sistemas eólio-elétricos. Aspectos económicos dos projetos eólicos. Recurso solar. Células fotovoltaicas. Componentes básicos de uma instalação fotovoltaica. Sistemas fotovoltaicos autónomos. Sistemas fotovoltaicos interligados à rede elétrica. Uso de ferramentas computacionais para modelagem de sistemas fotovoltaicos. Biomassa: principios de conversão. Tecnologia de gaseificação. Biodigestores.',
        4, 'OPTATIVA', 2); -- Professor Primary: José Valdenir Silveira
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (28, 'Produção de Energia Elétrica', 'EEL045', 'Energia e desenvolvimento. Formas de conversão de energia convencional e alternativa. Controle de potência ativa, reativa, tensão e freqüência. Aplicações e dimensionamento. Geração distribuída.',
        4, 'OPTATIVA', 2); -- Professor Primary: Nilena Brito Maciel Dias
INSERT INTO disciplina (id, nome, codigo, ementa, creditos, tipo, curso_id)
    VALUES (29, 'Planejamento Energético', 'EEL046', 'Visão global do planejamento energético. Modelo de planejamento energético. Planejamento a longo, médio e curto prazo. Planejamento do setor elétrico como parte do planejamento global do sistema energético. Estrutura de um mercado de energia elétrica, projeção de demanda, planejamento indicativo da expansão do sistema, acesso à transmissão, regulação técnica e econòmica de sistemas de energia elétrica. Fundamentos de previsão de demanda. Técnicas de previsão alternativas. Planejamento energético integrado de uma nação. Avaliação comparativa de diferentes fontes de energia elétrica. Visão geral de metodologias de previsão de futuro.',
        4, 'OPTATIVA', 2); -- Professor Primary: Nilena Brito Maciel Dias

-- Adiciona no máximo dois professores para cada disciplina
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (1, 1), -- Fernando Rodrigues de Almeida Júnior
                                                                            (1, 6); -- Erick Aguiar Donato para Programação Computacional
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (20, 17), -- Euclimar Passos da Silva para Eletromagnetismo Aplicado
                                                                            (20, 9); -- Luis Eduardo Araripe para Eletromagnetismo Aplicado
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (15, 9), -- Luis Eduardo Araripe para Mecânica dos Materiais
                                                                            (15, 2); -- Ricardo Pires dos Santos para Mecânica dos Materiais
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (2, 1); -- Fernando Rodrigues de Almeida Júnior para Banco de Dados
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (3, 7); -- Jarbas Joaci de Mesquits Sa Júnior para Estruturas de Dados
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (4, 2); -- Ricardo Pires dos Santos para Técnicas de Programação
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (5, 8); -- Evilásio Costa Júnior para Paradigmas de Linguagem de Programação
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (6, 6); -- Erick Aguiar Donato para Sistemas Operacionais
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (7, 3); -- Wendley Sousa da Silva para Redes de Computadores
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (8, 3); -- Wendley Sousa da Silva para Arquitetura e Organização de Computadores
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (9, 8); -- Evilásio Costa Júnior para Engenharia de Software
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (10, 7); -- Jarbas Joaci de Mesquits Sa Júnior para Inteligência Computacional
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (11, 8); -- Evilásio Costa Júnior para Software em Tempo Real
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (12, 2); -- Ricardo Pires dos Santos para Teoria dos Autômatos e Linguagens Formais
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (13, 7); -- Jarbas Joaci de Mesquits Sa Júnior para Algoritmos em Grafos
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (14, 1); -- Fernando Rodrigues de Almeida Júnior para Sistemas de Gerenciamento de Banco de Dados
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (16, 15); -- Juan Carlos Peqquena Suni para Variáveis Complexa
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (17, 13); -- Rômulo Nunes de Carvalho Almeida para Eletrônica Digital
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (18, 10); -- José Valdenir Silveira para Elementos de Fenômenos de Transporte
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (19, 11); -- Rui Facundo Vigelis para Circuitos Elétricos I
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (21, 13); -- Rômulo Nunes de Carvalho Almeida para Microprocessadores
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (22, 13); -- Rômulo Nunes de Carvalho Almeida para Sistemas Lineares
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (23, 17); -- Euclimar Passos da Silva para Eletrônica Analógica
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (24, 16); -- José Cláudio do Nascimento para Circuitos Elétricos II
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (25, 14); -- Rosana Maria Alves Saboya para Instrumentação, Medidas e Instalações Elétricas
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (26, 14); -- Rosana Maria Alves Saboya para Engenharia dos Materiais
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (27, 10); -- José Valdenir Silveira para Fontes Alternativas de Energia
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (28, 12); -- Nilena Brito Maciel Dias para Produção de Energia Elétrica
INSERT INTO disciplina_has_professores (disciplina_id, professor_id) VALUES (29, 12); -- Nilena Brito Maciel Dias para Planejamento Energético


-- Disciplina Pré-requisito
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (2, 3); -- Banco de Dados requer Estruturas de Dados
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (3, 1); -- Estruturas de Dados requer Programação Computacional
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (4, 1); -- Técnicas de Programação requer Programação Computacional
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (5, 4); -- Paradigmas de Linguagem de Programação requer Técnicas de Programação
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (6, 3); -- Sistemas Operacionais requer Estruturas de Dados
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (7, 8); -- Redes de Computadores requer Arquitetura e Organização de Computadores
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (8, 1); -- Arquitetura e Organização de Computadores requer Programação Computacional
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (9, 5); -- Engenharia de Software requer Paradigmas de Linguagem de Programação
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (10, 5); -- Inteligência Computacional requer Paradigmas de Linguagem de Programação
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (10, 3); -- Inteligência Computacional requer Estruturas de Dados
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (23, 19); -- Eletrônica Analógica requer Circuitos Elétricos I
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (24, 19); -- Circuitos Elétricos II requer Circuitos Elétricos I
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (25, 19); -- Instrumentação, Medidas e Instalações Elétricas requer Circuitos Elétricos I
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (27, 18); -- Fontes Alternativas de Energia requer Elementos de Fenômenos de Transporte
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (28, 20); -- Produção de Energia Elétrica requer Eletromagnetismo Aplicado
INSERT INTO disciplina_prerequisito (disciplina_requerente_id, disciplina_prerequisito_id) VALUES (29, 20); -- Planejamento Energético requer Eletromagnetismo Aplicado

-- Aluno
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (1, '555616', 'Victor Eduardo', 'Rua Blá Blá Blá, 123, Bloco Z', 1, 9);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (2, '495228', 'Renato Ferreira Gomes Rodrigues', 'Rua Blé Blé Blé, 321, Bloco Y', 1, 10);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (3, '569944', 'Francisco Antonio Paiva de Sousa', 'Rua Blu Blu Blu, 132, Bloco X', 1, 11);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (4, '777777', 'Fulano de Tal da Silva', 'Rua Ayrton Senna, 666, Bloco Céu', 1, 13);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (5, '888888', 'Alberto Instantâneo da Silva', 'Rua Criminal, 171', 1, 24);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (6, '999999', 'Nikola Peste da Costa', 'Rua da Desgraça, 666', 1, 25);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (7, '111222', 'Niggolau da Silva Júnior', 'Travessa da Felicidade, 42', 1, 26);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (8, '333444', 'Tommy Lee Jones', 'Avenida do Rock, 80', 1, 27);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (9, '555666', 'Walter Black White', 'Beco do Cientista, 101', 1, 28);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (10, '777888', 'Mark Heisemberg Silva', 'Rua dos Gases, 99', 1, 29);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (11, '121314', 'Jair Inácio da Silva', 'Alameda das Políticas, 13', 1, 30);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (12, '151617', 'Lula Messias Bolsonaro', 'Praça da Liberdade, 777', 2, 31);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (13, '181920', 'Albert Einstein da Conceição', 'Rua da Relatividade, 1', 2, 32);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (14, '212223', 'Isaac Newton dos Santos', 'Avenida da Gravidade, 5', 2, 33);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (15, '242526', 'Nikola Tesla Filho', 'Travessa da Eletricidade, 18', 2, 34);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (16, '272829', 'Alan Turing Costa', 'Rua da Computação, 1912', 2, 35);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (17, '303132', 'Ada Lovelace Rodrigues', 'Rua da Programação, 1815', 2, 36);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (18, '333435', 'Grace Hopper Almeida', 'Rua da Almirante, 1906', 2, 37);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (19, '363738', 'John Von Neumann', 'Avenida da Lógica, 1903', 2, 38);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (20, '394041', 'Charles Babbage Sobrinho', 'Travessa do Computador, 1791', 2, 39);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (21, '424344', 'Michael Faraday Junior', 'Rua do Campo, 1791', 2, 40);
INSERT INTO alunos (id, matricula, nome, endereco, curso_id, usuario_id)
    VALUES (22, '454647', 'Richard Feynman Oliveira', 'Beco da Física, 1918', 2, 41);


-- Aluno Graduação
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (1, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (2, '2021-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (3, '2022-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (5, '2020-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (6, '2021-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (7, '2022-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (8, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (9, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (10, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (11, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (12, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (13, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (14, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (15, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (16, '2023-03-06');
INSERT INTO aluno_graduacao (aluno_id, data_ingresso) VALUES (17, '2023-03-06');

-- Aluno Pós-Graduação
INSERT INTO aluno_pos_graduacao (aluno_id, professor_orientador_id) VALUES (4, 9);
INSERT INTO aluno_pos_graduacao (aluno_id, professor_orientador_id) VALUES (18, 10);
INSERT INTO aluno_pos_graduacao (aluno_id, professor_orientador_id) VALUES (19, 11);
INSERT INTO aluno_pos_graduacao (aluno_id, professor_orientador_id) VALUES (20, 15);
INSERT INTO aluno_pos_graduacao (aluno_id, professor_orientador_id) VALUES (21, 12);
INSERT INTO aluno_pos_graduacao (aluno_id, professor_orientador_id) VALUES (22, 10);

-- Formação Básica Aluno Pós Graduação
INSERT INTO pg_formacao_basica (aluno_pos_graduacao_id, curso_id) VALUES (4, 3);
INSERT INTO pg_formacao_basica (aluno_pos_graduacao_id, curso_id) VALUES (18, 1);
INSERT INTO pg_formacao_basica (aluno_pos_graduacao_id, curso_id) VALUES (19, 3);
INSERT INTO pg_formacao_basica (aluno_pos_graduacao_id, curso_id) VALUES (20, 1);
INSERT INTO pg_formacao_basica (aluno_pos_graduacao_id, curso_id) VALUES (21, 1);
INSERT INTO pg_formacao_basica (aluno_pos_graduacao_id, curso_id) VALUES (22, 3);


-- Telefones Aluno
INSERT INTO telefones_aluno VALUES (1, '(88)98875-7777', 'Principal'),
                                   (1, '(88)3653-1952', 'Comercial');
INSERT INTO telefones_aluno VALUES (2, '(88)98875-8888', 'Principal'),
                                   (2, '(88)3653-1953', 'Comercial');
INSERT INTO telefones_aluno VALUES (3, '(88)98875-9999', 'Principal'),
                                   (3, '(88)3653-1954', 'Comercial');
INSERT INTO telefones_aluno VALUES (4, '(88)98876-0000', 'Principal'),
                                   (4, '(88)3653-1955', 'Comercial');
INSERT INTO telefones_aluno VALUES (5, '(88)98876-1111', 'Principal'),
                                   (5, '(88)3653-1956', 'Comercial');
INSERT INTO telefones_aluno VALUES (6, '(88)98876-2222', 'Principal'),
                                   (6, '(88)3653-1957', 'Comercial');
INSERT INTO telefones_aluno VALUES (7, '(88)98876-3333', 'Principal'),
                                   (7, '(88)3653-1958', 'Comercial');
INSERT INTO telefones_aluno VALUES (8, '(88)98876-4444', 'Principal'),
                                   (8, '(88)3653-1959', 'Comercial');
INSERT INTO telefones_aluno VALUES (9, '(88)98876-5555', 'Principal'),
                                   (9, '(88)3653-1960', 'Comercial');
INSERT INTO telefones_aluno VALUES (10, '(88)98876-6666', 'Principal'),
                                   (10, '(88)3653-1961', 'Comercial');
INSERT INTO telefones_aluno VALUES (11, '(88)98876-7777', 'Principal'),
                                   (11, '(88)3653-1962', 'Comercial');
INSERT INTO telefones_aluno VALUES (12, '(88)98876-8888', 'Principal'),
                                   (12, '(88)3653-1963', 'Comercial');
INSERT INTO telefones_aluno VALUES (13, '(88)98876-9999', 'Principal'),
                                   (13, '(88)3653-1964', 'Comercial');
INSERT INTO telefones_aluno VALUES (14, '(88)98877-0000', 'Principal'),
                                   (14, '(88)3653-1965', 'Comercial');
INSERT INTO telefones_aluno VALUES (15, '(88)98877-1111', 'Principal'),
                                   (15, '(88)3653-1966', 'Comercial');
INSERT INTO telefones_aluno VALUES (16, '(88)98877-2222', 'Principal'),
                                   (16, '(88)3653-1967', 'Comercial');
INSERT INTO telefones_aluno VALUES (17, '(88)98877-3333', 'Principal'),
                                   (17, '(88)3653-1968', 'Comercial');
INSERT INTO telefones_aluno VALUES (18, '(88)98877-4444', 'Principal'),
                                   (18, '(88)3653-1969', 'Comercial');
INSERT INTO telefones_aluno VALUES (19, '(88)98877-5555', 'Principal'),
                                   (19, '(88)3653-1970', 'Comercial');
INSERT INTO telefones_aluno VALUES (20, '(88)98877-6666', 'Principal'),
                                   (20, '(88)3653-1971', 'Comercial');
INSERT INTO telefones_aluno VALUES (21, '(88)98877-7777', 'Principal'),
                                   (21, '(88)3653-1972', 'Comercial');
INSERT INTO telefones_aluno VALUES (22, '(88)98877-8888', 'Principal'),
                                   (22, '(88)3653-1973', 'Comercial');

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
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (4, 2, 9.00, 0.25),
           (4, 1, 7.50, 0.67),
           (4, 3, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (5, 2, 8.00, 0.25),
           (5, 1, 7.50, 0.67),
           (5, 3, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (6, 2, 8.00, 0.25),
           (6, 1, 7.50, 0.67),
           (6, 3, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (7, 2, 8.00, 0.25),
           (7, 1, 7.50, 0.67),
           (7, 3, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (8, 2, 8.00, 0.25),
           (8, 1, 7.50, 0.67),
           (8, 3, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (9, 2, 8.00, 0.25),
           (9, 1, 7.50, 0.67),
           (9, 3, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (10, 2, 8.00, 0.25),
           (10, 1, 7.50, 0.67),
           (10, 3, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (11, 2, 8.00, 0.25),
           (11, 1, 7.50, 0.67),
           (11, 3, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (12, 16, 8.00, 0.25),
           (12, 17, 7.50, 0.67),
           (12, 18, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (13, 16, 8.00, 0.95),
           (13, 17, 7.50, 0.87),
           (13, 18, 6.00, 1.00);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (14, 16, 8.00, 0.85),
           (14, 17, 7.50, 0.67),
           (14, 18, 6.00, 0.95);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (15, 16, 8.00, 0.75),
           (15, 17, 7.50, 0.67),
           (15, 18, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (16, 16, 8.00, 0.25),
           (16, 17, 7.50, 0.67),
           (16, 18, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (17, 16, 8.00, 0.25),
           (17, 17, 7.50, 0.67),
           (17, 18, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (18, 16, 8.00, 0.25),
           (18, 17, 7.50, 0.67),
           (18, 18, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (19, 16, 8.00, 0.25),
           (19, 17, 7.50, 0.67),
           (19, 18, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (20, 16, 8.00, 0.25),
           (20, 17, 7.50, 0.67),
           (20, 18, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (21, 16, 8.00, 0.25),
           (21, 17, 7.50, 0.67),
           (21, 18, 6.00, 0.75);
INSERT INTO aluno_has_disciplinas (aluno_id, disciplina_id, media_final, frequencia)
    VALUES (22, 16, 8.00, 0.25),
           (22, 17, 7.50, 0.67),
           (22, 18, 6.00, 0.75);