package com.projeto.lixo.eletronico.repository;

import com.projeto.lixo.eletronico.model.LixoEletronico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LixoEletronicoRepository extends JpaRepository<LixoEletronico, Long> {
}
