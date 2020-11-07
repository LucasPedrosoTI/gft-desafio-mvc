package com.gft.staffwa.controllers;

import java.util.List;

import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.repositories.Funcionarios;
import com.gft.staffwa.services.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wa/historico")
public class HistoricoController {

  @Autowired
  FuncionarioService funcionarioService;

  @Autowired
  Funcionarios funcionarios;

  @GetMapping
  public ModelAndView renderHistorico(@ModelAttribute("filtro") Filter filtro) {

    var mv = new ModelAndView("Historico");

    List<Funcionario> funcionarios = funcionarioService.filtrarAlocados(filtro);

    mv.addObject("funcionarios", funcionarios);

    return mv;
  }

  @ModelAttribute("menuHistorico")
  public boolean menuHistorico() {
    return true;
  }
}
