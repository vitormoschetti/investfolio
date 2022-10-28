package br.com.serviceportfolio.infra.adapters.hgBrasil.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@ToString
@NoArgsConstructor
public class DadosAcaoInputModel implements Serializable {

    @JsonProperty("symbol")
    private String codigo;

    @JsonProperty("price")
    private BigDecimal precoAtual;

}