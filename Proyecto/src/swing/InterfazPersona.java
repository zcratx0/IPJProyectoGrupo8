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

import clases.ListaPersonaHandler;
import clases.Persona;
import clases.Vehiculo;
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
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JList;
import java.awt.List;

public class InterfazPersona extends JFrame {
	private JPanel contentPane;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField fechaNacimientoTextField;
	private JTextField dptoResidenciaTextField;
	
	public InterfazVehiculo vehiculos;
	public ListaPersonaHandler handler;	//	LLamado para acceder a la memoria
	public List vehiculosList; // Creo la lista de vehiculos
	public int xPos = 0;	//	Coordenada para mover la ventana
	public int yPos = 0;	//	Coordenada para mover la ventana
	public int idPersona;
	
	public InterfazPersona(ListaPersonaHandler handler, InterfazPrincipal parent) {
		InterfazPersona personaInterfaz = this;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.handler = handler;
		
		//	Para simplificar el ajuste más adelante, aquí vamos a definir todo lo que sea texto a usar
		String textID = "ID";
		String textNombre = "Nombre";
		String textApellido = "Apellido";
		String textDptResidencia = "Departamento de residencia";
		String textCantidadHijos = "Cantidad de hijos";
		String textVehiculos = "Lista de vehiculos";
		
		
		//	Definimos la ventana
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

		//	Todo lo que son labels van aquí
		JLabel idLabel = new JLabel(textID);
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idLabel.setForeground(Color.BLACK);
		idLabel.setBounds(21, 482, 35, 28);
		contentPane.add(idLabel);
		
		JLabel nombreLabel = new JLabel(textNombre);
		nombreLabel.setForeground(Color.BLACK);
		nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombreLabel.setBounds(10, 41, 103, 38);
		contentPane.add(nombreLabel);
		
		JLabel apellidoLabel = new JLabel(textApellido);
		apellidoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		apellidoLabel.setBounds(10, 121, 103, 38);
		contentPane.add(apellidoLabel);

		JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento");
		fechaNacimientoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fechaNacimientoLabel.setBounds(10, 201, 181, 38);
		contentPane.add(fechaNacimientoLabel);
		
		JLabel dptoResidenciaLabel = new JLabel(textDptResidencia);
		dptoResidenciaLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dptoResidenciaLabel.setBounds(10, 281, 236, 38);
		contentPane.add(dptoResidenciaLabel);
		
		JLabel cantidadHijosLabel = new JLabel(textCantidadHijos);
		cantidadHijosLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cantidadHijosLabel.setBounds(10, 400, 147, 38);
		contentPane.add(cantidadHijosLabel);
		
		JLabel vehiculosLabel = new JLabel(textVehiculos);
		vehiculosLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		vehiculosLabel.setBounds(470, 78, 175, 32);
		contentPane.add(vehiculosLabel);

		//	Todo lo que son textFields van aquí
		
		nombreTextField = new JTextField();
		nombreTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		nombreTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nombreTextField.setBounds(10, 90, 362, 20);
		contentPane.add(nombreTextField);
		nombreTextField.setColumns(10);
		nombreTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarLetras(e);
			}
		});
		
		apellidoTextField = new JTextField();
		apellidoTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		apellidoTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		apellidoTextField.setColumns(10);
		apellidoTextField.setBounds(10, 170, 362, 20);
		contentPane.add(apellidoTextField);
		apellidoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarLetras(e);
			}
		});
		
		fechaNacimientoTextField = new JTextField();
		fechaNacimientoTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		fechaNacimientoTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fechaNacimientoTextField.setBounds(10, 250, 362, 20);
		contentPane.add(fechaNacimientoTextField);
		fechaNacimientoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarFechas(e);
			}
		});
		fechaNacimientoTextField.setToolTipText("Formato debe ser aaaa-dd-mm");
		
		
		dptoResidenciaTextField = new JTextField();
		dptoResidenciaTextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		dptoResidenciaTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dptoResidenciaTextField.setColumns(10);
		dptoResidenciaTextField.setBounds(10, 330, 362, 20);
		contentPane.add(dptoResidenciaTextField);
		dptoResidenciaTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ValidarIngresos.ValidarLetras(e);
			}
		});
		
		JSpinner cantidadHijosSpinner = new JSpinner();
		cantidadHijosSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		cantidadHijosSpinner.setBounds(167, 407, 54, 31);
		contentPane.add(cantidadHijosSpinner );
		
		
		
		JSpinner idSpinner = new JSpinner();
		idSpinner.setBounds(167, 485, 54, 28);
		contentPane.add(idSpinner);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfazPersona.class.getResource("/resource/iconReverso100x100.png")));
		lblNewLabel.setBounds(709, 61, 103, 119);
		contentPane.add(lblNewLabel);
		
		
		//	Boton para agregar vehiculo
		JButton crearVehiculo = new JButton("Agregar Vehiculo");
		crearVehiculo.setForeground(Color.WHITE);
		crearVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crearVehiculo.setBackground(new Color(143, 188, 143));
		crearVehiculo.setBorderPainted(false);
		crearVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = (int) idSpinner.getValue();
				actualizarIdPersona(id);
				vehiculos = new InterfazVehiculo(handler, id, personaInterfaz);
				vehiculos.setVisible(true);
			}
		});
		crearVehiculo.setBounds(470, 371, 233, 30);
		contentPane.add(crearVehiculo);
		
		
		
		
		//	Lista de vehiculos
		
		this.vehiculosList = new List();
		vehiculosList.setBounds(470, 121, 233, 244);
		contentPane.add(vehiculosList);
		
		
		
		
		//	App bar para mover la ventana
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				//	Movemos la ventana usando las coordenadas almacenadas
				setLocation(e.getXOnScreen()-xPos, e.getYOnScreen()-yPos);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//	Almacenamos las coordenadas donde dimos click
				xPos = e.getX();
				yPos = e.getY();
			}
		});
		panel.setBackground(new Color(72, 72, 72));
		panel.setBounds(0, 0, 830, 50);
		contentPane.add(panel);
		

		//	Boton para guardar la persona		
		JButton saveButton = new JButton("Guardar");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		saveButton.setForeground(Color.WHITE);
		saveButton.setBorderPainted(false);
		saveButton.setBackground(new Color(143, 188, 143));
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (nombreTextField.getText().strip() == "" ) {Msg.MostrarError("Campo sin valor");}
				else if (apellidoTextField.getText().strip() == "" ) {Msg.MostrarError("Campo vacio: Apellido");}
				else if (dptoResidenciaTextField.getText().strip() == "") {Msg.MostrarError("Campo vacio: Departamento de residencia");}
				else if (fechaNacimientoTextField.getText().strip() == "") {Msg.MostrarError("Campo vacio: Fecha de nacimiento");}
				else if (!ValidarIngresos.ValidarFecha("Fecha Nacimiento", fechaNacimientoTextField.getText())) {return;} 
				else {
					handler.crearPersona((byte) ((int) idSpinner.getValue()), nombreTextField.getText(), apellidoTextField.getText(),LocalDate.parse(fechaNacimientoTextField.getText()),(byte) ((int) cantidadHijosSpinner.getValue()), dptoResidenciaTextField.getText());
					handler.actualizarVehiculos();
					parent.actualizarLista();
					idSpinner.setValue(0);
					nombreTextField.setText("");
					apellidoTextField.setText("");
					dptoResidenciaTextField.setText("");
					fechaNacimientoTextField.setText("");
					cantidadHijosSpinner.setValue(0);
					vehiculosList.removeAll();
					JOptionPane.showMessageDialog(null,"¡Datos guardados!");
					
				}
			}
		});
				
		saveButton.setBounds(256, 484, 137, 28);
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
				if (handler.listaDePersonas.get(id) == null) {Msg.MostrarError("No existe persona con esa ID");}	//	Si no existe la persona matar el programa
				else {
					nombreTextField.setText(handler.listaDePersonas.get(id).getNombre());
					apellidoTextField.setText(handler.listaDePersonas.get(id).getApellido());
					fechaNacimientoTextField.setText(handler.listaDePersonas.get(id).getFechaNacimiento().toString());
					dptoResidenciaTextField.setText(handler.listaDePersonas.get(id).getDptoResidencia());
					cantidadHijosSpinner.setValue((int) handler.listaDePersonas.get(id).getCantHijos());
					actualizarListaVehiculos();
					JOptionPane.showMessageDialog(null,"¡Datos cargados!");
				}
			}
		});
		loadButton.setBounds(256, 523, 137, 30);
		contentPane.add(loadButton);
		
		
		
		
		
	}
	
	public void actualizarListaVehiculos() {
		this.vehiculosList.removeAll();
		for (Vehiculo v : handler.listaDeVehiculos) {
			if (v.getIdDueño() == idPersona) {
				this.vehiculosList.add(v.toString());
			}
		}
	}
	public void actualizarIdPersona(int i) {
		this.idPersona = i;
	}
}
