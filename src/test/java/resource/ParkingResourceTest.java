package resource;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import categories.IntegrationTest;
import jdo.Coche;
import server.Server;

@Category(IntegrationTest.class)
public class ParkingResourceTest {
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	private HttpServer server;
	private WebTarget appTarget;
	private Client c;
	

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
	@PerfTest(invocations = 100, threads = 40)
	public void testReservaVermatricula() {
		WebTarget parkingTarget = appTarget.path("parking");
		WebTarget reservarTarget = parkingTarget.path("reservar");
		
		Coche coche = new Coche("7777EEE", "Hyundai", "Azul", "Gorka", 5);

		
		reservarTarget.request().post(Entity.entity(coche, MediaType.APPLICATION_JSON));

		boolean libre = ParkingResource.verMatriculaUsada("7777EEE");

		assertEquals(false, libre);

	}

	@Test
	@PerfTest(invocations = 100, threads = 40)
	public void testBuscar() {
		WebTarget parkingTarget = appTarget.path("parking");
		WebTarget buscarTarget = parkingTarget.path("buscar");

		int respuesta = 0;
		Coche coche = new Coche("7777EEE", "Hyundai", "Azul", "Gorka", 5);

		WebTarget reservarTarget = parkingTarget.path("reservar");
		reservarTarget.request().post(Entity.entity(coche, MediaType.APPLICATION_JSON));

		
		GenericType<List<Integer>> genericType = new GenericType<List<Integer>>() {
		};
		final List<Integer> parkings = buscarTarget.request(MediaType.APPLICATION_JSON).get(genericType);

		for (Integer p : parkings) {

			respuesta = p;
		}
		
		assertEquals(respuesta, 5);
	}
	
	@Test
	@PerfTest(invocations = 100, threads = 40)
	public void testLibera() {
		WebTarget parkingTarget = appTarget.path("parking");
		WebTarget liberarTarget = parkingTarget.path("liberar");
		
		Coche coche = new Coche("7777EEE", "Hyundai", "Azul", "Gorka", 5);

		WebTarget reservarTarget = parkingTarget.path("reservar");
		reservarTarget.request().post(Entity.entity(coche, MediaType.APPLICATION_JSON));
		
		
		liberarTarget.request().post(Entity.entity("7777EEE", MediaType.APPLICATION_JSON));
		

		boolean libre = ParkingResource.verMatriculaUsada("7777EEE");

		assertEquals(true, libre);

	}
}
