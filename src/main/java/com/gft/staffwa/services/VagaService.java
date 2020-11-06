package com.gft.staffwa.services;

import java.util.List;

import com.gft.staffwa.models.Vaga;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.repositories.Vagas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

  @Autowired
  Vagas vagas;

  public List<Vaga> filtrar(Filter filtro) {
    final String descricaoVaga = (filtro).getDescricaoVaga() == null ? "" : filtro.getDescricaoVaga();
    return this.vagas.findByDescricaoVagaContaining(descricaoVaga);
  }

}
