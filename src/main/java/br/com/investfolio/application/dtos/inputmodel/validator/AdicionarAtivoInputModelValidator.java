package br.com.investfolio.application.dtos.inputmodel.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.investfolio.application.dtos.inputmodel.AdicionarAtivoInputModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeBetween;
import static java.util.function.Predicate.not;

@Component
public class AdicionarAtivoInputModelValidator extends AbstractValidator<AdicionarAtivoInputModel> {


    @Override
    public void rules() {

        ruleFor(AdicionarAtivoInputModel::getCodigo)
                .must(not(stringEmptyOrNull()))
                .withMessage("Não pode ser nulo ou vazio")
                .withFieldName("Codigo")
                .must(stringSizeBetween(2, 6))
                .withMessage("Deve ter entre 2 e 6 caracteres")
                .withFieldName("Codigo");

        ruleFor(AdicionarAtivoInputModel::getQuantidade)
                .must(q -> q > 0L)
                .withMessage("Não pode ser menor que 1")
                .withFieldName("Quantidade");

        ruleFor(AdicionarAtivoInputModel::getPrecoMedio)
                .must(pm -> pm.compareTo(BigDecimal.ZERO) > 0)
                .withMessage("Não pode ser menor ou igual a 0")
                .withFieldName("Quantidade");

    }



}
