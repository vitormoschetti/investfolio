package br.com.investfolio.core.patterns.cqrs.query.interfaces;

import br.com.investfolio.core.persistence.interfaces.IReadOnlyRepository;

public abstract class BaseQuery<R extends IReadOnlyRepository> implements IQuery<R> {

    protected R readOnlyRepository;

    public BaseQuery(final R readOnlyRepository) {
        this.readOnlyRepository = readOnlyRepository;
    }
}
