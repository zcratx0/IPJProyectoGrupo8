package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import clases.Persona;

public class BFButton extends JButton {
	public BFButton(String text, Rectangle bounds) {
		super(text);
		setFont(new Font("Tahoma", Font.PLAIN, 18));
		setForeground(Color.WHITE);
		setBorderPainted(false);
		setBackground(new Color(143, 188, 143));
		setBounds(bounds);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(163, 188, 163));	//	Cambiar el color al poner el mouse arriba
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(143, 188, 143));	//	Volver a su color normal
			}
		});
	}

}
