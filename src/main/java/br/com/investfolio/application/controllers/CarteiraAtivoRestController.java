package br.com.investfolio.application.controllers;

import br.com.investfolio.application.dtos.inputmodel.AdicionarAtivoInputModel;
import br.com.investfolio.application.useCase.AdicionarAtivoUseCase;
import br.com.investfolio.core.patterns.result.OperationResult;
import com.andrebreves.tuple.Tuple;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/carteiras")
public class CarteiraAtivoRestController {

    private final AdicionarAtivoUseCase useCase;

    @PostMapping("/{idCarteira}/ativos")
    public ResponseEntity<OperationResult> adicionarAtivo(@RequestBody final AdicionarAtivoInputModel input,
                                                          @PathVariable(name = "idCarteira") final Long idCarteira) {

        final var operationResult = this.useCase.execute(Tuple.of(idCarteira, input));

        return ResponseEntity.status(operationResult.getStatus()).build();

    }


}
