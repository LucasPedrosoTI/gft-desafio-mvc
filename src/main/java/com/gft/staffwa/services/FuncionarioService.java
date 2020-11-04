package com.gft.staffwa.services;

import java.util.List;

import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.repositories.Funcionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

  @Autowired
  private Funcionarios funcionarios;

  public List<Funcionario> filtrar() {
    return funcionarios.findAll();
  }
}
