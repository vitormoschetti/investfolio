package br.com.serviceportfolio.infra.adapters.cambio;

import br.com.serviceportfolio.core.httpClient.interfaces.IHttpClient;
import br.com.serviceportfolio.infra.adapters.cambio.dtos.DolarInputModel;
import org.springframework.web.bind.annotation.GetMapping;

public interface ICambioClient extends IHttpClient {

    @GetMapping("/last/USD-BRL")
    DolarInputModel obterPrecoDolar();

}
