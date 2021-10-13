package com.witcher.bestario.repository;

import com.witcher.bestario.modelos.Monstro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonstroRepository extends JpaRepository<Monstro,Long> {

    List<Monstro> findByNomeMonstro(String nomeMonstro);
}