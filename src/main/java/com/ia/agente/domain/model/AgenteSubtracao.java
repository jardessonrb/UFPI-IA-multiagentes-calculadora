package com.ia.agente.domain.model;

import com.ia.agente.service.Extrator;

public class AgenteSubtracao  extends Extrator implements Agente {
    private Integer prioridade;

    public AgenteSubtracao(Character operacao, Integer prioridade){
        super(operacao);
        this.prioridade = prioridade;
    }

    public boolean isOperavel(char op, String expresao){
        String operandos[] = expresao.split(String.valueOf(op));
        System.out.println("Tamanho do array no menos: "+operandos.length);
        // System.out.printf("%s %s %s ", operandos[0], operandos[1], operandos[2]);
        if(operandos.length == 2){
            if(operandos[0].equals("") || operandos[1].equals("")){
                System.out.println("Não pode calcular");
                return false;
            }else {
                System.out.println("Opa pode calcular");
                return true;
            }
        }else {
            return true;
        }

        // System.out.println("Expressao: "+expresao+" = "+operandos.length);

        // return operandos.length >= 2 ? true : false;
    }

    public String calcular(String expressao) {
        if(!isOperavel(getOperacao(), expressao)){
            return expressao;
        }

        String[] operandos = extrair(expressao);
        
        System.out.println("Agente subtracao: "+expressao+" = "+operandos[1] +" - "+operandos[2]+" resto = "+operandos[3]);
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
