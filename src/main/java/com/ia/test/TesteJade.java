package com.ia.test;

import jade.core.Agent;

public class TesteJade extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void setup() {
		System.out.println("Opa deu bom");
		System.out.println("Nome local "+getLocalName());
	}

}
