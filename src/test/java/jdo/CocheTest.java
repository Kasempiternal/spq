package jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CocheTest {
	private Coche coche;

	@Before
	public void crearCoche() {
		coche = new Coche("7777EEE", "Hyundai", "Azul", "Gorka", 5);
	}

	@Test
	public void testGetMatricula() {
		assertEquals("7777EEE", coche.getMatricula());
	}

	@Test
	public void testGetMarca() {
		assertEquals("Hyundai", coche.getMarca());
	}

	@Test
	public void testGetColor() {
		assertEquals("Azul", coche.getColor());
	}

	@Test
	public void testGetNombre() {
		assertEquals("Gorka", coche.getNombre());
	}

	@Test
	public void testGetParking() {
		assertEquals(5, coche.getParking());
	}

}
