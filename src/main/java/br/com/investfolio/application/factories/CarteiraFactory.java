package br.com.investfolio.application.factories;

import br.com.investfolio.application.dtos.viewmodel.CarteiraViewModel;
import br.com.investfolio.core.patterns.factories.BaseFactoryWithParams;
import br.com.investfolio.domain.entities.Carteira;

public class CarteiraFactory extends BaseFactoryWithParams<Carteira, CarteiraViewModel> {

    @Override
    public CarteiraViewModel create(final Carteira carteira) {

        return new CarteiraViewModel(carteira.getId(), carteira.getNome(), carteira.getDataCriacao(), carteira.getStatus());

    }
}
