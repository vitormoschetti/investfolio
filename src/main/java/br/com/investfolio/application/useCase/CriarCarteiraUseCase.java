package br.com.investfolio.application.useCase;

import br.com.investfolio.application.dtos.inputmodel.CarteiraInputModel;
import br.com.investfolio.application.dtos.viewmodel.CarteiraViewModel;
import br.com.investfolio.application.factory.CarteiraFactory;
import br.com.investfolio.application.service.CarteiraService;
import br.com.investfolio.core.patterns.result.OperationResult;
import br.com.investfolio.core.useCases.IUseCaseWithParams;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CriarCarteiraUseCase implements IUseCaseWithParams<CarteiraInputModel, OperationResult<CarteiraViewModel>> {

    private final CarteiraService carteiraService;

    @Override
    @Transactional
    public OperationResult<CarteiraViewModel> execute(final CarteiraInputModel carteiraInputModel) {

        final var carteira = this.carteiraService.criar(carteiraInputModel);

        return new CarteiraFactory().create(carteira);
    }
}
