package main;

import clases.ListaPersonaHandler;
import swing.InterfazPrincipal;

public class Main {
	public static void main(String[] args) {
		ListaPersonaHandler handler = new ListaPersonaHandler();
		InterfazPrincipal principalFrame = new InterfazPrincipal(handler);
		principalFrame.setVisible(true);
		
	} 
	

}
