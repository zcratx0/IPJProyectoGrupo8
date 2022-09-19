package clases;

import java.time.LocalDate;
import java.util.LinkedList;

public class Persona {
	private int idPersona;
	private String nombre;
	private String apellido;
	private String dptoResidencia;
	private byte cantHijos;
	private LocalDate fechaNacimiento;
	//la clase persona se relaciona con los vechiculos
	LinkedList<Vehiculo> vehiculo = new LinkedList<Vehiculo>();
	
	
	public Persona(int id, String nombre, String apellido, LocalDate fechaNacimiento) {
		//		En caso de que solo tengamos el nombre, apellido y fecha de nacimiento.
		this.setIdPersona(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setFechaNacimiento(fechaNacimiento);
	}
	public Persona(int id, String nombre, String apellido, LocalDate fechaNacimiento, byte cantHijo) {
		//		En caso de que ademas de lo anterior tambien tengamos cuantos hijos tiene.
		this.setIdPersona(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setFechaNacimiento(fechaNacimiento);
		this.setCantHijos(cantHijo);
	}
	public Persona(int id, String nombre, String apellido, LocalDate fechaNacimiento, byte cantHijos, String dpoResicencia) {
		//		En caso de que ademas de lo anterior tambien tengamos donde vive
		this.setIdPersona(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setFechaNacimiento(fechaNacimiento);
		this.setCantHijos(cantHijos);
		this.setDptoResidencia(dpoResicencia);
	}
	
	//constructor con vehiculo  
	public Persona(int idPersona, String nombre, String apellido, String dptoResidencia, byte cantHijos,
			LocalDate fechaNacimiento, LinkedList<Vehiculo> vehiculo) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dptoResidencia = dptoResidencia;
		this.cantHijos = cantHijos;
		this.fechaNacimiento = fechaNacimiento;
		this.vehiculo = vehiculo;
	}
	
	//get & set
	public int getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDptoResidencia() {
		return dptoResidencia;
	}
	public void setDptoResidencia(String dptoResidencia) {
		this.dptoResidencia = dptoResidencia;
	}
	public byte getCantHijos() {
		return cantHijos;
	}
	public void setCantHijos(byte cantHijos) {
		this.cantHijos = cantHijos;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	//get & set de la lista
	public LinkedList<Vehiculo> getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(LinkedList<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	//toString
	@Override
	public String toString() {
		return "id: " + this.getIdPersona() + "," + this.getNombre() + this.getApellido() + this.getVehiculo();
	}
	
	
	
}
