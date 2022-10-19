package br.com.investfolio.infra.repositories;

import br.com.investfolio.domain.entities.Carteira;
import br.com.investfolio.infra.repositories.adapters.CarteiraRepositoryAdapter;
import br.com.investfolio.infra.repositories.interfaces.ICarteiraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CarteiraRepository implements ICarteiraRepository {

    private final CarteiraRepositoryAdapter adapter;

    @Override
    public Boolean buscarPorNome(final String nome) {
        return this.adapter.buscarPorNome(nome);
    }

    @Override
    public Carteira criar(final Carteira carteira) {
        return this.adapter.criar(carteira);
    }
}
