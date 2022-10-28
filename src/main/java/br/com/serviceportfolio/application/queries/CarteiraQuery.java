package br.com.serviceportfolio.application.queries;

import br.com.serviceportfolio.application.factories.ListarCarteiraFactory;
import br.com.serviceportfolio.core.patterns.cqrs.query.interfaces.BaseQuery;
import br.com.serviceportfolio.core.patterns.result.OperationResult;
import br.com.serviceportfolio.infra.data.repositories.CarteiraReadOnlyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarteiraQuery extends BaseQuery<CarteiraReadOnlyRepository> {

    private final ListarCarteiraFactory factory;

    public CarteiraQuery(final CarteiraReadOnlyRepository readOnlyRepository, ListarCarteiraFactory factory) {
        super(readOnlyRepository);
        this.factory = factory;
    }

    public OperationResult buscarPorId(Long idCarteira) {

        final var carteira = this.readOnlyRepository.findById(idCarteira).orElse(null);

        final var listarCarteiraViewModel = this.factory.create(carteira);

        if (Objects.isNull(listarCarteiraViewModel))
            return OperationResult.fail("Carteira não encontrada", HttpStatus.NOT_FOUND);

        return OperationResult.sucess(listarCarteiraViewModel, HttpStatus.OK);

    }
}
