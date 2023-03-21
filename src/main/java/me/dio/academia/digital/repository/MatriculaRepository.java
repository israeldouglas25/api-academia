package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    /**
     *
     * @param bairro bairro para pesquisar
     * @return retorna todos os alunos do bairro especificado
     */
    List<Matricula> findByAlunoBairro(String bairro);
}
