package br.com.investfolio.infra.data.repositories;

import br.com.investfolio.core.persistence.interfaces.IReadOnlyRepository;
import br.com.investfolio.domain.entities.Carteira;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraReadOnlyRepository extends IReadOnlyRepository<Carteira, Long> {
}
