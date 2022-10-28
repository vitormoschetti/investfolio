package br.com.serviceportfolio.infra.data.repositories;

import br.com.serviceportfolio.core.persistence.interfaces.IReadOnlyRepository;
import br.com.serviceportfolio.domain.entities.Carteira;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraReadOnlyRepository extends IReadOnlyRepository<Carteira, Long> {
}
