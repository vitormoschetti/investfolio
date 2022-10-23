package br.com.investfolio.application.dtos.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor
public class ListarCarteiraViewModel {

    private String nome;
    private Character status;
    private Instant dataCriacao;
    private BigDecimal totalAtual;
    private BigDecimal totalInvestido;

    List<ListarAtivosCarteiraViewModel> ativos;
}
