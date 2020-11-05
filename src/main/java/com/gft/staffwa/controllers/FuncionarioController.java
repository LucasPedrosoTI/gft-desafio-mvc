package com.gft.staffwa.controllers;

import java.util.List;

import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.services.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wa/funcionarios")
public class FuncionarioController {

  @Autowired
  private FuncionarioService funcionarioService;

  @GetMapping
  public ModelAndView renderViewFuncionarios(@ModelAttribute("filtro") Filter filtro) {
    ModelAndView mv = new ModelAndView("Funcionarios");

    List<Funcionario> funcionarios = funcionarioService.filtrar(filtro);

    mv.addObject("funcionarios", funcionarios);

    // funcionarios.forEach(u -> System.out.println(u.toString()));

    return mv;
  }
}
