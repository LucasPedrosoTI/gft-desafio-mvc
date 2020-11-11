INSERT INTO usuario (admin, email, senha)
VALUES (
    1,
    "admin@gft.com",
    "$2a$10$ZJJEee5s0D9GoVLxHElZgub3/y7FiXjdmgOrW2YnV8l9I4nJksybm"
  );
INSERT INTO tecnologia (nome)
VALUES ("JavaScript"),
  ("Python"),
  ("Java"),
  ("PHP"),
  ("C#"),
  ("C++"),
  ("Ruby"),
  ("CSS"),
  ("TypeScript"),
  ("C"),
  ("Swift"),
  ("Objective-C"),
  ("Scala"),
  ("R"),
  ("Go"),
  ("Shell"),
  ("PowerShell"),
  ("Perl"),
  ("Kotlin"),
  ("Haskell");
INSERT INTO unidades_gft (
    cep,
    cidade,
    endereco,
    estado,
    nome,
    telefone
  )
VALUES (
    "06454000",
    "Barueri",
    "Alameda Rio Negro, n° 585 Ed. Padauiri, 10° andar",
    "SP",
    "GFT Alphaville",
    "1121763253"
  ),
  (
    "80230010",
    "Rebouças",
    "Av. Sete de Setembro, 2451 Torre Trinity Corporate 6º andar",
    "PR",
    "GFT Sorocaba",
    "4140095700"
  ),
  (
    "18095450",
    "Jardim Sta. Rosália",
    "Av. São Francisco, 98",
    "SP",
    "GFT Curitiba",
    "1121763553"
  );
INSERT INTO vaga (
    codigo_vaga,
    data_de_abertura,
    descricao_vaga,
    projeto,
    qtd_vagas
  )
VALUES (
    "#ORIG2020",
    "2020-11-04",
    "DESENVOLVEDOR BACK END JAVA",
    "Banco Original",
    10
  ),
  (
    "#SANT2020",
    "2020-11-06",
    "ANALISTA DE TESTES",
    "Santander",
    10
  );
INSERT INTO vaga_tecnologia (vaga_id, tecnologia_id)
VALUES (1, 1),
  (1, 3),
  (2, 2),
  (2, 4);
INSERT INTO funcionario (
    nome,
    cargo,
    matricula,
    inicio_wa,
    termino_wa,
    local_de_trabalho_id
  )
VALUES (
    "João",
    "DESENVOLVEDOR_BACK",
    "0123456",
    "2020-11-04",
    "2020-11-19",
    1
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123457",
    "2020-11-05",
    "2020-11-20",
    2
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123458",
    "2020-11-05",
    "2020-11-20",
    3
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123459",
    "2020-11-06",
    "2020-11-21",
    1
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123460",
    "2020-11-07",
    "2020-11-22",
    1
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123460",
    "2020-11-07",
    "2020-11-22",
    1
  ),
  (
    "José",
    "ESTAGIARIO",
    "0123460",
    "2020-11-07",
    "2020-11-22",
    1
  );
INSERT INTO funcionario_tecnologia (funcionario_id, tecnologia_id)
VALUES (1, 1),
  (1, 3),
  (1, 4),
  (2, 1),
  (2, 4),
  (2, 5);