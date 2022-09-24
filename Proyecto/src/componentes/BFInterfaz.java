package componentes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import swing.InterfazPersona;

public class BFInterfaz extends JFrame {
	private JPanel panel;
	
	public BFInterfaz(String title) {
		setTitle(title);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new JPanel();
		this.panel.setBackground(new Color(72, 72, 72));
		this.panel.setBorder(null);
		this.panel.setLayout(null);
		setBounds(100, 100, 850, 645);
		setContentPane(this.panel);
		//		App bar para mover la ventana
		Component appBar = new BFAppBar(getTitle());
		appBar.setLocation(0, 0);
		getContentPane().add(appBar);
		
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	
}
