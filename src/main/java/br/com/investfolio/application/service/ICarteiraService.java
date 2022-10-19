package br.com.investfolio.application.service;

import br.com.investfolio.application.dtos.inputmodel.AdicionarAtivoInputModel;
import br.com.investfolio.application.dtos.inputmodel.CarteiraInputModel;
import br.com.investfolio.core.services.IBaseService;
import br.com.investfolio.domain.entities.Carteira;

public interface ICarteiraService extends IBaseService<Carteira> {

    Carteira criar(CarteiraInputModel carteiraInputModel);

    Boolean adicionarAtivo(Long idCarteira, AdicionarAtivoInputModel input);
}
