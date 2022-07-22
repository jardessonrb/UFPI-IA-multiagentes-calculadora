package com.ia.agente;

import java.util.Stack;

import com.ia.agente.controller.Gerente;
import com.ia.agente.domain.model.AgenteDivisao;
import com.ia.agente.domain.model.AgenteExponenciacao;
import com.ia.agente.domain.model.AgenteMultiplicacao;
import com.ia.agente.domain.model.AgenteRaizQuadrada;
import com.ia.agente.domain.model.AgenteSoma;
import com.ia.agente.domain.model.AgenteSubtracao;

public class TesteManualAgentes {
    
    public static void main(String[] args) {
        // String expressao = "12+20(10-5+(20+2))";
        String expressao = "-20+10+(10/2*(8/2))";
        Gerente gerente = new Gerente(expressao, 
                                    new AgenteSoma('+', 1),
                                    new AgenteSubtracao('-', 1),
                                    new AgenteMultiplicacao('*', 2),
                                    new AgenteExponenciacao('^', 3),
                                    new AgenteDivisao('/', 2),
                                    new AgenteRaizQuadrada('R', 3)
                                    );

        System.out.println("Resultado da expressão "+expressao+" = "+gerente.calcular());

        // // gerente.calcularExpressaoEntreParenteses("(12+(10-5)+10-20*10)");
        // String expre[] = Extrator.extrairParentesesDaExpressao("10-20*10-20+(12+20(10-5+(10-30)))");
        // Stack<String> ep = Extrator.extrairOperacoesEntreParenteses(expre[1]);
        // while(!ep.isEmpty()){
        //     System.out.println(ep.pop());
        // }
    }
}
