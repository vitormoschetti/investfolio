package br.com.serviceportfolio.application.scheduler;

import br.com.serviceportfolio.infra.adapters.cambio.CambioHttpClient;
import br.com.serviceportfolio.infra.adapters.hgBrasil.HGBrasilHttpClient;
import br.com.serviceportfolio.infra.adapters.yahooFinance.YahooFinanceHttpClient;
import br.com.serviceportfolio.infra.repositories.interfaces.ICarteiraRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class AtualizarPrecoAtualAtivosScheduler {

    private final ICarteiraRepository repository;
    private final HGBrasilHttpClient hgBrasilHttpClient;
    private final YahooFinanceHttpClient yahooFinanceHttpClient;
    private final CambioHttpClient cambioHttpClient;

    public AtualizarPrecoAtualAtivosScheduler(final ICarteiraRepository repository,
                                              final HGBrasilHttpClient hgBrasilHttpClient,
                                              final YahooFinanceHttpClient yahooFinanceHttpClient,
                                              final CambioHttpClient cambioHttpClient) {
        this.repository = repository;
        this.cambioHttpClient = cambioHttpClient;
        this.hgBrasilHttpClient = hgBrasilHttpClient;
        this.yahooFinanceHttpClient = yahooFinanceHttpClient;
    }


    //TODO ajustar time de execução
    @Scheduled(fixedDelay = 900000, initialDelay = 10000)
    public void atualizarPrecoAtual() {

        log.info("Executando scheduler");

        final var dolarInputModel = this.cambioHttpClient.obterPrecoDolar();

        final var carteiras = this.repository.buscarTodasCarteirasAtivas();

        carteiras.forEach(carteira -> {

            carteira.getAtivos().parallelStream().forEach(ativo -> {

                switch (ativo.getTipoAtivo()) {

                    case ACAO:
                    case FUNDO_IMOBILIARIO:
                        final var ativoAtualizado = this.hgBrasilHttpClient.obterAtivo(ativo.getCodigo());
                        ativo.atualizarPrecoAtual(ativoAtualizado.getAcao().getPrecoAtual());
                        break;

                    case REIT:
                    case STOCK:
                        final var yahooFinanceDTO = this.yahooFinanceHttpClient.buscarAtivo(ativo.getCodigo());
                        ativo.atualizarPrecoAtual(yahooFinanceDTO.getPrecoAtual(), dolarInputModel.getPrecoAtual());
                        break;

                }

            });

            carteira.atualizarTotalAtual();

            this.repository.persistir(carteira);

        });

        log.info("Fim da execução");

    }

}
