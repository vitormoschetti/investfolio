package br.com.investfolio.core.patterns.factories;

public abstract class BaseFactoryWithParams<TParams, TOut> implements IFactoryWithParams<TParams, TOut> {

    @Override
    public TOut create() {
        return null;
    }

    @Override
    public abstract TOut create(TParams params);
}
