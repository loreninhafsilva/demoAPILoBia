package com.example.demoAPILoBia.controller;

import com.example.demoAPILoBia.model.Aluno;
import com.example.demoAPILoBia.model.Professor;
import com.example.demoAPILoBia.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ApiProf")
public class ProfessorController {

    @Autowired
    ProfessorRepository profRepo;

    @GetMapping("/todosProf")
    public List<Professor> buscarTodos(){
        return profRepo.findAll();
    }

    @GetMapping("/todosProf/codigo/{codigo}")
    public Optional<Professor> buscarPorCodigo(@PathVariable("codigo") int codigo){
        return profRepo.findById(codigo);
    }

    @PostMapping("/inserirProf")
    public void inserirProfessor(@RequestBody Professor pf){
        profRepo.save(pf);
    }

    @DeleteMapping("/deletarProf")
    public void removerProf(@RequestBody Professor pf){
        profRepo.delete(pf);
    }

    @DeleteMapping("/deletarCodigo/{codigo}")
    public void removerPorCodigo(@PathVariable("codigo") int codigo){
        profRepo.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizarProf(@RequestBody Professor pf){
        profRepo.save(pf);
    }

    @GetMapping("/todos/nomesalario/{nome}/{salario}")
    public List<Professor> findByNomeSalario (@PathVariable("nome") String nome, @PathVariable("salario") double salario)
    {
        return profRepo.findByNomeSalario(nome, salario);
    }

    @GetMapping("/todos/nomecodigo/{nome}/{cod}")
    public List<Professor> findByNomeCodigo (@PathVariable("nome") String nome, @PathVariable("cod") int cod)
    {
        return profRepo.findByNomeCodigo(nome, cod);
    }
}
