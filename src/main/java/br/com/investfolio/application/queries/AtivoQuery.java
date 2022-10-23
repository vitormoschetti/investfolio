package br.com.investfolio.application.queries;

import br.com.investfolio.core.patterns.cqrs.query.interfaces.BaseQuery;
import br.com.investfolio.domain.entities.Ativo;
import br.com.investfolio.infra.data.repositories.AtivoReadOnlyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AtivoQuery extends BaseQuery<AtivoReadOnlyRepository> {

    public AtivoQuery(final AtivoReadOnlyRepository readOnlyRepository) {
        super(readOnlyRepository);
    }

    public Collection<Ativo> buscarTodos() {
        return this.readOnlyRepository.findAll();
    }
}
