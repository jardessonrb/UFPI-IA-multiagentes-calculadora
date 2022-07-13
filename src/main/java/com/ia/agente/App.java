package com.ia.agente;

import com.ia.agente.controller.Gerente;
import com.ia.agente.domain.model.AgenteSoma;
import com.ia.agente.domain.model.AgenteSubtracao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Gerente gerente = new Gerente("R25", 
            new AgenteSoma('+', 3),
            new AgenteSubtracao('-', 3)
        );

        System.out.println("Resultado: "+gerente.calcular()+"\nEsperado: 17");
        
    }
}
