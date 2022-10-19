package br.com.investfolio.application.service;

import br.com.investfolio.application.dtos.inputmodel.AdicionarAtivoInputModel;
import br.com.investfolio.application.dtos.inputmodel.CarteiraInputModel;
import br.com.investfolio.domain.entities.Carteira;
import br.com.investfolio.infra.repositories.interfaces.ICarteiraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CarteiraService implements ICarteiraService {

    private final ICarteiraRepository carteiraRepository;

    @Override
    public Carteira criar(final CarteiraInputModel input) {

        final var carteiraExiste = this.carteiraRepository.buscarPorNome(input.getNome());

        if (carteiraExiste)
            return null;

        final var carteira = new Carteira();

        carteira.criar(input.getNome());

        return this.carteiraRepository.persistir(carteira);
    }

    @Override
    public Boolean adicionarAtivo(final Long idCarteira, final AdicionarAtivoInputModel input) {

        final var carteira = this.carteiraRepository.buscarPorId(idCarteira);

        if (Objects.isNull(carteira))
            return Boolean.FALSE;

        final var temAtivo = carteira.temAtivo(input.getCodigo());

        if (temAtivo)
            return Boolean.FALSE;

        carteira.adicionarNovoAtivo(input.getCodigo(), input.getQuantidade(), input.getPrecoMedio(), input.getTipoAtivo());

        this.carteiraRepository.persistir(carteira);

        return Boolean.TRUE;
    }
}
