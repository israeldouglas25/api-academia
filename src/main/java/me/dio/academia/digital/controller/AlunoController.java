package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.AlunoDto;
import me.dio.academia.digital.dto.AlunoUpdateDto;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<AlunoDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public AlunoDto create(@Valid @RequestBody AlunoDto alunoDto) {
        return service.create(Aluno.of(alunoDto));
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaFisicaById(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaById(id);
    }

    @GetMapping("/{id}")
    public AlunoDto getById(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public AlunoUpdateDto update(@PathVariable Long id, @RequestBody AlunoDto alunoDto) {
        return service.update(id, Aluno.of(alunoDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
