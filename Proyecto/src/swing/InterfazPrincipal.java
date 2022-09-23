package swing;

import javax.swing.JPanel;
import clases.ExportExcel;
import clases.ListaPersonaHandler;
import clases.Persona;
import componentes.BFButton;
import componentes.BFInterfaz;
import componentes.BFLabel;
import componentes.BFList;
import componentes.BFTextField;
import validadores.Msg;

import java.awt.List;
import java.awt.Rectangle;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;

import java.awt.Font;

public class InterfazPrincipal extends BFInterfaz{
	private BFList listaDePersonasList;
	private BFList listaDeAltaList;
	public ListaPersonaHandler handler;
	private boolean Debug;
	
	
	public InterfazPrincipal(ListaPersonaHandler handler) {
		super("Gestion de personas");
		String textDarDeAlta = "Dar de alta";
		String textDarDeBaja = "Dar de baja";
				
		this.handler = handler;
		
		
		//	Lista de personas 
		this.listaDePersonasList = new BFList(handler.listaDePersonas, new Rectangle(10, 195, 231, 335), 0);
		getContentPane().add(this.listaDePersonasList);
		
		this.listaDePersonasList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (listaDePersonasList.getSelectedItem() == null) {}
				else if (e.getClickCount() >= 2 && e.getButton() == MouseEvent.BUTTON1) {
					String id = listaDePersonasList.getSelectedItem();
					int idByte = ((int)  Integer.parseInt(id.substring(4, id.indexOf(','))));
					if ((idByte = handler.buscarIDPersona(idByte)) <= -1) {}
					else {
						Persona p = handler.listaDePersonas.get(idByte);
						InterfazPersona pInterfaz =  new InterfazPersona(handler, InterfazPrincipal.this);
						pInterfaz.setVisible(true);
						pInterfaz.cargarPersona(p);
				}			
			}
			}
		});
		
		
		
		this.listaDeAltaList= new BFList(handler.dadoDeAlta, new Rectangle(298, 195, 222, 335), 1);
		getContentPane().add(this.listaDeAltaList);
		
		//	Dar de alta
		BFButton btnDarDeAlta = new BFButton(textDarDeAlta, new Rectangle(10, 536, 231, 42));
		btnDarDeAlta.addActionListener(listaDeAltaList);
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (listaDePersonasList.getSelectedItem() != null) {
					String id = listaDePersonasList.getSelectedItem();
					int idByte = ((int)  Integer.parseInt(id.substring(4, id.indexOf(','))));
					if ((idByte = handler.buscarIDPersona(idByte)) <= -1) {}
					else if (handler.darPersonaDeAlta(handler.listaDePersonas.get(idByte))) {
						listaDeAltaList.actualizarListaDeAlta();
						JOptionPane.showMessageDialog(null,"¡Persona dada de alta!");
					} else {
						Msg.MostrarError("¡Hubo un error!");
					}
				} else {
					Msg.MostrarError("¡No hay persona seleccionada!");
				}
			}
		});
		
		getContentPane().add(btnDarDeAlta);
		//	Dar de baja
		BFButton btnDarDeBaja = new BFButton(textDarDeBaja, new Rectangle(298, 536, 222, 42));
		btnDarDeBaja.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//	Primero vemos si lo que tenemos seleccionado es distinto de un campo vacio
				if (listaDeAltaList.getSelectedItem() != null) {
					String str = listaDeAltaList.getSelectedItem();	//	Luego scamos toString asociado
					int idByte = ((int)  Integer.parseInt(str.substring(4, str.indexOf(','))));	//	Luego buscamos cual es la id
					if (handler.sacarPersonaDeAlta(handler.dadoDeAlta.get(handler.buscarIDPersona(idByte)))) {
						listaDeAltaList.actualizarListaDeAlta();	//	Actualizamos la lista
						JOptionPane.showMessageDialog(null,"¡Persona dada de baja!");
					}
					else {
						Msg.MostrarError("¡Hubo un error!");
					}
					
				}
				else {
					Msg.MostrarError("¡No hay persona seleccionada!");
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
		
		BFTextField	barraDeBusquedaTextField = new BFTextField(new Rectangle(554, 489, 257, 36));
		getContentPane().add(barraDeBusquedaTextField);
		
		
		
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
					listaDePersonasList.removeAll();	//	Borro toda la lista
					for (Persona p : handler.listaDePersonas) {
						if (p != null) {	//	Si la persona no es nulla buscamos en la lista, esto es para evitar un error.	Nota: Esto se hizo antes de la clase de excepciones
							if (p.getNombre().equalsIgnoreCase(barraDeBusquedaTextField.getText().toLowerCase()) || p.getApellido().equalsIgnoreCase(barraDeBusquedaTextField.getText().toLowerCase())) {
								listaDePersonasList.add(p.toString());
							}
						}
					}
				} else {
					listaDePersonasList.actualizarLista();
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
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnMenu);
		
		JMenuItem mnitemEditarPersona = new JMenuItem("Editar Persona");
		mnitemEditarPersona.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InterfazPersona(handler, InterfazPrincipal.this).setVisible(true);;
			}
		});
		
		//cree menu excel
		mnMenu.add(mnitemEditarPersona);
		
		
		JMenuItem mnitemExportarCSV = new JMenuItem("Exportar .csv");
		mnitemExportarCSV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		mnitemExportarCSV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExportExcel.createCSV(handler);
			}
		});
		mnMenu.add(mnitemExportarCSV);

		
		JCheckBoxMenuItem mnItemDebug = new JCheckBoxMenuItem("Debug");
		mnMenu.add(mnItemDebug);
		mnItemDebug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setDebug(mnItemDebug.getState());
			}
		});
		
		
	}

	
	
	
	//	Getter and Setter

	public boolean isDebug() {
		return Debug;
	}
	public void setDebug(boolean debug) {
		Debug = debug;
	}
	
	public BFList getListaDePersonasList() {
		return listaDePersonasList;
	}
	public void setListaDePersonasList(BFList listaDePersonasList) {
		this.listaDePersonasList = listaDePersonasList;
	}
	public BFList getListaDeAltaList() {
		return listaDeAltaList;
	}
	public void setListaDeAltaList(BFList listaDeAltaList) {
		this.listaDeAltaList = listaDeAltaList;
	}
	
}
