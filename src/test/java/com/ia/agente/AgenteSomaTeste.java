package com.ia.agente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ia.agente.domain.model.Agente;
import com.ia.agente.domain.model.AgenteSoma;

public class AgenteSomaTeste {
    
    @Test
    @DisplayName("Deve passar")
    public void testeInicial(){
        Agente agenteSoma = new AgenteSoma('+', 10);

         String resposta = agenteSoma.calcular("10+20");
        assertEquals("30.0", resposta);
    }
    
}
