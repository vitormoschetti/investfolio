package br.com.serviceportfolio.domain.entities;

import br.com.serviceportfolio.core.IEntity;
import br.com.serviceportfolio.domain.enums.StatusCarteiraEnum;
import br.com.serviceportfolio.domain.enums.TipoAtivoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

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

    @JoinColumn(name = "carteira_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Ativo> ativos = new HashSet<>();

    private BigDecimal variacao;

    public void criar(final String nome) {

        this.nome = nome.trim();
        this.totalInvestido = BigDecimal.ZERO;
        this.totalAtual = BigDecimal.ZERO;
        this.status = StatusCarteiraEnum.ATIVA.getValue();
        this.dataCriacao = Instant.now().atOffset(ZoneOffset.UTC).toInstant();

    }

    public Boolean temAtivo(final String codigo) {
        return this.ativos.stream().anyMatch(ativo -> ativo.getCodigo().equalsIgnoreCase(codigo));
    }

    public void adicionarNovoAtivo(final String codigo, final Long quantidade, final BigDecimal precoMedio,
                                   final TipoAtivoEnum tipoAtivo) {

        final var ativo = new Ativo(codigo, quantidade, tipoAtivo, precoMedio);

        final var totalInvestido = ativo.getTotalInvestido();

        somarTotalInvestido(totalInvestido);

        this.ativos.add(ativo);

    }

    private void somarTotalInvestido(BigDecimal totalInvestido) {
        this.totalInvestido = this.totalInvestido.add(totalInvestido);
    }

    public void atualizarTotalAtual() {
        this.totalAtual = this.ativos.stream().map(Ativo::getTotalAtual).reduce(BigDecimal::add).get();
        this.calcularVariacao();
    }

    private void calcularVariacao() {
        this.variacao = this.totalAtual.divide(this.totalInvestido, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).subtract(new BigDecimal(100));
    }
}
