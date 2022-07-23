package com.ia.agente.domain.model;

import com.ia.agente.service.Extrator;

public class AgenteSoma extends Extrator implements Agente {
    private Integer prioridade;

    public AgenteSoma(Character operacao, Integer prioridade){
        super(operacao);
        this.prioridade = prioridade;
    }

    public String calcular(String expressao) {
        String[] operandos = extrair(expressao);
        String resultadoSoma = "";
        System.out.println("Agente soma: "+expressao+" = "+operandos[1] +" + "+operandos[2]+" resto = "+operandos[3]);
        Double soma = Double.parseDouble(operandos[1]) + Double.parseDouble(operandos[2]);

        if(soma > 0 & operandos[0].equals("")){
            resultadoSoma += soma;
            return resultadoSoma+operandos[3];
        }

        if(soma > 0 & !operandos[0].equals("")){
            resultadoSoma += "+"+soma;
            return operandos[0]+resultadoSoma+operandos[3];
        }

        if(soma == 0 & !operandos[0].equals("")){
            resultadoSoma += "-"+soma;
            return operandos[0]+resultadoSoma+operandos[3];
        }
    
        return operandos[0]+soma+operandos[3];
    }

    public Character getOperacao() {
        return getOperador();
    }

    public Integer getPrioridade() {
        return this.prioridade;
    }
}
