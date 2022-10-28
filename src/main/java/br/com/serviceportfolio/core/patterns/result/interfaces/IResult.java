package br.com.serviceportfolio.core.patterns.result.interfaces;

public interface IResult {
    Boolean getSuccess();

    String getMensagem();

    <T> T getData();
}
