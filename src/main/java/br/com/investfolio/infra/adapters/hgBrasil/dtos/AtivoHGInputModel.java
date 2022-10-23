package br.com.investfolio.infra.adapters.hgBrasil.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
public class AtivoHGInputModel implements Serializable {

    @JsonProperty("results")
    private ResultadoInputModel resultados;

    public DadosAcaoInputModel getAcao() {
        return this.resultados.getAcoes().values().stream().findFirst().orElse(null);
    }

}

