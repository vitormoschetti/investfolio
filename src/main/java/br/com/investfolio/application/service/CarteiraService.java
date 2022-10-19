package br.com.investfolio.application.service;

import br.com.investfolio.application.dtos.inputmodel.CarteiraInputModel;
import br.com.investfolio.domain.entities.Carteira;
import br.com.investfolio.infra.repositories.interfaces.ICarteiraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

        return this.carteiraRepository.criar(carteira);
    }
}
