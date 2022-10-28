package br.com.serviceportfolio.infra.adapters.hgBrasil;

import br.com.serviceportfolio.core.httpClient.BaseFeign;
import br.com.serviceportfolio.infra.adapters.hgBrasil.dtos.AtivoHGInputModel;
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

    public AtivoHGInputModel obterAtivo(String codigo) {
        final var response = this.client.buscarAtivo(codigo);
        return response.getBody();
    }


}
