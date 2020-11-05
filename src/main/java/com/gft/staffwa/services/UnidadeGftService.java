package com.gft.staffwa.services;

import com.gft.staffwa.models.EnumNomeUnidade;
import com.gft.staffwa.models.UnidadeGFT;
import com.gft.staffwa.repositories.UnidadesGFT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadeGftService {

  @Autowired
  UnidadesGFT unidadesGft;

  public UnidadeGFT findOneByNomeUnidade(EnumNomeUnidade nomeUnidade) {
    return unidadesGft.findByNomeUnidade(nomeUnidade);
  }
}
