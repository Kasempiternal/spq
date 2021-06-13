package gui;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
import spq.Parking;

@Category(GuiTest.class)
public class ReservaTest {

	private HttpServer server;
	private WebTarget appTarget;
	private Coche coche = Mockito.mock(Coche.class);

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
	public void testReserva() {
		WebTarget parkingTarget = appTarget.path("parking");

		Coche coche2 = new Coche("7777EEE", "Hyundai", "Azul", "Gorka", 5);

		WebTarget reservarTarget = parkingTarget.path("reservar");
		reservarTarget.request().post(Entity.entity(coche2, MediaType.APPLICATION_JSON));

		when(coche.getMatricula()).thenReturn("7777EEE");
		boolean libre = ParkingResource.verMatriculaUsada(coche.getMatricula());
		assertEquals(false, libre);
	}

	@Test
	public void testBuscar() {
		Parking p = new Parking();
		Coche coche2 = new Coche("2222EEE", "Hyunedai", "Azule", "Gorkea", 2);
		assertEquals(true, p.Reservar(coche2));
	}

}
