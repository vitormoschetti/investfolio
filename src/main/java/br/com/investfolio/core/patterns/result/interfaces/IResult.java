package br.com.investfolio.core.patterns.result.interfaces;

public interface IResult {
    Boolean getSuccess();

    String getMensagem();

    <T> T getData();
}
