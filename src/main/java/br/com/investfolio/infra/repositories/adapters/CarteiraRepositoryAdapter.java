package br.com.investfolio.infra.repositories.adapters;

import br.com.investfolio.core.patterns.adapter.BaseAdapter;
import br.com.investfolio.domain.entities.Carteira;
import br.com.investfolio.infra.repositories.adapters.jpa.CarteiraJPARepository;
import org.springframework.stereotype.Component;

@Component
public class CarteiraRepositoryAdapter extends BaseAdapter<CarteiraJPARepository> {

    protected CarteiraRepositoryAdapter(final CarteiraJPARepository to) {
        super(to);
    }

    public Boolean buscarPorNome(final String nome) {
        return this.to.existsByNome(nome);
    }

    public Carteira criar(final Carteira carteira) {
        return this.to.save(carteira);
    }
}
