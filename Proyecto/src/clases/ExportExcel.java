package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportExcel {
	
	public static void createCSV(ListaPersonaHandler handler) {
		try {
			FileWriter obj = new FileWriter("listaPersona.csv");
			obj.write("ID,Nombre,Apellido,Fecha de Nacimiento,Residencia,Hijos,Vehiculos");
			for (Persona p : handler.dadoDeAlta) {
				if (p != null) {
				String vehiculo = "[";
				for (Vehiculo v : handler.listaDeVehiculos) {
					if (v.getIdDueño() == p.getIdPersona()) vehiculo += v.toString() + ",";
				}
				vehiculo += "]";
				obj.write("\n"+p.getIdPersona() + "," + p.getNombre() + "," + p.getApellido() + "," + p.getFechaNacimiento() + "," + p.getDptoResidencia() + "," + p.getCantHijos() + "," + vehiculo); 
				}
				
			}
			obj.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
