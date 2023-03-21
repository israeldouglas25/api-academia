package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.MatriculaDto;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    MatriculaServiceImpl service;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaDto matriculaDto){
        return service.create(matriculaDto);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false)  String bairro){
        return service.getAll(bairro);
    }

    @GetMapping("/{id}")
    public Matricula get(@PathVariable Long id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
