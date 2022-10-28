package br.com.serviceportfolio.application.dtos.viewmodel;

import br.com.serviceportfolio.domain.enums.StatusCarteiraEnum;
import lombok.Getter;

import java.time.Instant;

@Getter
public class CarteiraViewModel {

    private final Long id;
    private final String nome;
    private final Instant dataCriacao;
    private final StatusCarteiraEnum status;

    public CarteiraViewModel(Long id, String nome, Instant dataCriacao, Character status) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.status = StatusCarteiraEnum.find(status);
    }
}
