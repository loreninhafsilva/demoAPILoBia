package com.example.demoAPILoBia.repository;

import com.example.demoAPILoBia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AlunoRepository extends JpaRepository <Aluno,Integer> {

    List<Aluno> findByNome(String nome);

    @Query("select a from Aluno a where a.nome like %?1%")
    List<Aluno> findByParteNome(String parteNome);

    @Query ("select a from Aluno a where a.ra >?1")
    List<Aluno> findByRaMaiorQue (int ra);

    @Query ("select a from Aluno a where a.altura <?1")
    List<Aluno> findByAlturaMenorQue (double altura);

    @Query ("select a from Aluno a where a.nome like %?1% and ra >?2")
    List<Aluno>findByNomeRa (String nome, int ra);

    @Query ("select a from Aluno a where a.nome like %?1% and altura >?2")
    List<Aluno>findByNomeAltura (String nome, double altura);
}
