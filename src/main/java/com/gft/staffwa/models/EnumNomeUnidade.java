package com.gft.staffwa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum EnumNomeUnidade {

  GFT_ALPHAVILLE("GFT Alphaville"), GFT_SOROCABA("GFT Sorocaba"), GFT_CURITIBA("GFT Curitiba");

  @Getter
  private String descricao;

}
