package swing;

import javax.swing.JPanel;
import clases.ExportExcel;
import clases.ListaPersonaHandler;
import clases.Persona;
import componentes.BFButton;
import componentes.BFInterfaz;
import componentes.BFLabel;

import java.awt.List;
import java.awt.Rectangle;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class InterfazPrincipal extends BFInterfaz {
	private JPanel contentPane;
	private List listaDePersonasList;
	private List listaDeAltaList;
	public ListaPersonaHandler handler;
	private JMenu mnExportarCsv;
	private JMenuItem mntmNewMenuItem;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField barraDeBusquedaTextField;
	private JLabel lblNewLabel_3;
	private JMenuItem mntmNewMenuItem_1;
	
	
	public InterfazPrincipal(ListaPersonaHandler handler) {
		super("Gestion de personas");
		String textDarDeAlta = "Dar de alta";
		String textDarDeBaja = "Dar de baja";
				
		this.handler = handler;
		this.listaDePersonasList = new List();
		listaDePersonasList.setFont(new Font("Dialog", Font.PLAIN, 20));
		this.listaDePersonasList.setBounds(10, 195, 231, 335);
		getContentPane().add(this.listaDePersonasList);
		
		this.listaDeAltaList= new List();
		listaDeAltaList.setFont(new Font("Dialog", Font.PLAIN, 20));
		listaDeAltaList.setBounds(298, 195, 222, 335);
		add(listaDeAltaList);
		
		//	Dar de alta
		BFButton btnDarDeAlta = new BFButton(textDarDeAlta, new Rectangle(10, 536, 231, 42));
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (listaDePersonasList.getSelectedItem() != null) {
					String id = listaDePersonasList.getSelectedItem();
					int idByte = ((int)  Integer.parseInt(id.substring(4, id.indexOf(','))));
					handler.darPersonaDeAlta(handler.listaDePersonas.get(idByte));
					actualizarListaDeAlta();
				}
			}
		});
		
		getContentPane().add(btnDarDeAlta);
		//	Dar de baja
		BFButton btnDarDeBaja = new BFButton(textDarDeBaja, new Rectangle(298, 536, 222, 42));
		btnDarDeBaja.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//	Primero vemos si lo que tenemos seleccionado es una Persona
				if (listaDeAltaList.getSelectedItem() != null) {
					String id = listaDeAltaList.getSelectedItem();	//	Luego scamos toString asociado
					int idByte = ((int)  Integer.parseInt(id.substring(4, id.indexOf(','))));	//	Luego buscamos cual es la id
					handler.sacarPersonaDeAlta(handler.listaDePersonas.get(idByte));	//	Finalmente la sacamos de la lista
					actualizarListaDeAlta();	// Recaramos la lista
				}
			}
		});
		getContentPane().add(btnDarDeBaja);
		
		JLabel lblIcon = new JLabel("");
		ImageIcon bigIcon = new ImageIcon(InterfazPrincipal.class.getResource("/resource/logo.png"));
		lblIcon.setIcon(new ImageIcon(InterfazPrincipal.class.getResource("/resource/icon300x300.png")));
		lblIcon.setBounds(526, 92, 300, 335);
		getContentPane().add(lblIcon);
		
		BFLabel lblListaPersonas = new BFLabel("Lista de personas", new Rectangle(10, 101, 231, 88));
		lblListaPersonas.setForeground(Color.WHITE);
		lblListaPersonas.setFont(new Font("Tahoma", Font.PLAIN, 29));
		getContentPane().add(lblListaPersonas);
		
		BFLabel lblListaDadasDeAlta= new BFLabel("Dadas de alta", new Rectangle(298, 101, 231, 88));
		lblListaDadasDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblListaDadasDeAlta.setForeground(Color.WHITE);
		getContentPane().add(lblListaDadasDeAlta);
		
		barraDeBusquedaTextField = new JTextField();
		barraDeBusquedaTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		barraDeBusquedaTextField.setBounds(554, 489, 257, 36);
		getContentPane().add(barraDeBusquedaTextField);
		barraDeBusquedaTextField.setColumns(10);
		
		
		
		//	Boton de Buscar
		BFButton searchButton = new BFButton("BUSCAR", new Rectangle(554, 536, 222, 42));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//	Si la barra de busqueda sin espacio no esta vacia buscar valores
				if (barraDeBusquedaTextField.getText().strip() != "") {
					listaDePersonasList.removeAll();
					for (Persona p : handler.listaDePersonas) {
						if (p != null) {
							if (p.getNombre().equalsIgnoreCase(barraDeBusquedaTextField.getText().toLowerCase()) || p.getApellido().equalsIgnoreCase(barraDeBusquedaTextField.getText().toLowerCase())) {
								listaDePersonasList.add(p.toString());
							}
						}
					}
				} else {
					actualizarLista();
				}
			}
		});
		getContentPane().add(searchButton);
		
		BFLabel lblBuscar= new BFLabel("Buscar", new Rectangle(554, 397, 173, 88));
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblBuscar.setForeground(Color.WHITE);
		getContentPane().add(lblBuscar);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.WHITE);
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 49, 870, 42);
		getContentPane().add(menuBar);
		
		mnExportarCsv = new JMenu("Menu");
		mnExportarCsv.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnExportarCsv);
		
		mntmNewMenuItem = new JMenuItem("Editar Persona");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfazPersona(handler, InterfazPrincipal.this).setVisible(true);;
			}
		});
		
		//cree menu excel
		mnExportarCsv.add(mntmNewMenuItem);
		
		
		mntmNewMenuItem_1 = new JMenuItem("Exportar .csv");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ExportExcel.createCSV(handler);
				System.out.println("hola");
			}
		});
		mnExportarCsv.add(mntmNewMenuItem_1);
		
	}
	
	public void actualizarLista() {
		this.listaDePersonasList.removeAll();
		for (Persona p : this.handler.listaDePersonas) {
			if (p != null) {
				this.listaDePersonasList.add(p.toString());
				System.out.println(p);
			}
		}
	}
	public void actualizarListaDeAlta() {
		this.listaDeAltaList.removeAll();
		for (Persona p : this.handler.dadoDeAlta) {
			if (p != null) {
				this.listaDeAltaList.add(p.toString());
			}
		}
	}
}
