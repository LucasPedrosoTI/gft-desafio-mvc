package com.gft.staffwa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "unidades_gft")
public class UnidadeGFT {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private NomeUnidadeEnum nomeUnidade;

  @NotBlank(message = "CEP é obrigatório")
  @Pattern(regexp = "[\\d]{8}")
  private String cep;

  @NotBlank(message = "Cidade é obrigatório")
  private String cidade;

  @NotBlank(message = "Endereco é obrigatório")
  private String endereco;

  @NotBlank(message = "Estado é obrigatório")
  @Size(min = 2, max = 2, message = "Utilizar UF de 2 caracteres")
  private String estado;

  @NotBlank(message = "Telefone é obrigatório")
  private String telefone;

  @OneToMany(mappedBy = "unidades_gft")
  private List<Funcionario> funcionarios;

}
