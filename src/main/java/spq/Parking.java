package spq;

import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.border.LineBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import jdo.Coche;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class Parking extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	Client cliente = ClientBuilder.newClient();
	final WebTarget appTarget = cliente.target("http://localhost:8080/myapp");
	final WebTarget parkingTarget = appTarget.path("parking");

	final JButton btnNewButton_1 = new JButton();
	final JButton btnNewButton_2 = new JButton();
	final JButton btnNewButton_3 = new JButton();
	final JButton btnNewButton_4 = new JButton();
	final JButton btnNewButton_5 = new JButton();
	final JButton btnNewButton_6 = new JButton();
	final JButton btnNewButton_7 = new JButton();
	final JButton btnNewButton_8 = new JButton();
	final JButton btnNewButton_9 = new JButton();
	final JButton btnNewButton_10 = new JButton();
	final JButton btnNewButton_11 = new JButton();
	final JButton btnNewButton_12 = new JButton();

	public static Coche coche;

	/**
	 * Launch the application.
	 */
	public static void main(Coche cochep) {
		coche = cochep;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Parking window = new Parking();
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
	public Parking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		new JFrame();
		setBounds(100, 100, 753, 301);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(1);
				btnNewButton_1.setEnabled(false);
				btnNewButton_1.setBorder(new LineBorder(Color.RED));
				System.out.println(coche.getMatricula());
				String matricula = coche.getMatricula();
				WebTarget anadirTarget = parkingTarget.path("reservar").queryParam("Coche", "matriculado");
				GenericType<Boolean> genericType5 = new GenericType<Boolean>() {
				};
				boolean respuesta = anadirTarget.request(MediaType.APPLICATION_JSON).get(genericType5);

				JOptionPane.showMessageDialog(null, "Plaza Reservada");
			}
		});
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(10, 11, 124, 49);
		getContentPane().add(btnNewButton_1);

		JButton volver = new JButton("VOLVER");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventanaprincipal vp = new Ventanaprincipal();
				vp.setVisible(true);
				dispose();
			}
		});
		volver.setBounds(317, 227, 89, 23);
		getContentPane().add(volver);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(2);
				btnNewButton_2.setEnabled(false);
				btnNewButton_2.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_2.setForeground(Color.GREEN);
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setBounds(10, 71, 124, 49);
		getContentPane().add(btnNewButton_2);

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(3);
				btnNewButton_3.setEnabled(false);
				btnNewButton_3.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_3.setForeground(Color.GREEN);
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.setBounds(10, 131, 124, 49);
		getContentPane().add(btnNewButton_3);

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(4);
				btnNewButton_4.setEnabled(false);
				btnNewButton_4.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_4.setForeground(Color.GREEN);
		btnNewButton_4.setBackground(Color.GREEN);
		btnNewButton_4.setBounds(233, 11, 124, 49);
		getContentPane().add(btnNewButton_4);

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(5);
				btnNewButton_5.setEnabled(false);
				btnNewButton_5.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_5.setForeground(Color.GREEN);
		btnNewButton_5.setBackground(Color.GREEN);
		btnNewButton_5.setBounds(233, 71, 124, 49);
		getContentPane().add(btnNewButton_5);

		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(6);
				btnNewButton_6.setEnabled(false);
				btnNewButton_6.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_6.setForeground(Color.GREEN);
		btnNewButton_6.setBackground(Color.GREEN);
		btnNewButton_6.setBounds(233, 131, 124, 49);
		getContentPane().add(btnNewButton_6);

		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(7);
				btnNewButton_7.setEnabled(false);
				btnNewButton_7.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_7.setForeground(Color.GREEN);
		btnNewButton_7.setBackground(Color.GREEN);
		btnNewButton_7.setBounds(367, 11, 124, 49);
		getContentPane().add(btnNewButton_7);

		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(8);
				btnNewButton_8.setEnabled(false);
				btnNewButton_8.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_8.setForeground(Color.GREEN);
		btnNewButton_8.setBackground(Color.GREEN);
		btnNewButton_8.setBounds(367, 71, 124, 49);
		getContentPane().add(btnNewButton_8);

		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(9);
				btnNewButton_9.setEnabled(false);
				btnNewButton_9.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_9.setForeground(Color.GREEN);
		btnNewButton_9.setBackground(Color.GREEN);
		btnNewButton_9.setBounds(367, 131, 124, 49);
		getContentPane().add(btnNewButton_9);

		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(10);
				btnNewButton_10.setEnabled(false);
				btnNewButton_10.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_10.setForeground(Color.GREEN);
		btnNewButton_10.setBackground(Color.GREEN);
		btnNewButton_10.setBounds(600, 11, 124, 49);
		getContentPane().add(btnNewButton_10);

		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(11);
				btnNewButton_11.setEnabled(false);
				btnNewButton_11.setBorder(new LineBorder(Color.RED));
				Reservar(coche);
			}
		});
		btnNewButton_11.setForeground(Color.GREEN);
		btnNewButton_11.setBackground(Color.GREEN);
		btnNewButton_11.setBounds(600, 71, 124, 49);
		getContentPane().add(btnNewButton_11);

		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche.setParking(12);
				btnNewButton_12.setEnabled(false);
				btnNewButton_12.setForeground(Color.RED);
				btnNewButton_12.setBackground(Color.RED);
				Reservar(coche);

			}
		});
		btnNewButton_12.setForeground(Color.GREEN);
		btnNewButton_12.setBackground(Color.GREEN);
		btnNewButton_12.setBounds(600, 131, 124, 49);
		getContentPane().add(btnNewButton_12);

		WebTarget buscarTarget = parkingTarget.path("buscar");
		GenericType<List<Integer>> genericType = new GenericType<List<Integer>>() {
		};
		final List<Integer> parkings = buscarTarget.request(MediaType.APPLICATION_JSON).get(genericType);

		for (Integer p : parkings) {

			if (p.equals(1)) {
				btnNewButton_1.setEnabled(false);
				btnNewButton_1.setBorder(new LineBorder(Color.RED));
				btnNewButton_1.setBackground(Color.RED);

			} else if (p.equals(2)) {
				btnNewButton_2.setEnabled(false);
				btnNewButton_2.setBorder(new LineBorder(Color.RED));
				btnNewButton_2.setBackground(Color.RED);

			} else if (p.equals(3)) {
				btnNewButton_3.setEnabled(false);
				btnNewButton_3.setBorder(new LineBorder(Color.RED));
				btnNewButton_3.setBackground(Color.RED);

			} else if (p.equals(4)) {
				btnNewButton_4.setEnabled(false);
				btnNewButton_4.setBorder(new LineBorder(Color.RED));
				btnNewButton_4.setBackground(Color.RED);

			} else if (p.equals(5)) {
				btnNewButton_5.setEnabled(false);
				btnNewButton_5.setBorder(new LineBorder(Color.RED));
				btnNewButton_5.setBackground(Color.RED);

			} else if (p.equals(6)) {
				btnNewButton_6.setEnabled(false);
				btnNewButton_6.setBorder(new LineBorder(Color.RED));
				btnNewButton_6.setBackground(Color.RED);

			} else if (p.equals(7)) {
				btnNewButton_7.setEnabled(false);
				btnNewButton_7.setBorder(new LineBorder(Color.RED));
				btnNewButton_7.setBackground(Color.RED);

			} else if (p.equals(8)) {
				btnNewButton_8.setEnabled(false);
				btnNewButton_8.setBorder(new LineBorder(Color.RED));
				btnNewButton_8.setBackground(Color.RED);

			} else if (p.equals(9)) {
				btnNewButton_9.setEnabled(false);
				btnNewButton_9.setBorder(new LineBorder(Color.RED));
				btnNewButton_9.setBackground(Color.RED);

			} else if (p.equals(10)) {
				btnNewButton_10.setEnabled(false);
				btnNewButton_10.setBorder(new LineBorder(Color.RED));
				btnNewButton_10.setBackground(Color.RED);

			} else if (p.equals(11)) {
				btnNewButton_11.setEnabled(false);
				btnNewButton_11.setBorder(new LineBorder(Color.RED));
				btnNewButton_11.setBackground(Color.RED);

			} else if (p.equals(12)) {
				System.out.println(1);
				btnNewButton_12.setEnabled(false);
				btnNewButton_12.setBorder(new LineBorder(Color.RED));
				btnNewButton_12.setBackground(Color.RED);

			}

		}

	}

	public void Reservar(Coche coche) {
		WebTarget reservarTarget = parkingTarget.path("reservar");
		reservarTarget.request().post(Entity.entity(coche, MediaType.APPLICATION_JSON));
		JOptionPane.showMessageDialog(null, "Plaza Reservada Con Exito");
		Ventanaprincipal vp = new Ventanaprincipal();
		vp.setVisible(true);
		dispose();

	}

}
