package br.com.serviceportfolio.core.httpClient;

import br.com.serviceportfolio.core.httpClient.interfaces.IHttpClient;
import feign.Feign;
import feign.RequestInterceptor;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

public abstract class BaseFeign<E extends IHttpClient> {

    protected E client;

    @Autowired
    public BaseFeign(final String host, final Class<E> client, final ResponseEntityDecoder decoder, final Encoder encoder, final RequestInterceptor requestInterceptor) {

        this.client = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .requestInterceptor(requestInterceptor)
//                .errorDecoder(errorDecoder)
                .contract(new SpringMvcContract())
                .retryer(new feign.Retryer.Default())
                .target(client, host);
    }

    @Autowired
    public BaseFeign(final String host, final Class<E> client, final ResponseEntityDecoder decoder, final Encoder encoder) {

        this.client = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
//                .errorDecoder(errorDecoder)
                .contract(new SpringMvcContract())
                .retryer(new feign.Retryer.Default())
                .target(client, host);
    }



}
