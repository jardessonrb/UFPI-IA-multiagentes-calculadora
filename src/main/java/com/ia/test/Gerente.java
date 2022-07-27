package com.ia.test;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class Gerente extends Agent {
	private static final long serialVersionUID = 1L;
	
	protected void setup() {
		System.out.println("Opa deu bom gerente");
		System.out.println("Nome local "+getLocalName());
		
		try {
			jade.core.Runtime rt = jade.core.Runtime.instance();
			Profile p = new ProfileImpl();
			ContainerController cc = rt.createMainContainer(p);
			AgentController ac = cc.createNewAgent("AgenteSoma","com.ia.agente.domain.model.AgenteSoma2", null);
			ac.start();
		} catch (Exception e) {
			System.out.println("Deu erro aqui ");
		}

	}
}
