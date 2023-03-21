package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.AlunoDto;
import me.dio.academia.digital.dto.AlunoUpdateDto;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public AlunoDto create(Aluno aluno) {
        Aluno salvo = repository.save(aluno);
        return AlunoDto.of(salvo);

    }

    @Override
    public AlunoDto get(Long id) {
        Aluno aluno = repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não existe!"));
        return AlunoDto.of(aluno);
    }

    @Override
    public List<AlunoDto> getAll() {
        return repository.findAll().stream().map(AlunoDto::of).toList();
    }

    @Override
    public AlunoUpdateDto update(Long id, Aluno aluno) {
        Aluno alunoSalvo = repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não existe!"));
        alunoSalvo.setNome(aluno.getNome());
        alunoSalvo.setBairro(aluno.getBairro());
        alunoSalvo.setDataDeNascimento(aluno.getDataDeNascimento());

        Aluno save = repository.save(alunoSalvo);
        return AlunoUpdateDto.of(save);
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Aluno não existe!");
        }
        repository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaById(Long id) {
        Aluno aluno = repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não existe!"));
        return aluno.getAvaliacoes();
    }

}
