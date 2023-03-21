package me.dio.academia.digital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDto {

  @NotEmpty(message = "Preencha o campo corretamente.")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa esta entre {min} e {max} caracteres.")
  private String nome;

  @NotEmpty(message = "Preencha o campo corretamente.")
  @CPF(message = "CPF: '${validatedValue}' é invalido!")
  private String cpf;

  @NotEmpty(message = "Preencha o campo corretamente.")
  @Size(min = 3, max = 100, message = "'${validatedValue}' precisa esta entre {min} e {max} caracteres.")
  private String bairro;

  @NotNull(message = "Preencha o campo corretamente.")
  @Past(message = "A data '${validatedValue}' é invalida!")
  private LocalDate dataDeNascimento;


  public static AlunoDto of(Aluno aluno){
    AlunoDto alunoDto = new AlunoDto();
    alunoDto.setNome(aluno.getNome());
    alunoDto.setCpf(aluno.getCpf());
    alunoDto.setBairro(aluno.getBairro());
    alunoDto.setDataDeNascimento(aluno.getDataDeNascimento());

    return alunoDto;
  }

}
