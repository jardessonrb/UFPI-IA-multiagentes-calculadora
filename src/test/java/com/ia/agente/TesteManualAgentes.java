package com.ia.agente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ia.agente.controller.Gerente;
import com.ia.agente.domain.model.AgenteDivisao;
import com.ia.agente.domain.model.AgenteExponenciacao;
import com.ia.agente.domain.model.AgenteMultiplicacao;
import com.ia.agente.domain.model.AgenteRaizQuadrada;
import com.ia.agente.domain.model.AgenteSoma;
import com.ia.agente.domain.model.AgenteSubtracao;

public class TesteManualAgentes {
    
    public static void main(String[] args) {
        // String expressao = "(-20+40/2+2*14/2^2+R100)-7";//10
        // String expressao = "(-20+40/2+2*14/2^2+R100)";//17
        // String expressao = "-20+40/2+2*14/2^2+R100";//17
        String expressao = "-20+(16/(-8/2))";//-24.0
        // String expressao = "-20+(16/-8/2)"; //-21
        // String expressao = "10+(-2-4)"; //4
        // String expressao = "23+12-55+(2+4)-8/2^2"; //-16

        Gerente gerente = new Gerente(expressao, 
                                    new AgenteSoma('+', 1),
                                    new AgenteSubtracao('-', 1),
                                    new AgenteMultiplicacao('*', 2),
                                    new AgenteExponenciacao('^', 3),
                                    new AgenteDivisao('/', 2),
                                    new AgenteRaizQuadrada('R', 3)
                                    );

        // System.out.println("Resultado da expressão "+expressao+" = "+gerente.calcular());
        // System.out.println(gerente.isOperavel('-', "20"));

        // assertEquals("20.0", gerente.calcular());
    }

    @Test
    @DisplayName("Deve passar")
    public void testeInicial(){
        Gerente gerente = new Gerente("-20+(16/(-8/2))", 
                            new AgenteSoma('+', 1),
                            new AgenteSubtracao('-', 1),
                            new AgenteMultiplicacao('*', 2),
                            new AgenteExponenciacao('^', 3),
                            new AgenteDivisao('/', 2),
                            new AgenteRaizQuadrada('R', 3)
                            );
        assertEquals("-24.0", gerente.calcular());
    }
}
