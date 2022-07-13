package com.ia.agente.domain.model;

import com.ia.agente.service.Extrator;

public class AgenteRaizQuadrada extends Extrator implements Agente{
        private Integer prioridade;
    
        public AgenteRaizQuadrada(Character operador, Integer prioridade) {
            super(operador);
            this.prioridade = prioridade;
        }
    
        public String calcular(String expressao) {
            String operandos[] = extrair(expressao);
            Double op2 = Double.parseDouble(operandos[2]);   
    
            Double raiz = Math.sqrt(op2);
            return operandos[0]+operandos[1]+raiz+operandos[3];
        }
    
        public Character getOperacao() {
            return getOperador();
        }
    
        public Integer getPrioridade() {
            return this.prioridade;
        }
}
