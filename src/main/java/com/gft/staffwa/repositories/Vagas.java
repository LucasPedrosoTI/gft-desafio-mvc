package com.gft.staffwa.repositories;

import java.util.List;

import com.gft.staffwa.models.Vaga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Vagas extends JpaRepository<Vaga, Long> {

  @Query("select v from Vaga v where v.qtdVagas > 0 and (v.descricaoVaga like %?1% or v.projeto like %?1%)")
  List<Vaga> findVagasAndFilter(String descricaoVaga);

}
