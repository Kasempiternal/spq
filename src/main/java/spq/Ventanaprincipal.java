package spq;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import jdo.Coche;
import resource.ParkingResource;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Ventanaprincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField matriculatxt;
	private JTextField marcatxt;
	private JTextField colortxt;
	private JTextField nombretxt;

	Client cliente = ClientBuilder.newClient();
	final WebTarget appTarget = cliente.target("http://localhost:8080/myapp");
	final WebTarget parkingTarget = appTarget.path("parking");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanaprincipal window = new Ventanaprincipal();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventanaprincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		new JFrame();
		setBounds(100, 100, 577, 461);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		matriculatxt = new JTextField();
		matriculatxt.setBounds(46, 58, 137, 20);
		getContentPane().add(matriculatxt);
		matriculatxt.setColumns(10);

		JLabel lblNewLabel = new JLabel("Matricula");
		lblNewLabel.setBounds(46, 35, 46, 14);
		getContentPane().add(lblNewLabel);

		marcatxt = new JTextField();
		marcatxt.setBounds(281, 58, 137, 20);
		getContentPane().add(marcatxt);
		marcatxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setBounds(281, 35, 46, 14);
		getContentPane().add(lblNewLabel_1);

		colortxt = new JTextField();
		colortxt.setBounds(46, 139, 137, 20);
		getContentPane().add(colortxt);
		colortxt.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Color");
		lblNewLabel_2.setBounds(46, 104, 46, 14);
		getContentPane().add(lblNewLabel_2);

		nombretxt = new JTextField();
		nombretxt.setBounds(281, 139, 128, 20);
		getContentPane().add(nombretxt);
		nombretxt.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(281, 115, 46, 14);
		getContentPane().add(lblNewLabel_3);

		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		salir.setBounds(46, 377, 89, 23);
		getContentPane().add(salir);

		JButton reservar = new JButton("Reservar");
		reservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean libre = verificar(matriculatxt.getText());
				if (libre) {
					Coche coche = new Coche();
					coche.setMatricula(matriculatxt.getText());
					coche.setMarca(marcatxt.getText());
					coche.setColor(colortxt.getText());
					coche.setNombre(nombretxt.getText());
					Parking.main(coche);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "La Matricula Ya Esta En Uso");
				}
			}

		});
		reservar.setBounds(387, 377, 89, 23);
		getContentPane().add(reservar);

		JButton liberar = new JButton("Liberar");
		liberar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricula = matriculatxt.getText();

				WebTarget liberarTarget = parkingTarget.path("liberar");
				liberarTarget.request().post(Entity.entity(matricula, MediaType.APPLICATION_JSON));
				JOptionPane.showMessageDialog(null, matricula + "Liberado");
			}
		});
		liberar.setBounds(218, 377, 89, 23);
		getContentPane().add(liberar);

		JLabel lblNewLabel_4 = new JLabel("Solo matricula");
		lblNewLabel_4.setBounds(218, 397, 89, 14);
		getContentPane().add(lblNewLabel_4);
	}

	private boolean verificar(String matricula) {
		boolean usado = ParkingResource.verMatriculaUsada(matricula);
		return usado;

	}
}
