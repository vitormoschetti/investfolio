package br.com.investfolio.core.query;

public interface IQuery<TParam, Tout> {

    Tout execute(TParam tParam);

}
