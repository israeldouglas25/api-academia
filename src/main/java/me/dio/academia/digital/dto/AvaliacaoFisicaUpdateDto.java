package me.dio.academia.digital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.AvaliacaoFisica;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaUpdateDto {

  private double peso;

  private double altura;

  public static AvaliacaoFisicaUpdateDto of(AvaliacaoFisica avaliacaoFisica){
    AvaliacaoFisicaUpdateDto avaliacaoFisicaUpdateDto = new AvaliacaoFisicaUpdateDto();
    avaliacaoFisicaUpdateDto.setAltura(avaliacaoFisica.getAltura());
    avaliacaoFisicaUpdateDto.setPeso(avaliacaoFisica.getPeso());

    return avaliacaoFisicaUpdateDto;
  }
}
