package br.com.serviceportfolio.infra.adapters.cambio.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@NoArgsConstructor
public class DolarInputModel {

    @JsonProperty("USDBRL")
    private USDBRLInputModel usdbrl;

    public BigDecimal getPrecoAtual() {
        return this.usdbrl.getPrecoAtual();
    }

}
