package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ExportExcel;
import clases.ListaPersonaHandler;
import clases.Persona;
import clases.Vehiculo;
import componentes.BFButton;
import componentes.BFInterfaz;
import componentes.BFLabel;
import componentes.BFSpinner;
import componentes.BFTextField;

import validadores.Msg;
import validadores.ValidarIngresos;

import java.awt.List;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

public class InterfazDashboard extends BFInterfaz {

	public InterfazPrincipal parent;
	public InterfazVehiculo vehiculos;
	public ListaPersonaHandler handler;	//	Llamado para acceder a la memoria
	public List vehiculosList; // Lista de vehiculos
	public int idPersona;
	public GraficoTarta dashboard;
    private JPanel contentPane;
    private boolean bandera=false;
	
	public InterfazDashboard(ListaPersonaHandler handler, InterfazPrincipal parent) {
		super("Dashboard");
		this.handler = handler;
		this.parent = parent; 
	
		ArrayList<String> listaTemporal = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelJpanel = new JPanel();
		panelJpanel.setLayout(null);
		getContentPane().add(panelJpanel, BorderLayout.CENTER);
//		Definimos la ventana
		getContentPane().setBackground(Color.WHITE);

		//Labels aquí
		BFLabel cantidadDePersonasJLabel = new BFLabel("Cantidad de personas ingresadas : ", new Rectangle(10, 78, 290, 33));
		getContentPane().add(cantidadDePersonasJLabel);

		BFLabel numeroPersonasJLabel = new BFLabel("0", new Rectangle(338, 77, 105, 33));
		getContentPane().add(numeroPersonasJLabel);
		
		BFLabel promedioDeVehiculosJLabel = new BFLabel("Promedio de vehículos por persona : ", new Rectangle(10, 134, 318, 33));
		promedioDeVehiculosJLabel.setLocation(407, 78);
		getContentPane().add(promedioDeVehiculosJLabel);
		
		BFLabel numeroPromedioJLabel = new BFLabel("0", new Rectangle(338, 133, 105, 33));
		numeroPromedioJLabel.setLocation(735, 77);
		getContentPane().add(numeroPromedioJLabel);
		
		BFLabel vehiculosPorDeptoJLabel = new BFLabel("Gráfico vehículos por departamento", new Rectangle(227, 123, 339, 33));
		vehiculosPorDeptoJLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(vehiculosPorDeptoJLabel);
		
		dashboard = new GraficoTarta(handler);
		getContentPane().add(dashboard);
	
	}
	
	public void actualizarDashboard() {
		dashboard.repaint();
	}
	
}
