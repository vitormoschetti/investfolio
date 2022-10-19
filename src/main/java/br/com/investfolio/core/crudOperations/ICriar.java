package br.com.investfolio.core.crudOperations;

public interface ICriar<TParam, E> {

    E criar(TParam param);

}
