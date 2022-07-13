package com.ia.agente.exceptions;

public class ErrorOperacaoInvalida extends RuntimeException{
    public ErrorOperacaoInvalida(String mensagem){
        super(mensagem);
    }
}
