package br.com.serviceportfolio.infra.adapters.hgBrasil.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

@ToString
@NoArgsConstructor
public class ResultadoInputModel implements Serializable {

    private Map<String, DadosAcaoInputModel> acoes;

    @JsonAnySetter
    public void put(String key, DadosAcaoInputModel value) {
        this.acoes = Collections.singletonMap(key, value);
    }

    @JsonAnyGetter
    public Map<String, DadosAcaoInputModel> getAcoes() {
        return this.acoes;
    }

}
