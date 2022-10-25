package br.com.investfolio.infra.adapters.cambio;

import br.com.investfolio.core.httpClient.BaseFeign;
import br.com.investfolio.infra.adapters.cambio.dtos.DolarInputModel;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.stereotype.Component;

@Component
public class CambioHttpClient extends BaseFeign<ICambioClient> {

    public CambioHttpClient(@Value("${http.cambio}") final String host,
                            final ResponseEntityDecoder decoder,
                            final Encoder encoder) {
        super(host, ICambioClient.class, decoder, encoder);
    }

    public DolarInputModel obterPrecoDolar() {
        return this.client.obterPrecoDolar();
    }

}
