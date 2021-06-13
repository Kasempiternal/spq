package gui;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.swing.JTextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import categories.GuiTest;
import jdo.Coche;
import resource.ParkingResource;
import server.Server;
import spq.Ventanaprincipal;

@Category(GuiTest.class)
public class VentanaPrincipalTest {
	private HttpServer server;
	private WebTarget appTarget;
	private Coche coche = Mockito.mock(Coche.class);

	private Coche c = Mockito.mock(Coche.class);
	private JTextField matricula = Mockito.mock(JTextField.class);
	private JTextField marca = Mockito.mock(JTextField.class);
	private JTextField color = Mockito.mock(JTextField.class);
	private JTextField nombre = Mockito.mock(JTextField.class);

	@Before
	public void setUp() throws Exception {
		// start the server
		server = Server.startServer();
		// create the client
		Client c = ClientBuilder.newClient();
		appTarget = c.target(Server.BASE_URI);

	}

	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	@Test
	public void ReservaYLibera() {
		WebTarget parkingTarget = appTarget.path("parking");

		Coche coche2 = new Coche("7777EEE", "Hyundai", "Azul", "Gorka", 5);

		WebTarget reservarTarget = parkingTarget.path("reservar");
		reservarTarget.request().post(Entity.entity(coche2, MediaType.APPLICATION_JSON));

		when(coche.getMatricula()).thenReturn("7777EEE");
		boolean libre = ParkingResource.verMatriculaUsada(coche.getMatricula());
		assertEquals(false, libre);

	}

	@Test
	public void botones() {
		Coche coche = new Coche();
		when(matricula.getText()).thenReturn("7777EEE");
		coche.setMatricula(matricula.getText());
		when(marca.getText()).thenReturn("Nisan");
		coche.setMarca(marca.getText());
		when(color.getText()).thenReturn("Azul");
		coche.setColor(color.getText());
		when(nombre.getText()).thenReturn("Paco");
		coche.setNombre(nombre.getText());

		assertEquals("7777EEE", coche.getMatricula());
		assertEquals("Nisan", coche.getMarca());
		assertEquals("Azul", coche.getColor());
		assertEquals("Paco", coche.getNombre());

	}

}
