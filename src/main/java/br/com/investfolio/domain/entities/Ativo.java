package br.com.investfolio.domain.entities;

import br.com.investfolio.core.IEntity;
import br.com.investfolio.domain.enums.TipoAtivoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @Column(nullable = false, length = 6)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAtivoEnum tipoAtivo;

    @Column(nullable = false)
    private BigDecimal precoMedio;

    @Column(nullable = false)
    private Long quantidade;

    private BigDecimal totalInvestido;

    private BigDecimal precoAtual;

    private BigDecimal totalAtual;

    private Instant dataCompra;

    private BigDecimal variacao;

    public Ativo(final String codigo, final Long quantidade, final TipoAtivoEnum tipoAtivo,
                 final BigDecimal precoMedio) {

        this.codigo = codigo.toUpperCase();
        this.tipoAtivo = tipoAtivo;
        this.precoMedio = precoMedio;
        this.quantidade = quantidade;
        this.totalInvestido = precoMedio.multiply(new BigDecimal(quantidade));
        this.dataCompra = Instant.now().atOffset(ZoneOffset.UTC).toInstant();

    }

    public void atualizarPrecoAtual(final BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
        this.totalAtual = precoAtual.multiply(new BigDecimal(this.quantidade));
        this.calcularVariacao();
    }

    public void atualizarPrecoAtual(final BigDecimal precoAtual, final BigDecimal dolar) {
        this.precoAtual = precoAtual.multiply(dolar);
        this.totalAtual = precoAtual.multiply(new BigDecimal(this.quantidade)).multiply(dolar);
        this.calcularVariacao();
    }

    private void calcularVariacao() {

        this.variacao = this.totalAtual.divide(this.totalInvestido, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).subtract(new BigDecimal(100));

    }


}