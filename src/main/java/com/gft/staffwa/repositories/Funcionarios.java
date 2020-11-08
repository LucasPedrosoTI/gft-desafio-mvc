package com.gft.staffwa.repositories;

import java.util.List;

import com.gft.staffwa.models.Funcionario;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Funcionarios extends JpaRepository<Funcionario, Long> {

  public List<Funcionario> findByAlocacaoIsNull();

  public Long countByAlocacaoIsNull();

  public Long countByAlocacaoIsNotNull();

  public List<Funcionario> findByNomeContainingAndAlocacaoIsNull(String nomeFuncionario, Pageable pageable);

  public List<Funcionario> findByNomeContainingAndAlocacaoIsNotNull(String nomeFuncionario, Pageable pageable);

}
