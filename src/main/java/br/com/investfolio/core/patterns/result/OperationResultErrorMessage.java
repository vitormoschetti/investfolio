package br.com.investfolio.core.patterns.result;

import br.com.fluentvalidator.context.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class OperationResultErrorMessage implements Serializable {

    private final List<OperationResultErrorMessageObject> objects;

    public OperationResultErrorMessage(final Collection<Error> errors) {
        this.objects = new ArrayList<>();
        errors.forEach(error -> this.objects.add(new OperationResultErrorMessageObject(error.getField(), error.getMessage())));
    }


}

@Getter
@AllArgsConstructor
class OperationResultErrorMessageObject {

    private final String campo;
    private final String mensagem;

}
