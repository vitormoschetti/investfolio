package br.com.serviceportfolio.application.dtos.viewmodel;

import br.com.serviceportfolio.domain.enums.TipoAtivoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@AllArgsConstructor
public class ListarAtivosCarteiraViewModel {

    private String codigo;
    private TipoAtivoEnum tipoAtivo;
    private BigDecimal precoMedio;
    private Long quantidade;
    private BigDecimal totalInvestido;
    private Instant dataCompra;
}
