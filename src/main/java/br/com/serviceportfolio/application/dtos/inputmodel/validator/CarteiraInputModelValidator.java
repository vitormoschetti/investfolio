package br.com.serviceportfolio.application.dtos.inputmodel.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.serviceportfolio.application.dtos.inputmodel.CarteiraInputModel;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.StringPredicate.*;
import static java.util.function.Predicate.not;

@Component
public class CarteiraInputModelValidator extends AbstractValidator<CarteiraInputModel> {

    @Override
    public void rules() {

        ruleFor(CarteiraInputModel::getNome)
                .must(not(stringEmptyOrNull()))
                .withMessage("Não pode ser nulo ou vazio")
                .withFieldName("Nome")
                .must(stringSizeGreaterThanOrEqual(5))
                .withMessage("Deve ter mais que 4 caracteres")
                .withFieldName("Nome");

    }

}
