package swing;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Avion;
import clases.Barco;
import clases.ListaPersonaHandler;
import clases.Vehiculo;
import componentes.BFAppBar;
import componentes.BFInterfaz;
import validadores.Msg;
import validadores.ValidarIngresos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class InterfazVehiculo extends BFInterfaz {
	private JPanel contentPane;
	private JTextField nombreTextField;
	private JTextField colorTextField;
	public ListaPersonaHandler handler;	//	LLamado para acceder a la memoria
	public int xPos = 0;	//	Coordenada para mover la ventana
	public int yPos = 0;	//	Coordenada para mover la ventana
	private JTextField esloraTextField;
	private JTextField mangaTextField;
	private JTextField longitudTextField;
	private JTextField cantPasajerosTextField;
	public final int idDueño;
	private InterfazPersona parent;
	
	public InterfazVehiculo(ListaPersonaHandler handler, int idDueño, InterfazPersona parent) {
		this.idDueño = idDueño;
		this.parent = parent;
		this.handler = handler;
		//	Para simplificar el ajuste más adelante, aquí vamos a definir todo lo que sea texto
		String textID = "ID";
		String textNombre = "Nombre";
		setBounds(100, 100, 822, 606);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//	Boton para ocultar la overlay
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(new Color(240, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(new Color(72, 72, 72));
			}
		});
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBackground(new Color(72, 72, 72));
		lblNewLabel_1.setBounds(776, 0, 54, 50);
		contentPane.add(lblNewLabel_1);

		JLabel tituloLabel = new JLabel("Edición de Vehículos");
		tituloLabel.setForeground(Color.BLACK);
		tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tituloLabel.setBounds(287, 61, 179, 28);
		contentPane.add(tituloLabel);
		
		JLabel idLabel = new JLabel("ID del Vehículo");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idLabel.setForeground(Color.BLACK);
		idLabel.setBounds(10, 106, 136, 28);
		contentPane.add(idLabel);
		
		JLabel nombreLabel = new JLabel("Nombre del Vehículo");
		nombreLabel.setForeground(Color.BLACK);
		nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombreLabel.setBounds(10, 158, 179, 38);
		contentPane.add(nombreLabel);
		
		JLabel colorLabel = new JLabel("Color");
		colorLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		colorLabel.setBounds(399, 158, 103, 38);
		contentPane.add(colorLabel);
		
		nombreTextField = new JTextField();
		nombreTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		nombreTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nombreTextField.setBounds(10, 207, 362, 20);
		contentPane.add(nombreTextField);
		nombreTextField.setColumns(10);
		nombreTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarLetras(e);
			}
		});
		
		colorTextField = new JTextField();
		colorTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		colorTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		colorTextField.setColumns(10);
		colorTextField.setBounds(399, 207, 280, 20);
		contentPane.add(colorTextField);
		colorTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarLetras(e);
			}
		});
		
		JSpinner idSpinner = new JSpinner();
		idSpinner.setBounds(156, 109, 54, 28);
		contentPane.add(idSpinner);
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfazVehiculo.class.getResource("/resource/iconReverso100x100.png")));
		lblNewLabel.setBounds(712, 61, 100, 100);
		contentPane.add(lblNewLabel);
		
		
		//	App bar para mover la ventana
		Component appBar = new BFAppBar("Editar Vehiculos");
		contentPane.add(appBar);

		JLabel tipoLabel = new JLabel("Tipo Vehículo");
		tipoLabel.setForeground(Color.BLACK);
		tipoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tipoLabel.setBounds(265, 258, 118, 28);
		contentPane.add(tipoLabel);
		
		JLabel esloraLabel = new JLabel("Eslora");
		esloraLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		esloraLabel.setBounds(10, 322, 103, 38);
		contentPane.add(esloraLabel);
				
		esloraTextField = new JTextField();
		esloraTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		esloraTextField.setColumns(10);
		esloraTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		esloraTextField.setBounds(10, 371, 362, 20);
		contentPane.add(esloraTextField);
		esloraTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarNumeros(e);
			}
		});
				
		JLabel mangaLabel = new JLabel("Manga");
		mangaLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mangaLabel.setBounds(10, 402, 103, 38);
		contentPane.add(mangaLabel);
		
		mangaTextField = new JTextField();
		mangaTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mangaTextField.setColumns(10);
		mangaTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		mangaTextField.setBounds(10, 451, 362, 20);
		contentPane.add(mangaTextField);
		mangaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarNumeros(e);
			}
		});
		
		JLabel longitudLabel = new JLabel("Longitud");
		longitudLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		longitudLabel.setBounds(421, 322, 103, 38);
		longitudLabel.setVisible(false);
		contentPane.add(longitudLabel);
		
		longitudTextField = new JTextField();
		longitudTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		longitudTextField.setColumns(10);
		longitudTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		longitudTextField.setBounds(421, 371, 362, 20);
		longitudTextField.setVisible(false);
		contentPane.add(longitudTextField);
		longitudTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarNumeros(e);
			}
		});
		
		
		JLabel cantPasajerosLabel = new JLabel("Cantidad Pasajeros");
		cantPasajerosLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cantPasajerosLabel.setBounds(421, 402, 163, 38);
		cantPasajerosLabel.setVisible(false);
		contentPane.add(cantPasajerosLabel);
		
		cantPasajerosTextField = new JTextField();
		cantPasajerosTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cantPasajerosTextField.setColumns(10);
		cantPasajerosTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cantPasajerosTextField.setBounds(421, 451, 362, 20);
		cantPasajerosTextField.setVisible(false);
		contentPane.add(cantPasajerosTextField);
		cantPasajerosTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarNumeros(e);
			}
		});

		//ComboBox para seleccionar tipo de vehículo - Hace visible u oculta los campos de cada tipo
		JComboBox tipoComboBox = new JComboBox();
		tipoComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tipoComboBox.setModel(new DefaultComboBoxModel(new String[] {"Barco", "Avión"}));
		tipoComboBox.setBounds(394, 257, 130, 22);
		tipoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(tipoComboBox.getSelectedItem()=="Barco") {
					esloraLabel.setVisible(true);
					esloraTextField.setVisible(true);
					mangaLabel.setVisible(true);
					mangaTextField.setVisible(true);
					longitudLabel.setVisible(false);
					longitudTextField.setVisible(false);
					cantPasajerosLabel.setVisible(false);
					cantPasajerosTextField.setVisible(false);
				} else if(tipoComboBox.getSelectedItem()=="Avión") {
					esloraLabel.setVisible(false);
					esloraTextField.setVisible(false);
					mangaLabel.setVisible(false);
					mangaTextField.setVisible(false);
					longitudLabel.setVisible(true);
					longitudTextField.setVisible(true);
					cantPasajerosLabel.setVisible(true);
					cantPasajerosTextField.setVisible(true);
				}
				
			}
		});
		contentPane.add(tipoComboBox);
		
		//	Boton para guardar la persona		
		JButton saveButton = new JButton("Guardar");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		saveButton.setForeground(Color.WHITE);
		saveButton.setBorderPainted(false);
		saveButton.setBackground(new Color(143, 188, 143));
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (nombreTextField.getText().strip() == "" ) {
					Msg.MostrarError("Campo vacio: Nombre");}
				else if (colorTextField.getText().strip() == "" ) {
					Msg.MostrarError("Campo vacio: Color");}
				else if (esloraTextField.getText().strip() == "" && tipoComboBox.getSelectedItem()=="Barco" ) {
					Msg.MostrarError("Campo vacio: Eslora");}
				else if (mangaTextField.getText().strip() == "" && tipoComboBox.getSelectedItem()=="Barco" ) {
					Msg.MostrarError("Campo vacio: Manga");}
				
				else if (longitudTextField.getText().strip() == "" && tipoComboBox.getSelectedItem() == "Avión" ) {
					Msg.MostrarError("Campo vacio: Longitud");}
				else if (cantPasajerosTextField.getText().strip() == "" && tipoComboBox.getSelectedItem() == "Avión" ) {
					Msg.MostrarError("Campo vacio: Cantidad de pasajeros");}
				
				else {
					if(tipoComboBox.getSelectedItem()=="Barco") {
						Barco barco = new Barco((int) idSpinner.getValue(), nombreTextField.getText(), colorTextField.getText(), (double) Integer.parseInt(esloraTextField.getText()) ,(double) Integer.parseInt(mangaTextField.getText()), idDueño);
						if (handler.crearVehiculos(barco)) {/* Mostrar mensaje de que se creo */ JOptionPane.showMessageDialog(null,"¡Datos guardados!");}
						else {
							Msg.MostrarError("Id ya usada");
						}
					} if (tipoComboBox.getSelectedItem() == "Avión") {
						Avion avion = new Avion((int) idSpinner.getValue(), nombreTextField.getText(), colorTextField.getText(), (double) Integer.parseInt(longitudTextField.getText()), Integer.parseInt(cantPasajerosTextField.getText()), idDueño);
						if (handler.crearVehiculos(avion)) {/* Mostrar mensaje de que se creo */ JOptionPane.showMessageDialog(null,"¡Datos guardados!");}
						else {
							Msg.MostrarError("Id ya usada");
						}
					}
					handler.actualizarVehiculos();
					parent.actualizarListaVehiculos();
					dispose();	// Cerrar ventana

				}
			}
		});
		saveButton.setBounds(278, 526, 137, 28);
		contentPane.add(saveButton);

		//	Boton para cargar la persona
		JButton loadButton = new JButton("Cargar");
		loadButton.setForeground(Color.WHITE);
		loadButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loadButton.setBackground(new Color(143, 188, 143));
		loadButton.setBorderPainted(false);
		loadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = (int) idSpinner.getValue();
				if (false) {Msg.MostrarError("No existe persona con esa ID");}	//	Si no existe la persona matar el programa
				else {
					nombreTextField.setText("");
					colorTextField.setText("");
					JOptionPane.showMessageDialog(null,"¡Datos cargados!");
				}
			}
		});
		loadButton.setBounds(278, 565, 137, 30);
		contentPane.add(loadButton);
		
	}
}
