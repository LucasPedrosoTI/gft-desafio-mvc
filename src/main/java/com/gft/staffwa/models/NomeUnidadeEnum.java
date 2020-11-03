package com.gft.staffwa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NomeUnidadeEnum {

  GFT_ALPHAVILLE("GFT Alphaville"), GFT_SOROCABA("GFT Sorocaba"), GFT_CURITIBA("GFT Curitiba");

  @Getter
  private String descricao;

}
