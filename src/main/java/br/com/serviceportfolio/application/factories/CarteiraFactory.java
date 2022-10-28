package br.com.serviceportfolio.application.factories;

import br.com.serviceportfolio.application.dtos.viewmodel.CarteiraViewModel;
import br.com.serviceportfolio.core.patterns.factories.BaseFactoryWithParams;
import br.com.serviceportfolio.domain.entities.Carteira;

public class CarteiraFactory extends BaseFactoryWithParams<Carteira, CarteiraViewModel> {

    @Override
    public CarteiraViewModel create(final Carteira carteira) {

        return new CarteiraViewModel(carteira.getId(), carteira.getNome(), carteira.getDataCriacao(), carteira.getStatus());

    }
}
