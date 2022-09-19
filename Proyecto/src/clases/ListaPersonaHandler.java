package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaPersonaHandler {
	public ArrayList<Persona> listaDePersonas; // Controlar las personas creadas
	public List<Persona> dadoDeAlta; // Controlar las personas dadas de alta
	public List<Vehiculo> listaDeVehiculos;	//	Controlar los vehiculos creados
	
	public ListaPersonaHandler() {
		this.listaDePersonas = new ArrayList<Persona>();
		this.dadoDeAlta = new ArrayList<Persona>();
		this.listaDeVehiculos = new ArrayList<Vehiculo>();
	}
	
	public boolean crearPersona(int id, String nombre, String apellido, LocalDate fechaNacimiento, byte cantHijos, String dptResidencia) {
		for (Persona persona : this.listaDePersonas) {
			if (persona.getIdPersona() == id) {
				//	Si la persona ya existe, la actualizo
				listaDePersonas.set(persona.getIdPersona(), new Persona(id, nombre, apellido, fechaNacimiento, cantHijos, dptResidencia));
			}
		}
		
		if (dptResidencia == "") {
			listaDePersonas.add(id, new Persona(id, nombre, apellido, fechaNacimiento, cantHijos));
			} // Si no tenemos donde vive no agregamos su valor 
		else {
			listaDePersonas.add(id, new Persona(id, nombre, apellido, fechaNacimiento, cantHijos, dptResidencia));} // Si sabemos donde vive agregamos todos
		return true;
	}

	public boolean darPersonaDeAlta(Persona p) {
		if (dadoDeAlta.contains(p)) {
			return false;} // El usuario ya esta dado de alta
		dadoDeAlta.add(p);
		return true;
	}

	public boolean sacarPersonaDeAlta(Persona p) {
		if (!dadoDeAlta.contains(p)) {
			return false;} // Si no esta en la lista de alta, devulve falso
		dadoDeAlta.remove(p);
		return true;
	}
	
	public void mostrarListaDePersonas() {
		for (Persona p : listaDePersonas) 
			if (p != null) System.out.println(p);  //	Mostrar en pantalla las personas ingresadas
	}
	
	public boolean crearVehiculos(Vehiculo v) {
		if (!this.listaDeVehiculos.contains(v)) {
			this.listaDeVehiculos.add(v);
			return true;
		} return false;
	}
	
	public void actualizarVehiculos() {
		for (Persona p : this.listaDePersonas) {
			LinkedList<Vehiculo> bufferVehiculo = new LinkedList<>();
			for (Vehiculo v : this.listaDeVehiculos) {
				if (p.getIdPersona() == v.getIdDueño()) {
					bufferVehiculo.add(v);
				}
			}
			p.setVehiculo(bufferVehiculo);
		}
		
	}
	
}
