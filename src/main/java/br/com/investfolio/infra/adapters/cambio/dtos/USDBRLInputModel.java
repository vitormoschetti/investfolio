package br.com.investfolio.infra.adapters.cambio.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@NoArgsConstructor
public class USDBRLInputModel {

    @JsonProperty("bid")
    private BigDecimal precoAtual;

}
