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

public class InterfazPrincipal extends JFrame {

	private JPanel contentPane;
	private List listaDePersonasList;
	private List listaDeAltaList;
	public ListaPersonaHandler handler;
	private InterfazPersona personaFrame;
	private JMenu mnExportarCsv;
	private JMenuItem mntmNewMenuItem;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField barraDeBusquedaTextField;
	private JLabel lblNewLabel_3;
	private JMenuItem mntmNewMenuItem_1;
	public InterfazPrincipal(ListaPersonaHandler handler) {
		setTitle("Gestion de Personas");
		setBackground(Color.WHITE);
		this.handler = handler;
		this.personaFrame = new InterfazPersona(handler, this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 645);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnExportarCsv = new JMenu("Menu");
		menuBar.add(mnExportarCsv);
		
		mntmNewMenuItem = new JMenuItem("Editar Persona");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				personaFrame.setVisible(true);
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
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 72, 72));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.listaDePersonasList = new List();
		listaDePersonasList.setFont(new Font("Dialog", Font.PLAIN, 20));
		this.listaDePersonasList.setBounds(43, 100, 231, 335);
		contentPane.add(this.listaDePersonasList);
		
		this.listaDeAltaList= new List();
		listaDeAltaList.setFont(new Font("Dialog", Font.PLAIN, 20));
		listaDeAltaList.setBounds(298, 100, 222, 335);
		contentPane.add(listaDeAltaList);
		
		//	Dar de alta
		JButton btnNewButton = new JButton("Dar de alta");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(143, 188, 143));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (listaDePersonasList.getSelectedItem() != null) {
					String id = listaDePersonasList.getSelectedItem();
					int idByte = ((int)  Integer.parseInt(id.substring(4, id.indexOf(','))));
					handler.darPersonaDeAlta(handler.listaDePersonas.get(idByte));
					actualizarListaDeAlta();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(new Color(163, 188, 163));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(new Color(143, 188, 143));
			}
		});
		btnNewButton.setBounds(43, 441, 231, 42);
		contentPane.add(btnNewButton);
		//	Dar de baja
		JButton btnNewButton_1 = new JButton("Dar de baja");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(143, 188, 143));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//	Primero vemos si lo que tenemos seleccionado es una Persona
				if (listaDeAltaList.getSelectedItem() != null) {
					String id = listaDeAltaList.getSelectedItem();	//	Luego scamos toString asociado
					int idByte = ((int)  Integer.parseInt(id.substring(4, id.indexOf(','))));	//	Luego buscamos cual es la id
					handler.sacarPersonaDeAlta(handler.listaDePersonas.get(idByte));	//	Finalmente la sacamos de la lista
					actualizarListaDeAlta();	// Recaramos la lista
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(new Color(163, 188, 163));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(new Color(143, 188, 143));
			}
		});
		btnNewButton_1.setBounds(298, 441, 222, 42);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon bigIcon = new ImageIcon(InterfazPrincipal.class.getResource("/resource/logo.png"));
		lblNewLabel.setIcon(new ImageIcon(InterfazPrincipal.class.getResource("/resource/icon300x300.png")));
		lblNewLabel.setBounds(505, 0, 306, 346);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Lista de personas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(43, 11, 231, 88);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Dadas de alta");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(289, 11, 231, 88);
		contentPane.add(lblNewLabel_2);
		
		barraDeBusquedaTextField = new JTextField();
		barraDeBusquedaTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		barraDeBusquedaTextField.setBounds(554, 399, 257, 36);
		contentPane.add(barraDeBusquedaTextField);
		barraDeBusquedaTextField.setColumns(10);
		
		
		
		//	Buscar
		JButton searchButton = new JButton("BUSCAR");
		searchButton.setForeground(new Color(255, 255, 255));
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchButton.setBackground(new Color(143, 188, 143));
		searchButton.setBorderPainted(false);
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
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(new Color(163, 188, 163));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(new Color(143, 188, 143));
			}
			
		});
		searchButton.setBounds(554, 446, 222, 42);
		contentPane.add(searchButton);
		
		lblNewLabel_3 = new JLabel("Buscar");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(554, 314, 173, 88);
		contentPane.add(lblNewLabel_3);
		
		
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
