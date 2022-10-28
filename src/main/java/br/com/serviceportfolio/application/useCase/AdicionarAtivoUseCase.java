package br.com.serviceportfolio.application.useCase;

import br.com.serviceportfolio.application.dtos.inputmodel.AdicionarAtivoInputModel;
import br.com.serviceportfolio.application.dtos.inputmodel.validator.AdicionarAtivoInputModelValidator;
import br.com.serviceportfolio.application.service.ICarteiraService;
import br.com.serviceportfolio.core.patterns.result.OperationResult;
import br.com.serviceportfolio.core.patterns.result.OperationResultErrorMessage;
import br.com.serviceportfolio.core.useCases.IUseCaseWithParams;
import com.andrebreves.tuple.Tuple2;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdicionarAtivoUseCase implements IUseCaseWithParams<Tuple2<Long, AdicionarAtivoInputModel>, OperationResult> {

    private final ICarteiraService carteiraService;

    @Override
    public OperationResult execute(final Tuple2<Long, AdicionarAtivoInputModel> param) {

        final var idCarteira = param.v1();
        final var input = param.v2();

        final var validate = new AdicionarAtivoInputModelValidator().validate(input);

        if (!validate.isValid())
            return OperationResult.fail("Input inválido", HttpStatus.UNPROCESSABLE_ENTITY, new OperationResultErrorMessage(validate.getErrors()));

        final var result = this.carteiraService.adicionarAtivo(idCarteira, input);

        return result == Boolean.TRUE ?
                OperationResult.sucess(HttpStatus.CREATED) :
                OperationResult.fail(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
