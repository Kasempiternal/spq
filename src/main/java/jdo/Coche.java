package jdo;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Clase COCHE para un registrar coches
 * 
 * @author Izotz
 *
 */
@PersistenceCapable(detachable = "true")
public class Coche {

	private String matricula;
	private String marca;
	private String color;
	private String nombre;
	private int parking;

	/**
	 * Constructor vacio de la clase coche
	 */
	public Coche() {

	}

	/**
	 * Constructor de la clase Coche
	 * 
	 * @param matricula String con el la matricula del coche
	 * @param marca     String con la marca del coche
	 * @param color     String con el color del coche
	 * @param nombre    String con nuestro nombre
	 * @param parking   String con el parking donde se encuentra el coche
	 */
	public Coche(String matricula, String marca, String color, String nombre, int parking) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
		this.nombre = nombre;
		this.parking = parking;
	}

	/**
	 * Devuelve el texto del Coche
	 * 
	 * @return String con la matricula del Coche
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Cambia la matricula del coche
	 * 
	 * @param matricula String con el la matricula del coche
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Devuelve la marca del Coche
	 * 
	 * @return String con la marca del Coche
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Cambia la marca del coche
	 * 
	 * @param marca String con la marca del coche
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Devuelve el color del Coche
	 * 
	 * @return String con el color del Coche
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Cambia el color del Coche
	 * 
	 * @param color String con el color del coche
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Devuelve el texto del Nombre
	 * 
	 * @return String con el nombre del usuario del coche
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nombre del usuario del Coche
	 * 
	 * @param color String con el usuario del coche
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getParking() {
		return parking;
	}

	public void setParking(int parking) {
		this.parking = parking;
	}

}
