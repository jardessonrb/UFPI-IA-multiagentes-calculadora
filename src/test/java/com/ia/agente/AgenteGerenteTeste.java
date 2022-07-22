package com.ia.agente;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ia.agente.controller.Gerente;
import com.ia.agente.domain.model.AgenteDivisao;
import com.ia.agente.domain.model.AgenteExponenciacao;
import com.ia.agente.domain.model.AgenteMultiplicacao;
import com.ia.agente.domain.model.AgenteRaizQuadrada;
import com.ia.agente.domain.model.AgenteSoma;
import com.ia.agente.domain.model.AgenteSubtracao;

public class AgenteGerenteTeste {
    
    @Test
    @DisplayName("Deve passar")
    public void testeInicial(){
        String expressao = "6-2/4+10*1+R25^2";
        Gerente gerente = new Gerente(expressao, 
                                    new AgenteSoma('+', 1),
                                    new AgenteSubtracao('-', 1),
                                    new AgenteMultiplicacao('*', 2),
                                    new AgenteExponenciacao('^', 3),
                                    new AgenteDivisao('/', 2),
                                    new AgenteRaizQuadrada('R', 3)
                                    );
       String resposta = gerente.calcular();
       assertEquals("40.5", resposta);
  
    }
}
