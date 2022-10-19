package br.com.investfolio.infra.repositories.interfaces;


import br.com.investfolio.core.IRepository;
import br.com.investfolio.domain.entities.Carteira;

public interface ICarteiraRepository extends IRepository<Carteira> {

    Boolean buscarPorNome(String nome);

    Carteira persistir(Carteira carteira);

    Carteira buscarPorId(Long idCarteira);
}
