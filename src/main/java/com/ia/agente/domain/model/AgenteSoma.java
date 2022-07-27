package com.ia.agente.domain.model;

import com.ia.agente.service.Extrator;

public class AgenteSoma extends Extrator implements Agente {
    private Integer prioridade;
    private String nome = "Agente Soma";

    public AgenteSoma(Character operacao, Integer prioridade){
        super(operacao);
        this.prioridade = prioridade;
    }

    public String calcular(String expressao) {
        String[] operandos = extrair(expressao);
        String resultadoSoma = "";
        Double soma = Double.parseDouble(operandos[1]) + Double.parseDouble(operandos[2]);

        if(soma > 0 & operandos[0].equals("")){
            resultadoSoma += soma;
            String resultado = resultadoSoma+operandos[3];
            System.out.printf("\n%s recebe %s envia para Gerente o resultado %s", nome, expressao, resultado);
            return resultado;
        }

        if(soma > 0 & !operandos[0].equals("")){
            resultadoSoma += "+"+soma;
            String resultado = operandos[0]+resultadoSoma+operandos[3];
            System.out.printf("\n%s recebe %s envia para Gerente o resultado %s", nome, expressao, resultado);
            return resultado;
        }

        if(soma == 0 & !operandos[0].equals("")){
            resultadoSoma += "-"+soma;
            String resultado = operandos[0]+resultadoSoma+operandos[3];
            System.out.printf("\n%s recebe %s envia para Gerente o resultado %s", nome, expressao, resultado);
            return resultado;
        }

        String resultado = operandos[0]+soma+operandos[3];
        System.out.printf("\n%s recebe %s envia para Gerente o resultado %s", nome, expressao, resultado);
        return resultado;
    }

    public Character getOperacao() {
        return getOperador();
    }

    public Integer getPrioridade() {
        return this.prioridade;
    }

    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return this.nome;
    }
}
