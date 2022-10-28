package br.com.serviceportfolio.core.patterns.cqrs.query.interfaces;

import br.com.serviceportfolio.core.persistence.interfaces.IReadOnlyRepository;

public abstract class BaseQuery<R extends IReadOnlyRepository> implements IQuery<R> {

    protected R readOnlyRepository;

    public BaseQuery(final R readOnlyRepository) {
        this.readOnlyRepository = readOnlyRepository;
    }
}
