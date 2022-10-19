package br.com.investfolio.domain.entities;

import br.com.investfolio.core.IEntity;
import br.com.investfolio.domain.enums.StatusCarteiraEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneOffset;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Carteira.TABLE_NAME)
public class Carteira implements IEntity {

    public static final String TABLE_NAME = "carteira";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_" + TABLE_NAME)
    @SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String nome;

    private BigDecimal totalInvestido;

    private BigDecimal totalAtual;

    private Character status;

    private Instant dataCriacao;

    public void criar(final String nome) {

        // validar input dentro da entidade carteira

        this.nome = nome;
        this.totalInvestido = BigDecimal.ZERO;
        this.totalAtual = BigDecimal.ZERO;
        this.status = StatusCarteiraEnum.ATIVA.getValue();
        this.dataCriacao = Instant.now().atOffset(ZoneOffset.UTC).toInstant();

    }
}
