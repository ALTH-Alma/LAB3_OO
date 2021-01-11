package _TDAs;

/**
 * Clase para representar una respuesta en el stack.
 * La clase respuesta hereda de la clase Comun_Res_Preg.
 * La clase pregunta queda determinada por un incrementador de id y de los atributos heredados: autor, contenido, votos a favor,
 * votos en contra, reportes, un estado ("Aceptada.", "Rechazada.", "Pendiente.") y una fecha de publicación.
 * @author Alma
 *
 */
public class Respuesta extends ComunResPreg {
	
	private static int count1 = 0; //Incrementador de id de la clase Respuesta.
	
	/**
	 * Crea una nueva respuesta a partir de el nombre del autor de la respuesta y su contenido.
	 * @param autor Nombre del usuario que es autor de la respuesta.
	 * @param contenido Contenido de la respuesta.
	 */
	public Respuesta(String autor, String contenido) {
		super(autor, contenido);
		setId(++count1); //El id único incremental se incrementa.
		setEstado("Pendiente."); //Al crear una pregunta su estado es "Pendiente."
	}
	
	/**Crea una nueva pregunta a partir de todos atributos a excepción de su id único y su fecha de publicación.
	 * @param autor Nombre del autor de la respuesta.
	 * @param contenido Contenido de la respuesta.
	 * @param estado Estado de la respuesta ("Aceptada.", "Rechazada.", "Pendiente.").
	 * @param votosAFavor Cantidad de votos a favor.
	 * @param votosEnContra Cantidad de votos en contra.
	 * @param reportes Cantidad de reportes. 
	 */
	public Respuesta(String autor, String contenido, String estado, int votosAFavor, int votosEnContra, int reportes) {
		super(autor, contenido, estado, votosAFavor, votosEnContra, reportes);
		setId(++count1); //El id único incremental se incrementa. 
	}


	/**
	 *Muestra una respuesta. 
	 */
	@Override
	public void mostrarComun() {
		
		System.out.println("ID Respuesta: "+getId());
		super.mostrarComun();	
		System.out.println("\n");
	}
	

}
