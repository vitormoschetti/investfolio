package br.com.investfolio.core.patterns.factories;

public interface IFactoryWithParams <TParams, TOut>{

    TOut create(TParams params);

}
