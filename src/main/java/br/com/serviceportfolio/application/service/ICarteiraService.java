package br.com.serviceportfolio.application.service;

import br.com.serviceportfolio.application.dtos.inputmodel.AdicionarAtivoInputModel;
import br.com.serviceportfolio.application.dtos.inputmodel.CarteiraInputModel;
import br.com.serviceportfolio.core.services.IBaseService;
import br.com.serviceportfolio.domain.entities.Carteira;

public interface ICarteiraService extends IBaseService<Carteira> {

    Carteira criar(CarteiraInputModel carteiraInputModel);

    Boolean adicionarAtivo(Long idCarteira, AdicionarAtivoInputModel input);
}
