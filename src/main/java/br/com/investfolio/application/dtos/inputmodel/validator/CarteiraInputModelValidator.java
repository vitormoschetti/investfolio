package br.com.investfolio.application.dtos.inputmodel.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.investfolio.application.dtos.inputmodel.CarteiraInputModel;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeGreaterThan;
import static java.util.function.Predicate.not;

@Component
public class CarteiraInputModelValidator extends AbstractValidator<CarteiraInputModel> {

    @Override
    public void rules() {

        ruleFor(CarteiraInputModel::getNome)
                .must(not(stringEmptyOrNull()))
                .withMessage("Não pode ser nulo")
                .withFieldName("Nome")
                .must(stringSizeGreaterThan(5))
                .withMessage("Deve ter mais que 5 caracteres")
                .withFieldName("Nome");

    }

}
