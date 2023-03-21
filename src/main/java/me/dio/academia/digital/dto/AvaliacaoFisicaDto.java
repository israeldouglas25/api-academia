package me.dio.academia.digital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.AvaliacaoFisica;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaDto {

    @Positive(message = "O ID do aluno precisa ser positivo")
    private Long alunoId;

    @NotNull(message = "Preencha o campo corretamente.")
    @Positive(message = "${validatedValue}' precisa ser positivo.")
    private double peso;

    @NotNull(message = "Preencha o campo corretamente.")
    @Positive(message = "${validatedValue}' precisa ser positivo.")
    @DecimalMin(value = "120", message = "'${validatedValue}' precisa ser no mínimo {value}.")
    private double altura;

}
