package componentes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import swing.InterfazPersona;

public class BFInterfaz extends JFrame {
	private JPanel panel;
	
	public BFInterfaz() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new JPanel();
		this.panel.setBackground(new Color(72, 72, 72));
		this.panel.setBorder(null);
		this.panel.setLayout(null);
		setBounds(100, 100, 850, 645);
		setContentPane(this.panel);
		
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	
}
