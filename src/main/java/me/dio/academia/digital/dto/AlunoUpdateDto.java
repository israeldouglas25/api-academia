package me.dio.academia.digital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoUpdateDto {

  private String nome;

  private String bairro;

  private LocalDate dataDeNascimento;

  public static AlunoUpdateDto of(Aluno aluno){
    AlunoUpdateDto updateDto = new AlunoUpdateDto();
    updateDto.setNome(aluno.getNome());
    updateDto.setBairro(aluno.getBairro());
    updateDto.setDataDeNascimento(aluno.getDataDeNascimento());

    return updateDto;
  }
}
