package br.com.investfolio.application.controllers;

import br.com.investfolio.application.dtos.inputmodel.CarteiraInputModel;
import br.com.investfolio.application.dtos.viewmodel.CarteiraViewModel;
import br.com.investfolio.application.useCase.CriarCarteiraUseCase;
import br.com.investfolio.core.patterns.result.OperationResult;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/carteiras")
public class CarteiraRestController {

    private final CriarCarteiraUseCase criarCarteira;

    @PostMapping
    public ResponseEntity<OperationResult<CarteiraViewModel>> criar(@RequestBody final CarteiraInputModel input) {

        final var operationResult = this.criarCarteira.execute(input);

        if (!operationResult.getSuccess())
            return ResponseEntity.status(operationResult.getStatus()).body(operationResult);

        return ResponseEntity.status(operationResult.getStatus()).body(operationResult);

    }

}
