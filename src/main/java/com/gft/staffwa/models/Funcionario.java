package com.gft.staffwa.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Funcionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Nome é obrigatório")
  private String nome;

  @Enumerated(EnumType.STRING)
  private CargoEnum cargo;

  @NotBlank(message = "Matricula é obrigatório")
  private String matricula;

  @NotNull(message = "Data de início é obrigatório")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Temporal(TemporalType.DATE)
  private Date inicioWa;

  @NotNull(message = "Data de término é obrigatório")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Temporal(TemporalType.DATE)
  private Date terminoWa;

  @ManyToMany
  @JoinTable(name = "funcionario_tecnologia", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "tecnologia_id"))
  private List<Tecnologia> tecnologias;

  @ManyToOne
  @JoinColumn(name = "local_de_trabalho_id")
  private UnidadeGFT localDeTrabalho;

  @ManyToOne
  @JoinColumn(name = "alocacao_id")
  private Vaga alocacao;

}
