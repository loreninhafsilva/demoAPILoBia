package com.example.demoAPILoBia.repository;

import com.example.demoAPILoBia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AlunoRepository extends JpaRepository <Aluno,Integer> {

    List<Aluno> findByNome(String nome);

    @Query("select a from Aluno a where a.nome like %?1%")
    List<Aluno> findByParteNome(String parteNome);
}
