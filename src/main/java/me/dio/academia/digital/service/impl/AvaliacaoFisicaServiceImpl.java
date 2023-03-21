package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.AvaliacaoFisicaDto;
import me.dio.academia.digital.dto.AvaliacaoFisicaUpdateDto;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaDto avaliacaoFisicaDto) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

        Aluno aluno = alunoRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Id não existe!"));

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setAltura(avaliacaoFisicaDto.getAltura());
        avaliacaoFisica.setPeso(avaliacaoFisicaDto.getPeso());

        return repository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Avaliação não existe!"));
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return repository.findAll();
    }

    @Override
    public AvaliacaoFisicaUpdateDto update(Long id, AvaliacaoFisica avaliacaoFisica) {
        AvaliacaoFisica idAvaliacao = repository.findById(id).orElseThrow(() -> new RuntimeException("Avaliação não existe!"));
        idAvaliacao.setPeso(avaliacaoFisica.getPeso());
        idAvaliacao.setAltura(avaliacaoFisica.getAltura());

        AvaliacaoFisica saved = repository.save(idAvaliacao);
        return AvaliacaoFisicaUpdateDto.of(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Avaliação não existe!");
        }
        repository.deleteById(id);
    }
}
