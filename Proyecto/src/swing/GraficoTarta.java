package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GraficoTarta extends JFrame {

	private JPanel contentPane;

    public String deptos[] = {"Artigas","Canelones","Cerro Largo",
    		"Colonia","Durazno","Flores","Florida","Lavalleja","Maldonado",
    		"Montevideo","Paysandú","Río Negro","Rivera","Rocha","Salto","San José","Soriano","Tacuarembó","Treinta y Tres"};
    
    public int colores[] = {1,234,26,221,39,208,52,195,65,182,78,169,91,156,104,117,143,247,130};
    
	/**
	 * Crea el frame.
	 */
    public GraficoTarta() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
       
        repaint();
        
    }
    
    
    public void paint(Graphics g)
    {
        super.paint(g);

            int v1=100;
            int v2=50;
            int v3=25;
            
            int suma=v1+v2+v3;
            
            int grados1=v1*360/suma;
            int grados2=v2*360/suma;
            int grados3=v3*360/suma;

            int altura = 250;
            
            g.setColor(new Color(colores[1]));
            g.fillArc(50,250,200,200,0,grados1);
            g.fillRect(370,altura,20,20);
            g.drawString(deptos[1], 400, altura);            

            g.setColor(new Color(colores[2]));
            g.fillArc(50,250,200,200,grados1,grados2);
            g.fillRect(370,altura+30,20,20);
            g.drawString(deptos[2], 400, altura+30);            

            g.setColor(new Color(colores[3]));
            g.fillArc(50,250,200,200,grados1+grados2,grados3);
            g.fillRect(370,altura+60,20,20);
            g.drawString(deptos[3], 400, altura+60);        
     
            
    }
        
}