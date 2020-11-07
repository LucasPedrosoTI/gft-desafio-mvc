package com.gft.staffwa.services;

import java.util.List;

import com.gft.staffwa.models.Vaga;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.repositories.Vagas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

  @Autowired
  Vagas vagas;

  public List<Vaga> filtrar(Filter filtro) {
    final String descricaoVaga = (filtro).getDescricaoVaga() == null ? "" : filtro.getDescricaoVaga();
    return this.vagas.findVagasAndFilter(descricaoVaga);
  }

  public void salvar(Vaga vaga) {
    try {
      this.vagas.save(vaga);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityViolationException("Código já registrado");
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

}
