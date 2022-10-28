package br.com.serviceportfolio.application.dtos.inputmodel;

import br.com.serviceportfolio.domain.enums.TipoAtivoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class AdicionarAtivoInputModel {

    private String codigo;
    private Long quantidade;
    private BigDecimal precoMedio;
    private TipoAtivoEnum tipoAtivo;

}
