package br.com.investfolio.infra.adapters.hgBrasil;

import br.com.investfolio.infra.adapters.hgBrasil.dtos.AtivoHGInputModel;
import br.com.investfolio.core.httpClient.BaseFeign;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.stereotype.Component;

@Component
public class HGBrasilHttpClient extends BaseFeign<IHGBrasilClient> {

    public HGBrasilHttpClient(@Value("${http.hgbrasil}") final String host,
                              final ResponseEntityDecoder decoder,
                              final Encoder encoder,
                              final HgBrasilRequestInterceptor requestInterceptor) {
        super(host, IHGBrasilClient.class, decoder, encoder, requestInterceptor);
    }

    public void obterIndices() {
        final var response = this.client.obterIndices();
        System.out.println(response.getBody());
    }

    public AtivoHGInputModel obterAtivo(String codigo) {
        final var response = this.client.obterAtivo(codigo);
        return response.getBody();
    }


}
