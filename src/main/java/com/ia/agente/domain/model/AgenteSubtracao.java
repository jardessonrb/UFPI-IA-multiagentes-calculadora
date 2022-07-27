package com.ia.agente.domain.model;

import com.ia.agente.service.Extrator;

public class AgenteSubtracao  extends Extrator implements Agente {
    private Integer prioridade;
    private String nome = "Agente Subtracao";

    public AgenteSubtracao(Character operacao, Integer prioridade){
        super(operacao);
        this.prioridade = prioridade;
    }

    public boolean isOperavel(char op, String expresao){
        String operandos[] = expresao.split(String.valueOf(op));
        if(operandos.length == 2){
            if(operandos[0].equals("") || operandos[1].equals("")){
                return false;
            }else {
                return true;
            }
        }else {
            return true;
        }
    }

    public String calcular(String expressao) {
        if(!isOperavel(getOperacao(), expressao)){
            return expressao;
        }

        String[] operandos = extrair(expressao);
        System.out.println(operandos[1] +" == "+operandos[2]);
        Double subtracao = Double.parseDouble(operandos[1]) - Double.parseDouble(operandos[2]);
        String resultado = operandos[0]+subtracao+operandos[3];
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
