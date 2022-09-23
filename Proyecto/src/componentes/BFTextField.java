package componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import validadores.ValidarIngresos;

public class BFTextField extends JTextField{
	
	
	//	En caso de Texto
	public BFTextField(Rectangle bounds) {
		super();
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		setFont(new Font("Tahoma", Font.PLAIN, 16));
		setBounds(bounds);
		setColumns(10);	
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarLetras(e);
			}
		});
	}
	//	En caso de que sea para ingresar numeros
	public BFTextField(Rectangle bounds, int tipo) {
		super();
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		setFont(new Font("Tahoma", Font.PLAIN, 16));
		setBounds(bounds);
		setColumns(10);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarNumeros(e);
			}
		});
	}
	
	
	//	En caso de Fecha
	public BFTextField(Rectangle bounds, String tipo) {
		super();
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		setFont(new Font("Tahoma", Font.PLAIN, 16));
		setBounds(bounds);
		setColumns(10);
		setToolTipText("Formato debe ser aaaa-dd-mm");

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarFechas(e);
			}
		});
	}
	
}
