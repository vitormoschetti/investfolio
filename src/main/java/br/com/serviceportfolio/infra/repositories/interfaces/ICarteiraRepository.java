package br.com.serviceportfolio.infra.repositories.interfaces;


import br.com.serviceportfolio.core.IRepository;
import br.com.serviceportfolio.domain.entities.Carteira;

import java.util.Collection;

public interface ICarteiraRepository extends IRepository<Carteira> {

    Boolean buscarPorNome(String nome);

    Carteira persistir(Carteira carteira);

    Carteira buscarPorId(Long idCarteira);

    Collection<Carteira> buscarTodasCarteirasAtivas();
}
