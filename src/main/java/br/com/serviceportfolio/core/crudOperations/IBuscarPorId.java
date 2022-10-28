package br.com.serviceportfolio.core.crudOperations;

public interface IBuscarPorId<E, Key> {

    E buscarPorId(Key id);

}
