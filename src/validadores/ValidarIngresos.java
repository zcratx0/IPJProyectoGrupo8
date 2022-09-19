package validadores;

import java.awt.event.KeyEvent;
import java.time.LocalDate;

import validadores.Msg;

public class ValidarIngresos {
	
	public static void ValidarLetras(KeyEvent e) {
		if (!Character.isLetter(e.getKeyChar())  && e.getKeyChar() != KeyEvent.VK_SPACE && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
			e.consume();
			Msg.MostrarError("Ingrese solamente letras");
			return;
		}
	}
		
	public static void ValidarNumeros(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
			e.consume();
			Msg.MostrarError("Ingrese solamente números");
			return;
		}
	}
		
	public static void ValidarNumerosYLetras(KeyEvent e) {
		if (!Character.isLetterOrDigit(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_SPACE) {
			e.consume();
			Msg.MostrarError("Ingrese solamente letras y números");
			return;
		}
	}
		
	public static void ValidarFechas(KeyEvent e) {
		if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '-' && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
			e.consume();
			Msg.MostrarError("Ingrese solamente números y guiones");
			return;
		}
	}	
	
	public static boolean ValidarFecha(String campo, String s) {
		try {
			
			LocalDate d = LocalDate.parse(s);
			if (d.isAfter(LocalDate.now())) {
				throw new Exception("La fecha ingresda debe ser anterior a la de hoy");
			}
			return true;
		} catch (Exception e) {
			Msg.MostrarError("El campo " + campo + " no es una fecha valida: " + e.getMessage());
			return false;
		}
	}
}
