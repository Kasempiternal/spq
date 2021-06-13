package resource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jdo.Coche;

@Path("parking")
public class ParkingResource {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@POST
	@Path("reservar")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void Reservar(Coche coche) {
		String matricula = coche.getMatricula();
		String marca = coche.getMarca();
		String color = coche.getColor();
		String nombre = coche.getNombre();
		int parking = coche.getParking();

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Coche c = new Coche(matricula, marca, color, nombre, parking);
			pm.makePersistent(c);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@POST
	@Path("liberar")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void Liberar(String matricula) {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();

		try (@SuppressWarnings("unchecked")
		Query<Coche> q = pm
				.newQuery("SELECT FROM " + Coche.class.getName() + " WHERE matricula== '" + matricula + "'");) {
			List<Coche> user = q.executeList();
			pm.deletePersistentAll(user);
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		} finally {
			pm.close();
		}
	}

	@GET
	@Path("buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Integer> verParkingReservados() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		ArrayList<Integer> parkings = new ArrayList<>();

		try {
			Query<Coche> q = pm.newQuery("SELECT FROM " + Coche.class.getName());

			List<Coche> listaParking = q.executeList();
			for (Coche coche : listaParking) {

				parkings.add(coche.getParking());

			}
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		} finally {
			pm.close();
		}
		return parkings;
	}

	@GET
	@Path("usado")
	@Produces(MediaType.APPLICATION_JSON)
	public static boolean verMatriculaUsada(@QueryParam("matricula") String matricula) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		boolean respuesta = true;
		try {
			Query<Coche> q = pm
					.newQuery("SELECT FROM " + Coche.class.getName() + " WHERE matricula== '" + matricula + "'");

			List<Coche> matriculas = q.executeList();

			if (matriculas.isEmpty()) {
				respuesta = true;
			} else {
				respuesta = false;
			}
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		} finally {
			pm.close();
		}
		return respuesta;
	}

}
