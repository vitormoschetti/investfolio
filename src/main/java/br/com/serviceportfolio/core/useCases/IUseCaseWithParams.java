package br.com.serviceportfolio.core.useCases;

public interface IUseCaseWithParams<TParams, Tout> {

    Tout execute(TParams params);

}
