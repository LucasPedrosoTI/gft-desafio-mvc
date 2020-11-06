package com.gft.staffwa.controllers;

import java.util.List;

import com.gft.staffwa.models.Vaga;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.services.VagaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wa/vagas")
public class VagaController {

  @Autowired
  VagaService vagaService;

  @GetMapping
  public ModelAndView renderViewFuncionarios(@ModelAttribute("filtro") Filter filtro) {
    ModelAndView mv = new ModelAndView("Vagas");

    List<Vaga> vagas = this.vagaService.filtrar(filtro);

    mv.addObject("vagas", vagas);

    return mv;
  }

}
