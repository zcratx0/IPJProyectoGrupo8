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
import componentes.BFAppBar;
import componentes.BFButton;
import componentes.BFInterfaz;
import componentes.BFLabel;
import componentes.BFLabelX;
import componentes.BFTextField;
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
import javax.swing.JList;
import java.awt.List;
import java.awt.Rectangle;

public class InterfazPersona extends BFInterfaz {
	private JPanel contentPane;
	public InterfazVehiculo vehiculos;
	public ListaPersonaHandler handler;	//	Llamado para acceder a la memoria
	public List vehiculosList; // Lista de vehiculos
	public int idPersona;
	
	public InterfazPersona(ListaPersonaHandler handler, InterfazPrincipal parent) {
		InterfazPersona personaInterfaz = this;
		this.handler = handler;
		
		//	Para simplificar el ajuste futuros, aquí vamos a definir todo lo que sea texto
		String textID = "ID";
		String textNombre = "Nombre";
		String textApellido = "Apellido";
		String textFechaNacimiento = "Fecha de Nacimiento";
		String textDptResidencia = "Departamento de residencia";
		String textCantidadHijos = "Cantidad de hijos";
		String textVehiculos = "Lista de vehiculos";
		String textGuardar = "Guardar";
		String textCargar = "Cargar";
		
		//	Definimos la ventana
		setBounds(100, 100, 850, 606);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//	Todo lo que son labels van aquí
		BFLabel idLabel = new BFLabel(textID, new Rectangle(21, 482, 35, 28));
		contentPane.add(idLabel);
		//	Label del nombre
		BFLabel nombreLabel = new BFLabel(textNombre, new Rectangle(10, 41, 103, 38));
		contentPane.add(nombreLabel);
		//	Label del apellido
		BFLabel apellidoLabel = new BFLabel(textApellido, new Rectangle(10, 121, 103, 38));
		contentPane.add(apellidoLabel);
		//	Label de la fecha de nacimiento
		BFLabel fechaNacimientoLabel = new BFLabel(textFechaNacimiento, new Rectangle(10, 201, 181, 38));
		contentPane.add(fechaNacimientoLabel);
		//	Label del departamento de residencia
		BFLabel dptoResidenciaLabel = new BFLabel(textDptResidencia, new Rectangle(10, 281, 236, 38));
		contentPane.add(dptoResidenciaLabel);
		//	Label de la cantidad de hijos
		BFLabel cantidadHijosLabel = new BFLabel(textCantidadHijos, new Rectangle(10, 400, 147, 38));
		contentPane.add(cantidadHijosLabel);
		//	Label de agregar Vehiculo
		BFLabel vehiculosLabel = new BFLabel(textVehiculos, new Rectangle(470, 78, 175, 32));
		contentPane.add(vehiculosLabel);
		//	Icono del grupo		
		BFLabel lblNewLabel = new BFLabel("", new Rectangle(709, 61, 103, 119));
		lblNewLabel.setIcon(new ImageIcon(InterfazPersona.class.getResource("/resource/iconReverso100x100.png")));
		contentPane.add(lblNewLabel);
		
		
		
		//	Todo lo que son textFields van aquí
		BFTextField nombreTextField = new BFTextField(new Rectangle(10, 90, 362, 20));
		add(nombreTextField);
		BFTextField apellidoTextField = new BFTextField(new Rectangle(10, 170, 362, 20));
		add(apellidoTextField);
		BFTextField fechaNacimientoTextField = new BFTextField(new Rectangle(10, 250, 362, 20), "Fecha");
		add(fechaNacimientoTextField);
		BFTextField dptoResidenciaTextField = new BFTextField(new Rectangle(10, 330, 362, 20));
		add(dptoResidenciaTextField);
		
		JSpinner cantidadHijosSpinner = new JSpinner();
		cantidadHijosSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		cantidadHijosSpinner.setBounds(167, 407, 54, 31);
		add(cantidadHijosSpinner );		
		JSpinner idSpinner = new JSpinner();
		idSpinner.setBounds(167, 485, 54, 28);
		contentPane.add(idSpinner);
	
		
		
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
		/*	La lista de vehiculos es parte de la propia clase IntergazPersonas
		 *  para poder ser accesible desde fuera por otras clases por medio de la funcion
		 *  actualizarListaVehiculos()
		 */
		this.vehiculosList = new List();
		vehiculosList.setBounds(470, 121, 233, 244);
		contentPane.add(vehiculosList);
		
		//	App bar para mover la ventana
		Component appBar = new BFAppBar("Editar Personas");
		contentPane.add(appBar);
		

		//	Boton para guardar la persona		
		BFButton saveButton = new BFButton(textGuardar, new Rectangle(256, 484, 137, 28));
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
		add(saveButton);
		
		
		//	Boton para cargar la persona
		BFButton loadButton = new BFButton(textCargar, new Rectangle(256, 523, 137, 30));
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
		add(loadButton);
		
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
