package swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.List;
import java.awt.Rectangle;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class InterfazPersona extends BFInterfaz {
	public InterfazPrincipal parent;
	public InterfazVehiculo vehiculos;
	public ListaPersonaHandler handler;	//	Llamado para acceder a la memoria
	public List vehiculosList; // Lista de vehiculos
	public int idPersona;
	
	public InterfazPersona(ListaPersonaHandler handler, InterfazPrincipal parent) {
		super("Editor de personas");
		this.handler = handler;
		this.parent = parent;
		
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
		getContentPane().setBackground(Color.WHITE);

		//	Todo lo que son labels van aquí
		BFLabel idLabel = new BFLabel(textID, new Rectangle(21, 482, 35, 28));
		getContentPane().add(idLabel);
		//	Label del nombre
		BFLabel nombreLabel = new BFLabel(textNombre, new Rectangle(10, 41, 103, 38));
		getContentPane().add(nombreLabel);
		//	Label del apellido
		BFLabel apellidoLabel = new BFLabel(textApellido, new Rectangle(10, 121, 103, 38));
		getContentPane().add(apellidoLabel);
		//	Label de la fecha de nacimiento
		BFLabel fechaNacimientoLabel = new BFLabel(textFechaNacimiento, new Rectangle(10, 201, 181, 38));
		getContentPane().add(fechaNacimientoLabel);
		//	Label del departamento de residencia
		BFLabel dptoResidenciaLabel = new BFLabel(textDptResidencia, new Rectangle(10, 281, 236, 38));
		getContentPane().add(dptoResidenciaLabel);
		//	Label de la cantidad de hijos
		BFLabel cantidadHijosLabel = new BFLabel(textCantidadHijos, new Rectangle(10, 400, 147, 38));
		getContentPane().add(cantidadHijosLabel);
		//	Label de agregar Vehiculo
		BFLabel vehiculosLabel = new BFLabel(textVehiculos, new Rectangle(470, 78, 175, 32));
		getContentPane().add(vehiculosLabel);
		//	Icono del grupo		
		BFLabel lblNewLabel = new BFLabel("", new Rectangle(709, 61, 103, 119));
		lblNewLabel.setIcon(new ImageIcon(InterfazPersona.class.getResource("/resource/iconReverso100x100.png")));
		getContentPane().add(lblNewLabel);
		
		
		
		//	Todo lo que son textFields van aquí
		BFTextField nombreTextField = new BFTextField(new Rectangle(10, 90, 362, 20));
		getContentPane().add(nombreTextField);
		BFTextField apellidoTextField = new BFTextField(new Rectangle(10, 170, 362, 20));
		getContentPane().add(apellidoTextField);
		BFTextField fechaNacimientoTextField = new BFTextField(new Rectangle(10, 250, 362, 20), "Fecha");
		getContentPane().add(fechaNacimientoTextField);
		//BFTextField dptoResidenciaTextField = new BFTextField(new Rectangle(10, 330, 362, 20));
		//add(dptoResidenciaTextField);
		
		
		BFSpinner cantidadHijosSpinner = new BFSpinner(new Rectangle(167, 407, 54, 31));
		getContentPane().add(cantidadHijosSpinner);		
		BFSpinner idSpinner = new BFSpinner(new Rectangle(167, 485, 54, 28));
		getContentPane().add(idSpinner);

		//ComboBox para seleccionar departamento de residencia @Matías, sustituí el TextField
		String deptos[] = {"Artigas","Canelones","Cerro Largo","Colonia","Durazno","Flores","Florida","Lavalleja","Maldonado","Montevideo","Paysandú","Río Negro","Rivera","Rocha","Salto","San José","Soriano","Tacuarembó","Treinta y Tres"};
		JComboBox deptoResidenciaComboBox = new JComboBox(deptos);
		deptoResidenciaComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deptoResidenciaComboBox.setBounds(10, 332, 362, 22);
		
		getContentPane().add(deptoResidenciaComboBox);

		
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
				vehiculos = new InterfazVehiculo(handler, id, InterfazPersona.this);
				vehiculos.setVisible(true);
			}
		});
		crearVehiculo.setBounds(470, 371, 233, 30);
		getContentPane().add(crearVehiculo);		

		//	Lista de vehiculos
		/*	La lista de vehiculos es parte de la propia clase IntergazPersonas
		 *  para poder ser accesible desde fuera por otras clases por medio de la funcion
		 *  actualizarListaVehiculos()
		 */
		this.vehiculosList = new List();
		vehiculosList.setBounds(470, 121, 233, 244);
		getContentPane().add(vehiculosList);
		
		

		//	Boton para guardar la persona		
		BFButton saveButton = new BFButton(textGuardar, new Rectangle(256, 484, 137, 28));
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//	Si estamos en modo debug, ignomeros todas las medidas contra errores y creemos una persona de prueba
				if (parent.isDebug()) {
					handler.crearPersona((byte) ((int) idSpinner.getValue()), "Nombre de prueba", "Apellido de prueba",LocalDate.parse("1998-10-28"),(byte) 0, deptoResidenciaComboBox.getSelectedItem().toString());
					vehiculosList.removeAll();
					JOptionPane.showMessageDialog(null,"¡Datos guardados!");
				}
				else if (nombreTextField.getText().strip() == "" ) {Msg.MostrarError("Campo sin valor");}
				else if (apellidoTextField.getText().strip() == "" ) {Msg.MostrarError("Campo vacio: Apellido");}
				else if (fechaNacimientoTextField.getText().strip() == "") {Msg.MostrarError("Campo vacio: Fecha de nacimiento");}
				else if (!ValidarIngresos.ValidarFecha("Fecha Nacimiento", fechaNacimientoTextField.getText())) {return;} 
				else {
					handler.crearPersona((byte) ((int) idSpinner.getValue()), nombreTextField.getText(), apellidoTextField.getText(),LocalDate.parse(fechaNacimientoTextField.getText()),(byte) ((int) cantidadHijosSpinner.getValue()), deptoResidenciaComboBox.getSelectedItem().toString());
					idSpinner.setValue(0);
					nombreTextField.setText("");
					apellidoTextField.setText("");
					fechaNacimientoTextField.setText("");
					cantidadHijosSpinner.setValue(0);
					vehiculosList.removeAll();
					JOptionPane.showMessageDialog(null,"¡Datos guardados!");
				}
				parent.getListaDePersonasList().actualizarLista();
				parent.getDashboard().actualizarDashboard();
				parent.getListaDeAltaList().actualizarListaDeAlta();
			}
		});
		getContentPane().add(saveButton);
		
		
		//	Boton para cargar la persona
		BFButton loadButton = new BFButton(textCargar, new Rectangle(256, 523, 137, 30));
		loadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = (int) idSpinner.getValue();
				actualizarIdPersona(id);	//	Actualizamos el id del dueño
				if (handler.listaDePersonas.size() <= 0) {Msg.MostrarError("¡Aun no existen personas!");}
				else if (handler.buscarIDPersona(id) < 0) {Msg.MostrarError("No existe persona con esa ID");}	//	Si no existe la persona matar el programa
				else {
					Persona p = handler.listaDePersonas.get(handler.buscarIDPersona(id));
					nombreTextField.setText(p.getNombre());
					apellidoTextField.setText(p.getApellido());
					fechaNacimientoTextField.setText(p.getFechaNacimiento().toString());
					deptoResidenciaComboBox.setSelectedItem(p.getDptoResidencia());
					cantidadHijosSpinner.setValue((int) p.getCantHijos());
					actualizarListaVehiculos();
					JOptionPane.showMessageDialog(null,"¡Datos cargados!");
				}
			}
		});
		getContentPane().add(loadButton);
		
				
	}	
	public void actualizarListaVehiculos() {
		this.vehiculosList.removeAll();
		for (Vehiculo v : handler.listaDeVehiculos) {	//	Por cada vehiculo que comprata la id de la persona
			if (v.getIdDueño() == idPersona) {
				System.out.println(v.getIdDueño() + " " + idPersona);
				this.vehiculosList.add(v.toString());
			}
		}
	}
	public void actualizarIdPersona(int i) {
		this.idPersona = i;
	}
}
