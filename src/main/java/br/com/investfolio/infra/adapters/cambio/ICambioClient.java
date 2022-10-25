package br.com.investfolio.infra.adapters.cambio;

import br.com.investfolio.core.httpClient.interfaces.IHttpClient;
import br.com.investfolio.infra.adapters.cambio.dtos.DolarInputModel;
import org.springframework.web.bind.annotation.GetMapping;

public interface ICambioClient extends IHttpClient {

    @GetMapping("/last/USD-BRL")
    DolarInputModel obterPrecoDolar();

}
