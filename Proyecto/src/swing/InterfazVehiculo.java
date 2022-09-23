package swing;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import clases.Avion;
import clases.Barco;
import clases.ListaPersonaHandler;
import componentes.BFButton;
import componentes.BFInterfaz;
import componentes.BFLabel;
import componentes.BFTextField;
import validadores.Msg;
import validadores.ValidarIngresos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class InterfazVehiculo extends BFInterfaz {
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
		super("Editor de Vehiculos");
		this.idDueño = idDueño;
		this.parent = parent;
		this.handler = handler;
		getContentPane().setBackground(Color.WHITE);
		//	Para simplificar el ajuste más adelante, aquí vamos a definir todo lo que sea texto
		String textIDVehiculo = "ID del Vehículo";
		String textNombreVehiculo = "Nombre del Vehículo";
		String textColor = "Color";
		String textTipo = "Tipo Vehículo";
		String textEslora= "Eslora";
		String textManga = "Manga";
		String textLongitud = "Longitud";
		String textCantPasajeros = "Cantidad Pasajeros";
		//	Labels
		BFLabel idLabel = new BFLabel(textIDVehiculo, new Rectangle(10, 106, 136, 28));
		getContentPane().add(idLabel);
		BFLabel nombreLabel = new BFLabel(textNombreVehiculo, new Rectangle(10, 158, 179, 38));
		getContentPane().add(nombreLabel);
		BFLabel colorLabel = new BFLabel(textColor, new Rectangle(399, 158, 103, 38));
		getContentPane().add(colorLabel);
		BFLabel tipoLabel = new BFLabel(textTipo, new Rectangle(265, 258, 118, 28));
		getContentPane().add(tipoLabel);
		
		//	Label de barco
		BFLabel esloraLabel = new BFLabel(textEslora, new Rectangle(10, 322, 103, 38));
		getContentPane().add(esloraLabel);
		BFLabel mangaLabel = new BFLabel(textManga, new Rectangle(10, 402, 103, 38));
		getContentPane().add(mangaLabel);
		
		//	Label de Avion
		//	Estan ocultos al principio
		BFLabel longitudLabel = new BFLabel(textLongitud, new Rectangle(421, 322, 103, 38));
		longitudLabel.setVisible(false);
		getContentPane().add(longitudLabel);
		
		BFLabel cantPasajerosLabel = new BFLabel(textCantPasajeros, new Rectangle(421, 402, 163, 38));
		cantPasajerosLabel.setVisible(false);
		getContentPane().add(cantPasajerosLabel);
		
		
		
		//	Label Icon
		BFLabel lblIcono = new BFLabel("", new Rectangle(712, 61, 100, 100));
		lblIcono.setIcon(new ImageIcon(InterfazVehiculo.class.getResource("/resource/iconReverso100x100.png")));
		getContentPane().add(lblIcono);
		
		
		
		BFTextField nombreTextField = new BFTextField(new Rectangle(10, 207, 362, 20));
		getContentPane().add(nombreTextField);
		
		BFTextField colorTextField = new BFTextField(new Rectangle(399, 207, 280, 20));
		getContentPane().add(colorTextField);
		
		JSpinner idSpinner = new JSpinner();
		idSpinner.setBounds(156, 109, 54, 28);
		getContentPane().add(idSpinner);

		
		BFTextField esloraTextField = new BFTextField(new Rectangle(10, 371, 362, 20), 0);
		getContentPane().add(esloraTextField);
				
		
		
		BFTextField mangaTextField = new BFTextField(new Rectangle(10, 451, 362, 20), 0);
		getContentPane().add(mangaTextField);
		
		
		
		
		BFTextField longitudTextField = new BFTextField(new Rectangle(421, 371, 362, 20), 0);
		longitudTextField.setVisible(false);
		getContentPane().add(longitudTextField);		
		
		
		
		BFTextField cantPasajerosTextField = new BFTextField(new Rectangle(421, 451, 362, 20), 0);
		cantPasajerosTextField.setVisible(false);
		getContentPane().add(cantPasajerosTextField);

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
		getContentPane().add(tipoComboBox);
		
		//	Boton para guardar la persona		
		BFButton saveButton = new BFButton("Guardar", new Rectangle(278, 526, 137, 28));
		getContentPane().add(saveButton);
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

		//	Boton para cargar el vehiculo
		BFButton loadButton = new BFButton("Cargar", new Rectangle(278, 565, 137, 30));
		getContentPane().add(loadButton);
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
		
	}
}
