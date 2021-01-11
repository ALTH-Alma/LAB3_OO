package _TDAs;

/**
 * Clase que representa etiquetas en el stack.
 * Esta clase queda determinada por una nombre y una decripición.
 * @author Alma
 *
 */
public class Etiqueta {
	
	private String name; //Nombre de la etiqueta.
	private String descripcion; //Descripción de la etiqueta.
	

	/**
	 * Crea una nueva etiqueta a partir de un nombre y una descripción.
	 * @param name Nombre de la etiqueta.
	 * @param descripcion Descripción de la etiqueta. 
	 */
	public Etiqueta(String name, String descripcion) {
		this.name = name;
		this.descripcion = descripcion;
	}
	
	
	/**
	 * Entrega el nombre de la etiqueta.
	 * @return Nombre de la etiqueta.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Permite modificar el nombre de una etiqueta.
	 * @param name Nuevo nombre de la etiqueta.
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Entrega la descripción de la etiqueta. 
	 * @return Descripción de etiqueta.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Permite modificar la descripción de la etiqueta. 
	 * @param descripcion Nueva descrición.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Muestra la etiqueta. 
	 */
	public void mostrarEtiqueta() {
		System.out.println(name+": "+descripcion+"\n");
	}
	
}
