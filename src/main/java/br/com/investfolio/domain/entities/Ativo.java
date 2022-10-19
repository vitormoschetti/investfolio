package br.com.investfolio.domain.entities;

import br.com.investfolio.core.IEntity;
import br.com.investfolio.domain.enums.TipoAtivoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneOffset;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Ativo.TABLE_NAME)
public class Ativo implements Serializable, IEntity {

    public static final String TABLE_NAME = "ativo";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_" + TABLE_NAME)
    @SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 4)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAtivoEnum tipoAtivo;

    @Column(nullable = false)
    private BigDecimal precoMedio;

    @Column(nullable = false)
    private Long quantidade;

    private BigDecimal totalInvestido;

    private Instant dataCompra;

    public Ativo(final String codigo, final Long quantidade, final TipoAtivoEnum tipoAtivo,
                 final BigDecimal precoMedio) {

        this.codigo = codigo;
        this.tipoAtivo = tipoAtivo;
        this.precoMedio = precoMedio;
        this.quantidade = quantidade;
        this.totalInvestido = precoMedio.multiply(new BigDecimal(quantidade));
        this.dataCompra = Instant.now().atOffset(ZoneOffset.UTC).toInstant();

    }
}