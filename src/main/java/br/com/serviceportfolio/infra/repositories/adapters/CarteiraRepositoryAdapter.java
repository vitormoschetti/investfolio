package br.com.serviceportfolio.infra.repositories.adapters;

import br.com.serviceportfolio.core.patterns.adapter.BaseAdapter;
import br.com.serviceportfolio.domain.entities.Carteira;
import br.com.serviceportfolio.domain.enums.StatusCarteiraEnum;
import br.com.serviceportfolio.infra.repositories.adapters.jpa.CarteiraJPARepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

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

    public Carteira buscarPorId(final Long idCarteira) {
        return this.to.findById(idCarteira).orElse(null);
    }

    public Collection<Carteira> buscarTodasCarteirasAtivas() {
        return this.to.findAllByStatus(StatusCarteiraEnum.ATIVA.getValue());
    }
}
