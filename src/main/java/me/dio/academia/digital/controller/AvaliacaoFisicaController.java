package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.AvaliacaoFisicaDto;
import me.dio.academia.digital.dto.AvaliacaoFisicaUpdateDto;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) {
        return service.create(avaliacaoFisicaDto);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AvaliacaoFisica getById(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public AvaliacaoFisicaUpdateDto update(@PathVariable Long id, @RequestBody AvaliacaoFisica avaliacaoFisica) {
        return service.update(id, avaliacaoFisica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
