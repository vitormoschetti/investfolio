package br.com.serviceportfolio.core.patterns.result;

import br.com.serviceportfolio.core.patterns.result.interfaces.IResult;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OperationResult<T extends Object> implements IResult {

    private final Boolean success;
    private final String mensagem;
    private final HttpStatus status;

    private T data;

    private OperationResult(final Boolean success, final String mensagem, HttpStatus status) {
        this.success = success;
        this.mensagem = mensagem;
        this.status = status;
    }

    private OperationResult(final Boolean success, final String mensagem, HttpStatus status, final T data) {
        this(success, mensagem, status);
        this.data = data;
    }

    public static <T> OperationResult sucess(final T object, HttpStatus status) {
        return new OperationResult(Boolean.TRUE, "", status, object);
    }

    public static <T> OperationResult sucess(HttpStatus status) {
        return new OperationResult(Boolean.TRUE, "", status);
    }

    public static OperationResult fail(final String mensagem, HttpStatus status) {
        return new OperationResult(Boolean.FALSE, mensagem, status);
    }

    public static <T> OperationResult fail(final String mensagem, HttpStatus status, T data) {
        return new OperationResult(Boolean.FALSE, mensagem, status, data);
    }

    public static OperationResult fail(HttpStatus status) {
        return new OperationResult(Boolean.FALSE, "", status);
    }

}
