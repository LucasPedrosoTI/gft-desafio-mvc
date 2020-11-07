package com.gft.staffwa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AppController {

  @GetMapping
  public ModelAndView renderInicio() {
    var mv = new ModelAndView("Inicio");

    mv.addObject("menuInicio", true);
    return mv;
  }

  @ModelAttribute("inicio")
  public String inicio() {
    return "inicio";
  }
}
