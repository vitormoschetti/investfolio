package br.com.serviceportfolio.infra.repositories.adapters.jpa;

import br.com.serviceportfolio.domain.entities.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CarteiraJPARepository extends JpaRepository<Carteira, Long> {

    Boolean existsByNome(String nome);

    Collection<Carteira> findAllByStatus(final Character value);
}
