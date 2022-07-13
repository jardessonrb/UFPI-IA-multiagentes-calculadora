package com.ia.agente.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ia.agente.domain.model.Agente;
import com.ia.agente.exceptions.ErrorOperacaoInvalida;
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
        
        for (int i = 0; i < this.operacoes.size(); i++) {
            this.expressao = agentes.get(this.operacoes.get(i).getOperacao()).calcular(this.expressao);
        }
        
        return this.expressao;
    }

    public List<Operacao> listaOperacoes(){
        List<Operacao> operacoesSort = new ArrayList<Operacao>();
        for (int i = 0; i < this.expressao.length(); i++) {
            if(i == 0 & this.expressao.charAt(i) == '-'){
                continue;
            }

            if(Extrator.isOperacao(this.expressao.charAt(i))){
                Character operador = this.expressao.charAt(i);
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
                // throw new Error("Expressão começando por "+expressao.charAt(i)+" é inválida");
                throw new ErrorOperacaoInvalida("Expressão começando por "+expressao.charAt(i)+" é inválida");
            }

            if(Character.isLetter(expressao.charAt(i)) & !Extrator.isOperacao(expressao.charAt(i))){
                throw new Error("O caracter "+expressao.charAt(i)+" não é uma operação válida");
            }

            if(Extrator.isOperacao(expressao.charAt(i)) & expressao.charAt(i) == expressao.charAt(i+1)){
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
