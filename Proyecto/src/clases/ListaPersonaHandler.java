package clases;
/*	Sobre esta clase
 * En un princpio necesitabamos una forma de poder trabajar desde cualquier ventana con las personas
 * Por lo que surgio la necesidad de una clase la cual fuese instanciada al inicio y pueda ser llamada en cualquier momento
 * desde cualquier clase, con la creacion de los vehiculos simplemente se le agrego una nueva lista a la misma. 
 */



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaPersonaHandler {
	public ArrayList<Persona> listaDePersonas; // Controlar las personas creadas
	public ArrayList<Persona> dadoDeAlta; // Controlar las personas dadas de alta
	public ArrayList<Vehiculo> listaDeVehiculos;	//	Controlar los vehiculos creados
	
	public ListaPersonaHandler() {
		this.listaDePersonas = new ArrayList<Persona>();
		this.dadoDeAlta = new ArrayList<Persona>();
		this.listaDeVehiculos = new ArrayList<Vehiculo>();
	}
	
	public boolean crearPersona(int id, String nombre, String apellido, LocalDate fechaNacimiento, byte cantHijos, String dptResidencia) {
		int idOld;	//	Antiguo index de la persona
		//	Si la id ya esta siendo utilizada, actualizo su valor
		if ((idOld = buscarIDPersona(id)) != -1) {
			Persona persona = listaDePersonas.get(idOld);
			int indexDadoDeAlta = -1;	//	Como convención para este programa -1 viene a ser null
			if (this.dadoDeAlta.contains(persona)) {
				indexDadoDeAlta = this.dadoDeAlta.indexOf(persona);
			}
			persona.setNombre(nombre);
			persona.setApellido(apellido);
			persona.setFechaNacimiento(fechaNacimiento);
			persona.setCantHijos(cantHijos);
			persona.setDptoResidencia(dptResidencia);
			if (indexDadoDeAlta > -1) dadoDeAlta.set(indexDadoDeAlta, persona);	//	Cambio a la persona
			this.actualizarVehiculos();
			return true;	//	Mato el proceso
		}
		if (dptResidencia == "") {
			listaDePersonas.add(new Persona(id, nombre, apellido, fechaNacimiento, cantHijos));
			} // Si no tenemos donde vive no agregamos su valor 
		else {
			listaDePersonas.add(new Persona(id, nombre, apellido, fechaNacimiento, cantHijos, dptResidencia));} // Si sabemos donde vive agregamos todos
		return true;
	}
	
	
	public int buscadIDVehiculo(int id) {
		for (Vehiculo v : listaDeVehiculos) {
			if (v.getIdVehiculo() == id) {
				return listaDeVehiculos.indexOf(v);
			}
		} return -1;
	}
	
	public int buscarIDPersona(int id) {
		for (Persona persona : listaDePersonas) {
			if (persona.getIdPersona() == id) {
				return listaDePersonas.indexOf(persona);
			}
		} return -1;
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
		return true; // En caso de que estuviera, se lo remueve de la lista y devuelve true
	}
	
	
	public void mostrarListaDePersonas() {
		for (Persona p : listaDePersonas) 
			if (p != null) System.out.println(p);  //	Mostrar en pantalla las personas ingresadas
	}
	
	
	
	
	public boolean crearVehiculos(Vehiculo v) {
		//	Si la lista, no contiene al vehiculo en cuestion
		if (this.buscadIDVehiculo(v.getIdVehiculo()) <= -1) {
			this.listaDeVehiculos.add(v);
			return true;
		} else {
			//	Si existe, lo actualizo
			this.listaDeVehiculos.set(this.buscadIDVehiculo(v.getIdVehiculo()), v);
		}
		
		return false;
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
