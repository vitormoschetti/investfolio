package br.com.investfolio.infra.adapters.hgBrasil;

import br.com.investfolio.infra.adapters.hgBrasil.dtos.AtivoHGInputModel;
import br.com.investfolio.infra.adapters.hgBrasil.dtos.AutenticacaoChaveHGBrasilInputModel;
import br.com.investfolio.infra.adapters.hgBrasil.dtos.FinancaInputModel;
import br.com.investfolio.core.httpClient.interfaces.IHttpClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHGBrasilClient extends IHttpClient {

    @GetMapping
    ResponseEntity<AutenticacaoChaveHGBrasilInputModel> autenticarChave();

    @GetMapping
    ResponseEntity<FinancaInputModel> obterIndices();

    @GetMapping("/stock_price")
    ResponseEntity<AtivoHGInputModel> obterAtivo(@RequestParam(name = "symbol") String codigo);


}
