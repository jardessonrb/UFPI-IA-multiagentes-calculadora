package com.ia.agente.service;

public class Extrator {
    private Character operador;

    public Extrator(Character operador){
        this.operador = operador;
    }

    public String[] extrair(String expressao){
        String operandos[] = new String[4];
        String primeiraParteExpressao[] = new String[2];
        String segundaParteExpressao[] = new String[2];
        
        for (int i = 0; i < expressao.length(); i++) {
            
            if((i != 0) & isMeuOperador(expressao.charAt(i)) || expressao.charAt(i) == 'R'){
                primeiraParteExpressao = getPrimeiraParteExpressao(expressao, i-1);
                segundaParteExpressao  = getSegundaParteExpressao(expressao, i+1);
                break;
            }
        }

        operandos[0] = primeiraParteExpressao[0];
        operandos[1] = primeiraParteExpressao[1];
        operandos[2] = segundaParteExpressao[0];
        operandos[3] = segundaParteExpressao[1];

        return operandos;
    }
    
    public String[] getSegundaParteExpressao(String expressao, int index){
        StringBuilder operando = new StringBuilder();
        StringBuilder restoExpressao = new StringBuilder();
        while(index < expressao.length()){
            if(!isOperacao(expressao.charAt(index))){
                operando.append(expressao.charAt(index));
            }else{
                break;
            }
            index++;
        }
        while(index < expressao.length()){
            restoExpressao.append(expressao.charAt(index));
            index++;
        }

        String segundaParte[] = {operando.toString(), restoExpressao.toString()};

        return segundaParte;
    }

    public String[] getPrimeiraParteExpressao(String expressao, int index){
        StringBuilder operando = new StringBuilder();
        StringBuilder inicioExpresso = new StringBuilder();
        while(index >= 0){
            if(!isOperacao(expressao.charAt(index))){
                operando.append(expressao.charAt(index));
            }else {
                if(expressao.charAt(index) == '-'){
                    operando.append(expressao.charAt(index));
                    index--;
                    break;
                }
                break;
            }
            index--;
        }
        
        int i = 0;
        while(i <= index){
            inicioExpresso.append(expressao.charAt(i));
            i++;
        }
        String primeiraParte[] = {inicioExpresso.toString(), operando.reverse().toString()};

        return primeiraParte;
    }

    public Character getOperador(){
        return this.operador;
    }

    public boolean isMeuOperador(Character operacao){
        return this.operador == operacao;
    }

    public static boolean isOperacao(Character operador){
        return (
            operador == '+' ||
            operador == '-' || 
            operador == '*' || 
            operador == '^' || 
            operador == 'R' || 
            operador == '/' || 
            operador == '(' || 
            operador == ')'
        );
    }

    public static boolean isOperacaoBasica(Character operador){
        return (
            operador == '+' ||
            operador == '-' || 
            operador == '*' || 
            operador == '^' || 
            operador == '/' 
        );
    }
}