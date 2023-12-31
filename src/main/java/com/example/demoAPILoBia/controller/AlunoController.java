package com.example.demoAPILoBia.controller;

import com.example.demoAPILoBia.model.Aluno;
import com.example.demoAPILoBia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ApiAluno")
public class AlunoController {

    @Autowired
    AlunoRepository alRepo;

    @GetMapping("/todos")
    public List<Aluno> buscarTodos(){
        return alRepo.findAll();
    }

    @GetMapping("/buscarRa/{ra}")
    public Optional<Aluno> buscarPorRa(@PathVariable("ra") int ra){
        return alRepo.findById(ra);
    }

    @GetMapping("/buscarNome/{nome}")
    public List<Aluno> buscarPorNome(@PathVariable("nome") String nome){
        return alRepo.findByNome(nome);
    }

    @PostMapping("/inserir")
    public void inserirAluno(@RequestBody Aluno al){
        alRepo.save(al);
    }

    @DeleteMapping("/remover")
    public void removerAluno(@RequestBody Aluno al){
        alRepo.delete(al);
    }

    @DeleteMapping("/removerRa/{ra}")
    public void removerPorID(@PathVariable("ra") int ra){
        alRepo.deleteById(ra);
    }

    @PutMapping("/atualizar")
    public void atualizarAluno(@RequestBody Aluno al){
        alRepo.save(al);
    }

    @GetMapping("/todos/ParteNome/{parteNome}")
    public List<Aluno> buscarPorParteNome(@PathVariable("parteNome") String parteNome)
    {
      return alRepo.findByParteNome(parteNome);
    }

    @GetMapping("/todos/ramaiorque/{ra}")
    public List<Aluno> buscarRaMaiorQue(@PathVariable("ra") int ra)
    {
        return alRepo.findByRaMaiorQue(ra);
    }

    @GetMapping("/todos/alturamenorque/{altura}")
    public List<Aluno> buscarAlturaMaiorQue(@PathVariable("altura") double altura)
    {
        return alRepo.findByAlturaMenorQue(altura);
    }

    @GetMapping("/todos/nomera/{nome}/{ra}")
    public List<Aluno> findByNomeRa(@PathVariable("nome") String nome, @PathVariable("ra") int ra)
    {
        return alRepo.findByNomeRa(nome, ra);
    }

    @GetMapping("/todos/nomealtura/{nome}/{altura}")
    public List<Aluno> findByNomeAltura(@PathVariable("nome") String nome, @PathVariable("altura") double altura)
    {
        return alRepo.findByNomeAltura(nome, altura);
    }



}
