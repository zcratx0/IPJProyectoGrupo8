package componentes;

import java.awt.Event;
import java.awt.Font;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import clases.Persona;
import clases.Vehiculo;
public class BFList extends List implements ActionListener{
	private ArrayList<Persona> handler;
	private int tipo = 0;
	
	public BFList(ArrayList handler, Rectangle bounds, int tipo) {
		this.handler = handler;
		this.tipo = tipo;	//	0 = Lista de personas; 1 = Lista de Dados de alta ; 2 = Lista de Vehiculos
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setBounds(bounds);
		}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.tipo == 0)	actualizarLista();
		else actualizarListaDeAlta();
	}
	
	public void actualizarLista() {
		this.removeAll();	//	Vaciamos la lista
		for (Persona p : this.handler) {
			if (p != null) {	//	Ingresamos los valores uno por uno
				this.add(p.toString());	//	Agrega a la persona
			}
		}
	}
	
	public void actualizarListaDeAlta() {
		this.removeAll();	//	Vaciamos la lista
		for (Persona p : this.handler) {
			if (p != null) {	//	Ingresamos los valores uno por uno
				this.add(p.toString());
			}
		}
	}
	
	//	Getters and Setter
	public ArrayList<Persona> getHandler() {
		return handler;
	}
	public void setHandler(ArrayList<Persona> handler) {
		this.handler = handler;
	}
	
	
}
