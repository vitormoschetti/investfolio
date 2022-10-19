package br.com.investfolio.infra.repositories.adapters.jpa;

import br.com.investfolio.domain.entities.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraJPARepository extends JpaRepository<Carteira, Long> {

    Boolean existsByNome(String nome);
}
