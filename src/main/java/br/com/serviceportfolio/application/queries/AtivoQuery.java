package br.com.serviceportfolio.application.queries;

import br.com.serviceportfolio.core.patterns.cqrs.query.interfaces.BaseQuery;
import br.com.serviceportfolio.domain.entities.Ativo;
import br.com.serviceportfolio.infra.data.repositories.AtivoReadOnlyRepository;
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
