package com.gft.staffwa.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.gft.staffwa.models.EnumCargo;
import com.gft.staffwa.models.EnumNomeTecnologia;
import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.models.Tecnologia;
import com.gft.staffwa.models.UnidadeGFT;
import com.gft.staffwa.models.EnumNomeUnidade;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.services.FuncionarioService;
import com.gft.staffwa.services.UnidadeGftService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/wa/funcionarios")
public class FuncionarioController {

  private static final String CADASTRO_VIEW = "CadastroFuncionario";

  @Autowired
  private FuncionarioService funcionarioService;

  @Autowired
  private UnidadeGftService unidadeGftService;

  @GetMapping
  public ModelAndView renderViewFuncionarios(@ModelAttribute("filtro") Filter filtro) {
    ModelAndView mv = new ModelAndView("Funcionarios");

    List<Funcionario> funcionarios = funcionarioService.filtrar(filtro);

    // funcionarios.forEach(f -> System.out.println(">>>> " + f.getCargo()));

    mv.addObject("funcionarios", funcionarios);

    return mv;
  }

  @GetMapping("/cadastrar")
  public ModelAndView renderCadastrarFuncionario() {

    ModelAndView mv = new ModelAndView(CADASTRO_VIEW);

    mv.addObject(new Funcionario());

    return mv;
  }

  @PostMapping("/cadastrar")
  public String salvarFuncionario(@Validated Funcionario funcionario, Errors errors, BindingResult bindingResult,
      RedirectAttributes attributes) {

    UnidadeGFT localDeTrabalho = unidadeGftService
        .findOneByNomeUnidade(funcionario.getLocalDeTrabalho().getNomeUnidade());

    funcionario.setLocalDeTrabalho(localDeTrabalho);

    List<Tecnologia> tecnologias = Optional.of(funcionario.getTecnologias()).orElse(new ArrayList<Tecnologia>());

    System.out.println(">>>> " + tecnologias.size());
    System.out.println(">>>>> " + bindingResult.toString());

    return "redirect:/wa/funcionarios/cadastrar";

    // if (errors.hasErrors()) {
    // return CADASTRO_VIEW;
    // }
    // try {
    // // funcionarioService.salvar(funcionario);
    // attributes.addFlashAttribute("mensagem", "Funcionário salvo com sucesso!");

    // return "redirect:/wa/funcionarios/cadastrar";

    // } catch (IllegalArgumentException e) {
    // errors.rejectValue("nome", null, e.getMessage());
    // return CADASTRO_VIEW;
    // }
  }

  @ModelAttribute("cargos")
  public List<EnumCargo> cargos() {
    return Arrays.asList(EnumCargo.values());
  }

  @ModelAttribute("locais")
  public List<EnumNomeUnidade> locais() {
    return Arrays.asList(EnumNomeUnidade.values());
  }

  @ModelAttribute("tecnologias")
  public List<EnumNomeTecnologia> tecnologias() {
    return Arrays.asList(EnumNomeTecnologia.values());
  }

}
