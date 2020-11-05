package com.gft.staffwa.services;

import com.gft.staffwa.repositories.Tecnologias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService {

  @Autowired
  Tecnologias tecnologias;

}
