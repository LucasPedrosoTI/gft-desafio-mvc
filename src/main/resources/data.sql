INSERT INTO tecnologia (id, nome)
values (1, "Java"),
  (2, ".Net"),
  (3, "MySQL"),
  (4, "HTML"),
  (5, "CSS");
INSERT INTO unidades_gft (
    id,
    cep,
    cidade,
    endereco,
    estado,
    nome_unidade,
    telefone
  )
VALUES (
    1,
    "06454000",
    "Barueri",
    "Alameda Rio Negro, n° 585 Ed. Padauiri, 10° andar",
    "SP",
    "GFT Alphaville",
    "1121763253"
  ),
  (
    2,
    "80230010",
    "Rebouças",
    "Av. Sete de Setembro, 2451 Torre Trinity Corporate 6º andar",
    "PR",
    "GFT Curitiba",
    "4140095700"
  ),
  (
    3,
    "18095450",
    "Jardim Sta. Rosália",
    "Av. São Francisco, 98",
    "SP",
    "GFT Sorocaba",
    "1121763553"
  );
INSERT INTO vaga (
    id,
    codigo_vaga,
    data_de_abertura,
    descricao_vaga,
    projeto,
    qtd_vagas
  )
VALUES (
    1,
    "GFTALP1",
    "2020-11-04",
    "Desenvolvedor Back End Java",
    "Banco Original",
    2
  );
INSERT INTO funcionario (
    id,
    nome,
    cargo,
    matricula,
    inicio_wa,
    termino_wa,
    local_de_trabalho_id,
    alocacao_id
  )
VALUES (
    1,
    "João",
    "Desenvolvedor Back End",
    "0123456",
    "2020-11-04",
    "2020-11-19",
    1,
    1
  );
INSERT INTO vaga_tecnologia (vaga_id, tecnologia_id)
VALUES (1, 1),
  (1, 3);
INSERT INTO funcionario_tecnologia (funcionario_id, tecnologia_id)
VALUES (1, 1),
  (1, 3),
  (1, 4);