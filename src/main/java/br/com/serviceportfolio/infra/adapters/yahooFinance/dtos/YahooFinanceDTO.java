package br.com.serviceportfolio.infra.adapters.yahooFinance.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class YahooFinanceDTO {

    @JsonProperty("quoteResponse")
    private YahooFinanceResponseDTO quoteResponse;

    public BigDecimal getPrecoAtual(){
        return this.getQuoteResponse().getResultado().stream().findFirst().get().getPrecoAtual();
    }


}
