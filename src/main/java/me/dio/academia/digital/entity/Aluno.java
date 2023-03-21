package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.dto.AlunoDto;
import me.dio.academia.digital.dto.AlunoUpdateDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

  public static Aluno of(AlunoDto alunoDto){
    Aluno aluno = new Aluno();
    aluno.setNome(alunoDto.getNome());
    aluno.setCpf(alunoDto.getCpf());
    aluno.setBairro(alunoDto.getBairro());
    aluno.setDataDeNascimento(alunoDto.getDataDeNascimento());

    return aluno;
  }
}
