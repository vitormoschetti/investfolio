package br.com.investfolio.application.controllers;

import br.com.investfolio.application.dtos.inputmodel.CarteiraInputModel;
import br.com.investfolio.application.queries.CarteiraQuery;
import br.com.investfolio.application.useCase.CriarCarteiraUseCase;
import br.com.investfolio.core.patterns.result.OperationResult;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/carteiras")
public class CarteiraRestController {

    private final CriarCarteiraUseCase criarCarteira;
    private final CarteiraQuery carteiraQuery;

    @PostMapping
    public ResponseEntity<OperationResult> criar(@RequestBody final CarteiraInputModel input) {

        final var operationResult = this.criarCarteira.execute(input);

        return ResponseEntity.status(operationResult.getStatus()).body(operationResult);

    }

    @GetMapping("/{idCarteira}")
    public ResponseEntity<OperationResult> listar(@PathVariable(name = "idCarteira") final Long idCarteira) {

        final var operationResult = this.carteiraQuery.buscarPorId(idCarteira);

        return ResponseEntity.status(operationResult.getStatus()).body(operationResult);


    }

}
