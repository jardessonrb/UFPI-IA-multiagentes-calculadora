package com.ia.agente.domain.model;

import com.ia.agente.service.Extrator;

public class AgenteSubtracao  extends Extrator implements Agente {
    private Integer prioridade;

    public AgenteSubtracao(Character operacao, Integer prioridade){
        super(operacao);
        this.prioridade = prioridade;
    }

    public String calcular(String expressao) {
        String[] operandos = extrair(expressao);
        Double subtracao = Double.parseDouble(operandos[1]) - Double.parseDouble(operandos[2]);
    
        return operandos[0]+subtracao+operandos[3];
    }

    public Character getOperacao() {
       return getOperador();
    }

    public Integer getPrioridade() {
        return this.prioridade;
    }
}
