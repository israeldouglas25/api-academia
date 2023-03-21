package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.dto.AlunoDto;
import me.dio.academia.digital.dto.AlunoUpdateDto;
import me.dio.academia.digital.entity.AvaliacaoFisica;

import java.util.List;

public interface IAlunoService {
  /**
   * Cria um Aluno e salva no banco de dados.
   * @param aluno - dto referente aos dados para criação de um Aluno no banco de dados.
   * @return - Aluno recém-criado.
   */
  AlunoDto create(Aluno aluno);

  /**
   * Retorna um Aluno que está no banco de dados de acordo com seu Id.
   * @param id - id do Aluno que será exibido.
   * @return - Aluno de acordo com o Id fornecido.
   */
  AlunoDto get(Long id);

  /**
   * Retorna todos os Alunos que estão no banco de dados.
   * @return - Uma lista os Alunos que estão salvas no DB.
   */
  List<AlunoDto> getAll();

  /**
   * Atualiza o Aluno.
   * @param id - id do Aluno que será atualizado.
   * @param aluno - dto referente aos dados necessários para atualização do Aluno
   * no banco de dados.
   * @return - Aluno recém-atualizado.
   */
  AlunoUpdateDto update(Long id, Aluno aluno);

  /**
   * Deleta um Aluno específico.
   * @param id - id do Aluno que será removido.
   */
  void delete(Long id);


  List<AvaliacaoFisica> getAllAvaliacaoFisicaById(Long id);
}
