package br.com.investfolio.application.scheduler;

import br.com.investfolio.infra.adapters.hgBrasil.HGBrasilHttpClient;
import br.com.investfolio.infra.repositories.interfaces.ICarteiraRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class AtualizarPrecoAtualAtivosScheduler {

    private final ICarteiraRepository repository;
    private final HGBrasilHttpClient httpClient;

    public AtualizarPrecoAtualAtivosScheduler(ICarteiraRepository repository, final HGBrasilHttpClient httpClient) {
        this.repository = repository;
        this.httpClient = httpClient;
    }


    //TODO ajustar time de execução
    @Scheduled(fixedDelay = 900000, initialDelay = 10000)
    public void atualizarPrecoAtual() {

        log.info("Executando scheduler");

        final var carteiras = this.repository.buscarTodasCarteirasAtivas();

        carteiras.forEach(carteira -> {

            carteira.getAtivos().parallelStream().forEach(ativo -> {

                final var ativoAtualizado = this.httpClient.obterAtivo(ativo.getCodigo());
                ativo.atualizarPrecoAtual(ativoAtualizado.getAcao().getPrecoAtual());

            });

            final var fim = System.currentTimeMillis();

            carteira.atualizarTotalAtual();

            this.repository.persistir(carteira);

        });

        log.info("Fim da execução");

    }

}
