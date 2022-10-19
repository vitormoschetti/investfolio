package br.com.investfolio.core.useCases;

public interface IUseCaseWithParams<TParams, Tout> {

    Tout execute(TParams params);

}
