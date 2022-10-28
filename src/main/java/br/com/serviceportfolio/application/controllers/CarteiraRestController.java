package br.com.serviceportfolio.application.controllers;

import br.com.serviceportfolio.application.dtos.inputmodel.CarteiraInputModel;
import br.com.serviceportfolio.application.queries.CarteiraQuery;
import br.com.serviceportfolio.application.useCase.CriarCarteiraUseCase;
import br.com.serviceportfolio.core.patterns.result.OperationResult;
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
