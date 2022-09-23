package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BFLabelX extends JLabel {

	public BFLabelX() {
		super("X");
		setOpaque(true);
		setBorder(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setForeground(Color.WHITE);
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Tahoma", Font.PLAIN, 28));
		setBackground(new Color(72, 72, 72));
		setBounds(850-54, 0, 54, 50);
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.getWindowAncestor(getParent()).dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(new Color(240, 0, 0));
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(new Color(72, 72, 72));
			}
		});
		
		
	}
	
}
