package br.com.serviceportfolio.core.crudOperations;

public interface ICriar<TParam, E> {

    E criar(TParam param);

}
