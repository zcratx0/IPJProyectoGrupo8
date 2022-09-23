package swing;

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
	
	public InterfazDashboard(ListaPersonaHandler handler, InterfazPrincipal parent) {
		super("Dashboard");
		this.handler = handler;
		this.parent = parent; 
	
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
		getContentPane().add(promedioDeVehiculosJLabel);
		
		BFLabel numeroPromedioJLabel = new BFLabel("0", new Rectangle(338, 133, 105, 33));
		getContentPane().add(numeroPromedioJLabel);
		
		
	}
}
