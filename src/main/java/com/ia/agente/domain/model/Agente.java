package com.ia.agente.domain.model;

public interface Agente {
    public String calcular(String expressao);
    public String getNome();
    public Character getOperacao();
    public Integer getPrioridade();
}
