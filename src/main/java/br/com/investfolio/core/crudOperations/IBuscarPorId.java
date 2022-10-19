package br.com.investfolio.core.crudOperations;

public interface IBuscarPorId<E, Key> {

    E buscarPorId(Key id);

}
