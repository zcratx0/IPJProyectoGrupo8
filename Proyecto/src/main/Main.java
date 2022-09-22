package main;

import java.util.LinkedList;

import clases.Avion;
import clases.Barco;
import clases.ListaPersonaHandler;
import clases.Persona;
import clases.Vehiculo;
import swing.InterfazPersona;
import swing.InterfazPrincipal;

public class Main {
	public static void main(String[] args) {
		ListaPersonaHandler handler = new ListaPersonaHandler();
		
		System.out.println(handler.listaDePersonas);
		
		System.out.println("Prueba Mario");
		
		InterfazPrincipal principalFrame = new InterfazPrincipal(handler);
		principalFrame.setVisible(true);
		
	} 
	

}