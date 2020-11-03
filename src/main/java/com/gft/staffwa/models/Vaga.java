package com.gft.staffwa.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
public class Vaga {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Data de abertura é obrigatória")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Temporal(TemporalType.DATE)
  private Date dataDeAbertura;

  @NotBlank(message = "Código da vaga é obrigatório")
  private String codigoVaga;

  @NotBlank(message = "Descrição é obrigatório")
  private String descricaoVaga;

  @NotBlank(message = "Projeto é obrigatório")
  private String projeto;

  @NotNull(message = "Quantidade de vagas é obrigatório")
  private Integer qtdVagas;

  @ManyToMany
  @JoinTable(name = "vaga_tecnologia", joinColumns = @JoinColumn(name = "vaga_id"), inverseJoinColumns = @JoinColumn(name = "tecnologia_id"))
  private List<Tecnologia> tecnologia;

  @OneToMany(mappedBy = "vaga")
  private List<Funcionario> funcionarios;

}
