package br.com.serviceportfolio.infra.adapters.yahooFinance;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class YahooFInanceRequestInterceptor implements RequestInterceptor {

    private final String host;
    private final String key;

    public YahooFInanceRequestInterceptor(@Value("${http.yahoofinance.api-host}") final String host, @Value("${http.yahoofinance.api-key}") final String key) {
        this.host = host;
        this.key = key;
    }

    @Override
    public void apply(RequestTemplate request) {

        request.header("X-RapidAPI-Host", this.host);
        request.header("X-RapidAPI-Key", this.key);

    }
}
