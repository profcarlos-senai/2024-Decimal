package br.senai.Decimal.repo;

import br.senai.Decimal.model.Dados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosRepository extends JpaRepository<Dados, Long> {
}
