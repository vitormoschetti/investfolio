package br.com.investfolio.application.useCase;

import br.com.investfolio.application.dtos.inputmodel.AdicionarAtivoInputModel;
import br.com.investfolio.application.service.ICarteiraService;
import br.com.investfolio.core.patterns.result.OperationResult;
import br.com.investfolio.core.useCases.IUseCaseWithParams;
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

        final var result = this.carteiraService.adicionarAtivo(idCarteira, input);

        return result == Boolean.TRUE ?
                OperationResult.sucess(HttpStatus.CREATED) :
                OperationResult.fail(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
