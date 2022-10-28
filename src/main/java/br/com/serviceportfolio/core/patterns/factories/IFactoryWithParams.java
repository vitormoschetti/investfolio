package br.com.serviceportfolio.core.patterns.factories;

public interface IFactoryWithParams<TParams, TOut> extends IFactory {

    TOut create(TParams params);

}
