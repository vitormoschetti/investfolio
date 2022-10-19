package br.com.investfolio.infra.adapters.yahooFinance.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class YahooFinanceDTO {

    @JsonProperty("quoteResponse")
    private YahooFinanceResponseDTO quoteResponse;

}
