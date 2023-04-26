package br.edu.ifba.nutrition.repository;

import br.edu.ifba.nutrition.entity.Dica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DicaRepository extends JpaRepository<Dica, Long> {
}
