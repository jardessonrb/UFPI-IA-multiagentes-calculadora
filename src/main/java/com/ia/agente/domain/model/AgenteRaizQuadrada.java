package com.ia.agente.domain.model;

import com.ia.agente.service.Extrator;

public class AgenteRaizQuadrada extends Extrator implements Agente{
        private Integer prioridade;
        private String nome = "Agente Raiz Quadrada";
        public AgenteRaizQuadrada(Character operador, Integer prioridade) {
            super(operador);
            this.prioridade = prioridade;
        }
    
        public String calcular(String expressao) {
            String operandos[] = extrair(expressao);
            Double op2 = Double.parseDouble(operandos[2]);   
    
            Double raiz = Math.sqrt(op2);
            String resultado = operandos[0]+operandos[1]+raiz+operandos[3];
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
