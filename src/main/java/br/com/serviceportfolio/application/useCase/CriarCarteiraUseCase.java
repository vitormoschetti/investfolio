package br.com.serviceportfolio.application.useCase;

import br.com.serviceportfolio.application.dtos.inputmodel.CarteiraInputModel;
import br.com.serviceportfolio.application.dtos.inputmodel.validator.CarteiraInputModelValidator;
import br.com.serviceportfolio.application.factories.CarteiraFactory;
import br.com.serviceportfolio.application.service.CarteiraService;
import br.com.serviceportfolio.core.patterns.result.OperationResult;
import br.com.serviceportfolio.core.patterns.result.OperationResultErrorMessage;
import br.com.serviceportfolio.core.useCases.IUseCaseWithParams;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CriarCarteiraUseCase implements IUseCaseWithParams<CarteiraInputModel, OperationResult> {

    private final CarteiraService carteiraService;

    @Override
    @Transactional
    public OperationResult execute(final CarteiraInputModel carteiraInputModel) {

        final var validate = new CarteiraInputModelValidator().validate(carteiraInputModel);

        if (!validate.isValid())
            return OperationResult.fail("Input inválido", HttpStatus.UNPROCESSABLE_ENTITY, new OperationResultErrorMessage(validate.getErrors()));

        final var carteira = this.carteiraService.criar(carteiraInputModel);

        final var carteiraViewModel = new CarteiraFactory().create(carteira);

        if (Objects.isNull(carteira))
            return OperationResult.fail("Carteira já existe", HttpStatus.UNPROCESSABLE_ENTITY);

        return OperationResult.sucess(carteiraViewModel, HttpStatus.CREATED);

    }
}
