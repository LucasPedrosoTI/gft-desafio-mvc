package com.gft.staffwa.repositories;

import java.util.List;

import com.gft.staffwa.models.Vaga;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Vagas extends JpaRepository<Vaga, Long> {

  List<Vaga> findByDescricaoVagaContaining(String descricaoVaga);

}
