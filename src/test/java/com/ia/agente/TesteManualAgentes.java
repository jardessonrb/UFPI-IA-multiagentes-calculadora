package com.ia.agente;

import com.ia.agente.controller.Gerente;
import com.ia.agente.domain.model.AgenteDivisao;
import com.ia.agente.domain.model.AgenteExponenciacao;
import com.ia.agente.domain.model.AgenteMultiplicacao;
import com.ia.agente.domain.model.AgenteRaizQuadrada;
import com.ia.agente.domain.model.AgenteSoma;
import com.ia.agente.domain.model.AgenteSubtracao;

public class TesteManualAgentes {
    
    public static void main(String[] args) {
        // String expressao = "6-2/4+10*1R25^2";
        String expressao = "6-2/4+10*1+R25^2";
        // String expressao = "R100";
        Gerente gerente = new Gerente(expressao, 
                                    new AgenteSoma('+', 1),
                                    new AgenteSubtracao('-', 1),
                                    new AgenteMultiplicacao('*', 2),
                                    new AgenteExponenciacao('^', 3),
                                    new AgenteDivisao('/', 2),
                                    new AgenteRaizQuadrada('R', 3)
                                    );

        System.out.println("Resultado da expressão "+expressao+" = "+gerente.calcular());
    }
}
