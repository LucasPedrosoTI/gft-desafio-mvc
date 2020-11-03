package com.gft.staffwa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CargoEnum {

  ANALISTA_DE_SISTEMAS("Analista de Sistemas"), DESENVOLVEDOR_FRONT("Desenvolvedor Front End"),
  DESENVOLVEDOR_BACK("Desenvolvedor Back End"), DESENVOLVEDOR_FULL("Desenvolvedor Full Stack"),
  ESTAGIARIO("Estagiário"), ENGENHEIRO_SOFTWARE("Engenheiro de Software"), ANALISTA_TESTES("Analista de Testes"),
  ARQUITETO_SOFTWARE("Arquiteto de Software"), GESTOR_PROJETOS("Gestor de Projetos"), SCRUM_MASTER("Scrum Master"),
  UX_DESIGNER("UX Designer"), ANALISTA_NEGOCIOS("Analista de Negocios"), PROJECT_OWNER("Project Owner"),
  QUALITY_ASSURANCE("Quality Assurance"), TECH_LEAD("Tech Lead");

  @Getter
  private String descricao;
}
