package componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;

public class BFLabel  extends JLabel{
	public BFLabel(String text, Rectangle bounds) {
		super(text);
		setFont(new Font("Tahoma", Font.PLAIN, 18));
		setBounds(bounds);
		setForeground(Color.BLACK);
		
	}
}
