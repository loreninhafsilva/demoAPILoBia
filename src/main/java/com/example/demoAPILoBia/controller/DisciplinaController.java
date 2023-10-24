package com.example.demoAPILoBia.controller;

import com.example.demoAPILoBia.model.Disciplina;
import com.example.demoAPILoBia.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ApiDisciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaRepository dpRepo;

    @GetMapping("/buscarTodos")
    public List<Disciplina> buscarTodos(){
        return dpRepo.findAll();
    }

    @GetMapping("/buscarPorCodigo/{codigo}")
    public Optional<Disciplina> buscarPorId(@PathVariable ("codigo") int codigo){
        return dpRepo.findById(codigo);
    }

    @GetMapping("/buscarPorNome/{nome}")
    public List<Disciplina> buscarPorNome(@PathVariable ("nome") String nome){
        return dpRepo.findByNome(nome);
    }

    @GetMapping("/buscarPorSigla/{sigla}")
    public List<Disciplina> buscarPorSigla(@PathVariable ("sigla") String sigla){
        return dpRepo.findBySigla(sigla);
    }

    @PostMapping("/inserir")
    public void inserirDisciplina(@RequestBody Disciplina dp){
        dpRepo.save(dp);
    }

    @DeleteMapping("/remover")
    public void removerDisciplina(@RequestBody Disciplina dp){
        dpRepo.delete(dp);
    }

    @DeleteMapping("/removerPorId/{codigo}")
    public void removerPorId(@PathVariable ("codigo") int codigo){
        dpRepo.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizarDisciplina(@RequestBody Disciplina dp){
        dpRepo.save(dp);
    }

}
