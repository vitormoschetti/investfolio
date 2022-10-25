package br.com.investfolio.infra.adapters.yahooFinance;

import br.com.investfolio.core.httpClient.interfaces.IHttpClient;
import br.com.investfolio.infra.adapters.yahooFinance.dtos.YahooFinanceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IYahooFinanceClient extends IHttpClient {

    @GetMapping("/market/v2/get-quotes")
    ResponseEntity<YahooFinanceDTO> buscarAtivo(@RequestParam(name = "symbols") final String codigo);


}
