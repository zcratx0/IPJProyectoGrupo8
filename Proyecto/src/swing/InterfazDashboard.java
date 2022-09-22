package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ExportExcel;
import clases.ListaPersonaHandler;
import clases.Persona;

import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class InterfazDashboard extends JFrame {
	public InterfazDashboard() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelJpanel = new JPanel();
		panelJpanel.setLayout(null);
		getContentPane().add(panelJpanel, BorderLayout.CENTER);
		
		JLabel tituloJLabel = new JLabel("Dashboard");
		tituloJLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		tituloJLabel.setBounds(223, 11, 105, 33);
		panelJpanel.add(tituloJLabel);
		
		JLabel cantidadDePersonasJLabel = new JLabel("Cantidad de personas ingresadas : ");
		cantidadDePersonasJLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		cantidadDePersonasJLabel.setBounds(10, 78, 290, 33);
		panelJpanel.add(cantidadDePersonasJLabel);
		
		JLabel numeroPersonasJLabel = new JLabel("0");
		numeroPersonasJLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numeroPersonasJLabel.setBounds(338, 77, 105, 33);
		panelJpanel.add(numeroPersonasJLabel);
		
		JLabel promedioDeVehiculosJLabel = new JLabel("Promedio de vehículos por persona : ");
		promedioDeVehiculosJLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		promedioDeVehiculosJLabel.setBounds(10, 134, 318, 33);
		panelJpanel.add(promedioDeVehiculosJLabel);
		
		JLabel numeroPromedioJLabel = new JLabel("0");
		numeroPromedioJLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numeroPromedioJLabel.setBounds(338, 133, 105, 33);
		panelJpanel.add(numeroPromedioJLabel);
		
		JButton botonGraficarBtn = new JButton("Graficar vehículos por depto.");
		botonGraficarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
		});
		botonGraficarBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		botonGraficarBtn.setBounds(150, 228, 262, 40);
		panelJpanel.add(botonGraficarBtn);
		
	}
}
