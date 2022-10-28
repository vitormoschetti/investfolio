package br.com.serviceportfolio.infra.adapters.yahooFinance;

import br.com.serviceportfolio.core.httpClient.BaseFeign;
import br.com.serviceportfolio.infra.adapters.yahooFinance.dtos.YahooFinanceDTO;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.stereotype.Component;

@Component
public class YahooFinanceHttpClient extends BaseFeign<IYahooFinanceClient> {

    public YahooFinanceHttpClient(@Value("${http.yahoofinance}") final String host,
                                  final ResponseEntityDecoder decoder,
                                  final Encoder encoder,
                                  final YahooFInanceRequestInterceptor requestInterceptor) {
        super(host, IYahooFinanceClient.class, decoder, encoder, requestInterceptor);
    }

    public YahooFinanceDTO buscarAtivo(final String codigo) {
        final var response = this.client.buscarAtivo(codigo);
        return response.getBody();
    }

}
