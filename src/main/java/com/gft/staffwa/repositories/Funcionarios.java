package com.gft.staffwa.repositories;

import java.util.List;

import com.gft.staffwa.models.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Funcionarios extends JpaRepository<Funcionario, Long> {
  public List<Funcionario> findByNomeContainingAndAlocacaoIsNull(String nomeFuncionario);
}
