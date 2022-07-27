package com.ia.agente;

import java.util.Scanner;

import com.ia.agente.controller.Gerente;
import com.ia.agente.domain.model.AgenteDivisao;
import com.ia.agente.domain.model.AgenteExponenciacao;
import com.ia.agente.domain.model.AgenteMultiplicacao;
import com.ia.agente.domain.model.AgenteRaizQuadrada;
import com.ia.agente.domain.model.AgenteSoma;
import com.ia.agente.domain.model.AgenteSubtracao;

public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        Gerente gerente = new Gerente(null, 
                                    new AgenteSoma('+', 1),
                                    new AgenteSubtracao('-', 1),
                                    new AgenteMultiplicacao('*', 2),
                                    new AgenteDivisao('/', 2),
                                    new AgenteExponenciacao('^', 3),
                                    new AgenteRaizQuadrada('R', 3)
                                );
        System.out.println("=================================================");
        System.out.println("Seja-vendo(a) a calculadora com agentes");
        System.out.println("R é para raiz quadrada - sintaxe R100 = 10");
        System.out.println("=================================================");
        while(true){
            System.out.println("Digite uma expressão válida: ");
            String expressao = input.nextLine();
            gerente.atualizarExpressao(expressao);
            String resultado = gerente.calcular();
            
            System.out.println("\nResultado da Expressão: "+expressao+" = "+resultado);
        }
    }
}
