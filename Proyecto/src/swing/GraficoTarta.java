package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ListaPersonaHandler;
import clases.Persona;
import clases.Vehiculo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GraficoTarta extends JPanel {

	private JPanel contentPane;
	
	private ListaPersonaHandler handler;
	

    public String[] deptos = {"Artigas","Canelones","Cerro Largo",
    		"Colonia","Durazno","Flores","Florida","Lavalleja","Maldonado",
    		"Montevideo","Paysandú","Río Negro","Rivera","Rocha","Salto","San José","Soriano","Tacuarembó","Treinta y Tres"};
    
    public List departamentos = Arrays.asList(deptos);;
    
    public int colores[] = {1,234,26,221,39,208,52,195,65,182,78,169,91,156,104,117,143,247,130};
    
	/**
	 * Crea el frame.
	 */
    public GraficoTarta(ListaPersonaHandler handler) {
    	this.handler = handler;
        setBounds(100, 200, 800, 600);
        setBackground(Color.white);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        repaint();
        
    }
    
    
    public void paint(Graphics g)
    {
        super.paint(g);
        	int altura = 50;
        	int bufferVehiculos = 0;
        	int gradosBuffer = 0;
        	System.out.println("Empezando");
        	int[] vehiculosPorDepartamento = new int[deptos.length];
        	for (Persona p : handler.listaDePersonas) {
        		bufferVehiculos += p.getVehiculo().size();
        		vehiculosPorDepartamento[departamentos.indexOf(p.getDptoResidencia())] += p.getVehiculo().size();
			}
        	if (bufferVehiculos != 0) {
        		
        		for (int i = 0; i < vehiculosPorDepartamento.length; i++) {
        			if (vehiculosPorDepartamento[i] <= 0) continue;	//	Ignorar si no hay vehiculo
        			int grados = vehiculosPorDepartamento[i] * 360/bufferVehiculos;
        			drawDpt(g, i, gradosBuffer, grados , altura+=30, vehiculosPorDepartamento[i]);
        			gradosBuffer += grados;
        			
        		}
        	}
            
    }
    
    public void drawDpt(Graphics g, int i, int grados, int gradoFinal, int altura, int cantidad) {
    	g.setColor(new Color(colores[i]));
    	System.out.println(new Color(colores[i]));
        g.fillArc(50,150,200,200,grados, gradoFinal);
        g.fillRect(370,altura,20,20);
        g.drawString(deptos[i]+ " " + cantidad , 400, altura); 
    }
    
        
}