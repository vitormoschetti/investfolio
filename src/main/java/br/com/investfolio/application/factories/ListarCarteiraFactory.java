package br.com.investfolio.application.factories;

import br.com.investfolio.application.dtos.viewmodel.ListarAtivosCarteiraViewModel;
import br.com.investfolio.application.dtos.viewmodel.ListarCarteiraViewModel;
import br.com.investfolio.core.patterns.factories.BaseFactoryWithParams;
import br.com.investfolio.domain.entities.Carteira;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ListarCarteiraFactory extends BaseFactoryWithParams<Carteira, ListarCarteiraViewModel> {

    @Override
    public ListarCarteiraViewModel create(final Carteira carteira) {

        if (Objects.isNull(carteira))
            return null;

        final var ativos = carteira.getAtivos();

        final var ativosCarteiraViewModel = ativos.stream().map(ativo ->
                new ListarAtivosCarteiraViewModel(ativo.getCodigo(), ativo.getTipoAtivo(), ativo.getPrecoMedio(), ativo.getQuantidade(),
                        ativo.getTotalInvestido(), ativo.getDataCompra())
        ).collect(Collectors.toList());

        return new ListarCarteiraViewModel(carteira.getNome(), carteira.getStatus(), carteira.getDataCriacao(), carteira.getTotalAtual(),
                carteira.getTotalInvestido(), ativosCarteiraViewModel);
    }
}
