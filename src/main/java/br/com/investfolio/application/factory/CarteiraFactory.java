package br.com.investfolio.application.factory;

import br.com.investfolio.application.dtos.viewmodel.CarteiraViewModel;
import br.com.investfolio.core.patterns.factories.IFactoryWithParams;
import br.com.investfolio.core.patterns.result.OperationResult;
import br.com.investfolio.domain.entities.Carteira;
import org.springframework.http.HttpStatus;

import java.util.Objects;

public class CarteiraFactory implements IFactoryWithParams<Carteira, OperationResult<CarteiraViewModel>> {

    @Override
    public OperationResult<CarteiraViewModel> create(final Carteira carteira) {

        if (Objects.isNull(carteira))
            return OperationResult.fail("Carteira já existe", HttpStatus.UNPROCESSABLE_ENTITY);

        final var carteiraViewModel = new CarteiraViewModel(carteira.getId(), carteira.getNome(), carteira.getDataCriacao(), carteira.getStatus());

        return OperationResult.sucess(carteiraViewModel, HttpStatus.CREATED);
    }
}
