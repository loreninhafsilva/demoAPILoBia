package com.example.demoAPILoBia.repository;

import com.example.demoAPILoBia.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository <Disciplina, Integer>  {

    List<Disciplina> findByNome(String nome);
    List<Disciplina> findBySigla(String sigla);
}
