package com.example.demoAPILoBia.repository;

import com.example.demoAPILoBia.model.Aluno;
import com.example.demoAPILoBia.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
    @Query ("select p from Professor p where p.nome like %?1% and salario >?2")
    List<Professor> findByNomeSalario (String nome, double salario);

    @Query ("select p from Professor p where p.nome like %?1% and cod <?2")
    List<Professor> findByNomeCodigo (String nome, int cod);
}