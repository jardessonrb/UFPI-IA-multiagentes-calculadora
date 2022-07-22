package com.ia.agente.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.ia.agente.domain.model.Agente;
import com.ia.agente.service.Extrator;

class Operacao {
    public Character operacao;
    public Integer prioridade;

    public Operacao(Character operacao, Integer prioridadeOperacao){
        this.operacao = operacao;
        this.prioridade = prioridadeOperacao;
    }

    public Character getOperacao() {
        return this.operacao;
    }

    public Integer getPrioridade() {
        return this.prioridade;
    }
}

public class Gerente {
    private String expressao;
    private Map<Character, Agente> agentes = new HashMap<Character,Agente>();
    private List<Operacao> operacoes;
    private boolean contemParenteses = false;

    public Gerente(String expressao, Agente ...agentesArray){
        this.expressao = expressao;
        for (Agente agente : agentesArray) {
            agentes.put(agente.getOperacao(), agente);
        }
    }

    public String calcular(){
        this.expressao = limparExpressao(this.expressao);
        validarExpressao(this.expressao);
        this.operacoes = listaOperacoes();

        if(contemParenteses){
            String operacoes[] = Extrator.extrairParentesesDaExpressao(this.expressao);
            String expressaoResultado = calcularExpressaoEntreParenteses(operacoes[1]);
            this.expressao = operacoes[0]+expressaoResultado+operacoes[2];
            this.operacoes = listaOperacoes();
        }

        for (int i = 0; i < this.operacoes.size(); i++) {
            this.expressao = agentes.get(this.operacoes.get(i).getOperacao()).calcular(this.expressao);
        }
        
        return this.expressao;
    }

    public String calcularExpressaoEntreParenteses(String expressao){
        Stack<String> pilhaDeExpressoes = Extrator.extrairOperacoesEntreParenteses(expressao);
        StringBuilder resultado = new StringBuilder();
        String expressaoAnterior = "";
        while(!pilhaDeExpressoes.isEmpty()){
            String subExpressao = pilhaDeExpressoes.pop();
            subExpressao = subExpressao+expressaoAnterior;
            List<Operacao> operacoes = listaOperacoes(subExpressao);
            for (int i = 0; i < operacoes.size(); i++) {
                subExpressao = agentes.get(this.operacoes.get(i).getOperacao()).calcular(subExpressao);
            }
            expressaoAnterior = subExpressao;
        }
        
        System.out.println("resultado das expressoes entre parenteses: "+expressaoAnterior);
        return expressaoAnterior;
    }

    public List<Operacao> listaOperacoes(){
        List<Operacao> operacoesSort = new ArrayList<Operacao>();
        for (int i = 0; i < this.expressao.length(); i++) {
            if(i == 0 & this.expressao.charAt(i) == '-'){
                continue;
            }

            if(Extrator.isOperacao(this.expressao.charAt(i))){
                Character operador = this.expressao.charAt(i);
                if(operador == '(' || operador == ')') {
                    contemParenteses = true;
                    continue;
                }
                // if(this.agentes.containsKey(operador) & operador == '(') continue;
                Operacao operacao = new Operacao(operador, agentes.get(operador).getPrioridade());
                operacoesSort.add(operacao);
            }
        }

        Collections.sort(operacoesSort, new Comparator<Operacao>() {
            public int compare(Operacao operacao1, Operacao operacao2){
                return operacao2.getPrioridade().compareTo(operacao1.getPrioridade());
            }
        });
        
        return operacoesSort;
    }

    private List<Operacao> listaOperacoes(String expressao){
        List<Operacao> operacoesSort = new ArrayList<Operacao>();
        for (int i = 0; i < expressao.length(); i++) {
            if(i == 0 & expressao.charAt(i) == '-'){
                continue;
            }

            if(Extrator.isOperacao(expressao.charAt(i))){
                Character operador = expressao.charAt(i);
                Operacao operacao = new Operacao(operador, agentes.get(operador).getPrioridade());
                operacoesSort.add(operacao);
            }
        }

        Collections.sort(operacoesSort, new Comparator<Operacao>() {
            public int compare(Operacao operacao1, Operacao operacao2){
                return operacao2.getPrioridade().compareTo(operacao1.getPrioridade());
            }
        });
        
        return operacoesSort;
    }

    public String limparExpressao(String expressao){
        String expressaoLimpa = expressao.replaceAll("\\s+","");

        return expressaoLimpa;
    }
    
    public void validarExpressao(String expressao){
        for (int i = 0; i < (expressao.length() - 1); i++) {
            if(i == 0 & (expressao.charAt(i) == '+' || expressao.charAt(i) == '/')){
                throw new Error("Expressão começando por "+expressao.charAt(i)+" é inválida");
            }

            if(Character.isLetter(expressao.charAt(i)) & !Extrator.isOperacao(expressao.charAt(i))){
                throw new Error("O caracter "+expressao.charAt(i)+" não é uma operação válida");
            }

            if(Extrator.isOperacao(expressao.charAt(i)) & expressao.charAt(i) == expressao.charAt(i+1) & expressao.charAt(i) != ')' & expressao.charAt(i) != '('){
                throw new Error("Não pode haver dois operadores iguais seguidos "+expressao.charAt(i)+" = "+expressao.charAt(i+1));
            }

            if(Extrator.isOperacao(expressao.charAt(i)) & Extrator.isOperacaoBasica(expressao.charAt(i)) & Extrator.isOperacaoBasica(expressao.charAt(i+1))){
                throw new Error("Não pode haver dois operadores basicos seguidos "+expressao.charAt(i)+" e "+expressao.charAt(i+1));
            }

            if(expressao.charAt(i) == '(' & expressao.charAt(i+1) == ')'){
                throw new Error("Não pode haver parenteses vazios ");
            }
        }

        if(Character.isLetter(expressao.charAt(expressao.length() - 1)) & !Extrator.isOperacao(expressao.charAt(expressao.length() - 1))){
            throw new Error("O caracter "+expressao.charAt(expressao.length() - 1)+" não é uma operação válida");
        }
    }

}
