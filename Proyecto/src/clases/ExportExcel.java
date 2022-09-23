package clases;

import java.io.FileWriter;
import java.io.IOException;

public class ExportExcel {
	
	public static void createCSV(ListaPersonaHandler handler) {
		try {
			FileWriter obj = new FileWriter("listaPersona.csv");
			obj.write("ID, Nombre, Apellido, Fecha de Nacimiento, Residencia, Hijos");
			for (Persona p : handler.dadoDeAlta) {
				if (p != null) 
				obj.write("\n"+p.getIdPersona() + "," + p.getNombre() + "," + p.getApellido() + "," + p.getFechaNacimiento() + ", " + p.getDptoResidencia() + ", " + p.getCantHijos());
			}
			obj.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
