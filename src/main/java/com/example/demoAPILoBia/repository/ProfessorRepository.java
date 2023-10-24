package com.example.demoAPILoBia.repository;

import com.example.demoAPILoBia.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}