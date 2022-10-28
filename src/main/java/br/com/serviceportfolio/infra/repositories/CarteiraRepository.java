package br.com.serviceportfolio.infra.repositories;

import br.com.serviceportfolio.domain.entities.Carteira;
import br.com.serviceportfolio.infra.repositories.adapters.CarteiraRepositoryAdapter;
import br.com.serviceportfolio.infra.repositories.interfaces.ICarteiraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@AllArgsConstructor
public class CarteiraRepository implements ICarteiraRepository {

    private final CarteiraRepositoryAdapter adapter;

    @Override
    public Boolean buscarPorNome(final String nome) {
        return this.adapter.buscarPorNome(nome);
    }

    @Override
    public Carteira persistir(final Carteira carteira) {
        return this.adapter.criar(carteira);
    }

    @Override
    public Carteira buscarPorId(Long idCarteira) {
        return this.adapter.buscarPorId(idCarteira);
    }

    @Override
    public Collection<Carteira> buscarTodasCarteirasAtivas() {
        return this.adapter.buscarTodasCarteirasAtivas();
    }
}
