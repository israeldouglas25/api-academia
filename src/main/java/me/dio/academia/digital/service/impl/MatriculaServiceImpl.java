package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.MatriculaDto;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    MatriculaRepository repository;

    @Autowired
    AlunoRepository alunoRepository;
    @Override
    public Matricula create(MatriculaDto matriculaDto) {
        Matricula matricula = new Matricula();

        Aluno aluno = alunoRepository.findById(matriculaDto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não existe!"));

        matricula.setAluno(aluno);

        return repository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula não existe!"));
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if(bairro == null){
            return repository.findAll();
        }else{
            return repository.findByAlunoBairro(bairro);
        }
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Matricula não existe!");
        }
        repository.deleteById(id);
    }
}
