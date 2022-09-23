package componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BFAppBar extends JPanel {
	private int yPos;	//	Coordenada y
	private int xPos;	//	Cordenada x	
	
	public BFAppBar(String title) {		
		super();
		setLayout(null);
		JLabel text = new JLabel(title);
		text.setBounds(23, 5, 850, 34);
		text.setFont(new Font("Tahoma", Font.PLAIN, 28));
		text.setBackground(new Color(72, 72, 72));
		text.setForeground(Color.WHITE);
		add(text);
		
		
		setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				//	Movemos la ventana usando las coordenadas almacenadas
				SwingUtilities.getWindowAncestor(getParent()).setLocation(e.getXOnScreen()-xPos, e.getYOnScreen()-yPos);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//	Almacenamos las coordenadas donde dimos click
				xPos = e.getX();
				yPos = e.getY();
			}
		});
		//setBackground(new Color(255, 255, 255));
		setBackground(new Color(60, 60, 60));
		setBounds(0, 0, 850, 50);
		

		
		//	Boton para cerrar la overlay
		BFLabelX labelX = new BFLabelX();
		add(labelX);
		
		
		
	}
}
