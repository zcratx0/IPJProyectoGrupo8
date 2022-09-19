package validadores;

import javax.swing.JOptionPane;

public class Msg {
	
	public static void MostrarError(String msg) {
		JOptionPane.showMessageDialog(null, msg,"Error", JOptionPane.ERROR_MESSAGE);
	}
	
}
