package com.gft.staffwa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tecnologia")
public class Tecnologia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Nome é obrigatório")
  @Enumerated(EnumType.STRING)
  private EnumNomeTecnologia nome;

  @ManyToMany(mappedBy = "tecnologias")
  private List<Vaga> vagas;

  @ManyToMany(mappedBy = "tecnologias")
  private List<Funcionario> funcionarios;
}
