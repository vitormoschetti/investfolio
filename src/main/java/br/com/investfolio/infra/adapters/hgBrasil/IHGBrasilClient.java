package br.com.investfolio.infra.adapters.hgBrasil;

import br.com.investfolio.core.httpClient.interfaces.IHttpClient;
import br.com.investfolio.infra.adapters.hgBrasil.dtos.AtivoHGInputModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHGBrasilClient extends IHttpClient {

    @GetMapping("/stock_price")
    ResponseEntity<AtivoHGInputModel> buscarAtivo(@RequestParam(name = "symbol") String codigo);


}
