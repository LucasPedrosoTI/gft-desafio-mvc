package com.gft.staffwa.services;

import java.util.List;

import com.gft.staffwa.models.Tecnologia;
import com.gft.staffwa.repositories.Tecnologias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService {

  @Autowired
  Tecnologias tecnologias;

  public List<Tecnologia> findAll() {
    return tecnologias.findAll();
  }

}
