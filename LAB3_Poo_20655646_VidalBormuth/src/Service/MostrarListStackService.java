package Service;

import java.util.List;

import _TDAs.Pregunta;
import _TDAs.Respuesta;
import _TDAs.Usuario;

/**
 * Clase que permite representar los servicios mostrar en el stack. Permite mostrar sus listas de preguntas, respuestas, usuarios
 *  y etiquetas, y algunas funciones complementos. 
 * @author Alma
 *
 */
public class MostrarListStackService {

	
	/**
	 * Permite saber si una lista de usuarios esta vacia.
	 * @param usuarios Lista de usuarios.
	 * @return un true si la lista no esta vacia y un false si lo esta.
	 */
	private boolean existenUsuarios(List<Usuario> usuarios){
		return (!usuarios.isEmpty() && usuarios != null);
	}
	
	/**
	 * Muestra todos los usuarios de una lista si es que existen.
	 * @param usuarios Lista de usuarios.
	 */
	public void mostrarUsuarios(List<Usuario> usuarios) {
		if(existenUsuarios(usuarios)) {
			System.out.println("________________Usuarios__________________");
			for(Usuario user: usuarios){
				user.mostrarUsuario();
			}
		}else {
			System.out.println("No existen usuarios.");
		}

	}
	
	
	/**
	 * Permite saber si una lista de respuestas esta vacia.
	 * @param respuestas Lista de respuestas.
	 * @return true si la lista no esta vacia y false si lo esta. 
	 */
	private boolean existenRespuestas(List<Respuesta> respuestas){
		return (!respuestas.isEmpty() && respuestas != null);
	}
	
	
	/**
	 * Muestra todas las respuestas de la lista de respuestas de una pregunta. 
	 * @param respuestas Lista de respuestas.
	 * @return Un true si se mostraron respuestas y un false si no. 
	 */
	public boolean mostrarRespuestas(List<Respuesta> respuestas) {
        if(existenRespuestas(respuestas)) {
	        for(Respuesta respuesta: respuestas){
	        	System.out.println("------------------");
	            respuesta.mostrarComun();  
	        }
	        return true;
        }else {
        	System.out.println("Aun no existen respuestas a esta pregunta.\n");
        	return false;
        }
	}

	
	
	/**
	 * Muestra todas las respuestas de una pregunta que no sean de un determinado autor.
	 * @param respuestas Lista de respuestas. 
	 * @param nameAutor Nombre del autor cuyas respuestas no se deben mostrar.
	 * @return True si se mostraron respuestas y false si no. 
	 */
	public boolean mostrarRespuestas(List<Respuesta> respuestas, String nameAutor) {
		int mostrar = 0;
        if(existenRespuestas(respuestas)) {
	        for(Respuesta respuesta: respuestas){
	        	if(!respuesta.getAutor().equals(nameAutor)) { //Si el autor no corresponde al nombre ingresado se muestra. 
	        		System.out.println("------------------");
	        		respuesta.mostrarComun(); 
	        		mostrar ++;
	        	}
	        }
	        if(mostrar != 0) {
	        	return true;
	        }
	        return false;
        }else {
        	System.out.println("No hay respuestas para votar.\n");
        	return false;
        }
	}
	
	
	/**
	 * Permite determinar si una lista de preguntas esta vacia. 
	 * @param preguntas Lista de preguntas.
	 * @return True si la lista de no esta vacia y false si lo esta. 
	 */
	private boolean existenPreguntas(List<Pregunta> preguntas){
		return (!preguntas.isEmpty() && preguntas != null);
	}
	
	
	/**
	 * Muestra todas la preguntas de una lista de preguntas.
	 * @param preguntas Lista de preguntas.
	 * @return True si se mostraron preguntas y false si no. 
	 */
	public boolean mostrarPreguntas(List<Pregunta> preguntas) {
		System.out.println("\n___________________PREGUNTAS STACK____________________\n");
        if(existenPreguntas(preguntas)) {
	        for(Pregunta pregunta: preguntas){
	        	System.out.println("------------------------------------------------");
	            pregunta.mostrarComun();  
	        }
	        return true;
        }else {
        	System.out.println("Aun no existen preguntas.\n");
        	return false;
        }
	}
	
	
	/**
	 * Muestra todas la preguntas abiertas de una lista de preguntas.
	 * @param preguntas Lista de preguntas.
	 * @return True si se mostraron preguntas y false si no. 
	 */
	public boolean mostrarPreguntasAbiertas(List<Pregunta> preguntas) {
		int mostradas = 0;
		System.out.println("\n_________________PREGUNTAS ABIERTAS STACK_________________\n");
		if(existenPreguntas(preguntas)) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta.")) { //Si el estado de la pregunta es abierto, se muestra. 
					System.out.println("------------------------------------------------");
					pregunta.mostrarComun();
					mostradas++;
				}
	        }
	        if(mostradas>0) {
	        return true;	
	        }
		}
		System.out.println("\nNo existen preguntas abiertas en este stack\n");
		return false;
	}
	
	
	/**
	 * Muestra todas la preguntas abiertas de determinado autor, de una lista de preguntas.
	 * @param preguntas Lista de preguntas.
	 * @param nombreAutor Nombre del autor de las preguntas que se quieren mostrar. 
	 * @return True si se mostraron preguntas y false si no. 
	 */
	public boolean mostrarPreguntasAbiertas(List<Pregunta> preguntas, String nombreAutor) {
		int mostradas = 0;
		System.out.println("\n____________________PREGUNTAS USUARIO "+nombreAutor+":_________________\n");
		if(existenPreguntas(preguntas)) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta.") && pregunta.getAutor().equals(nombreAutor)) {
					System.out.println("------------------------------------------------");
					pregunta.mostrarComun();
					mostradas++;
				}
	        }
	        if(mostradas>0) {
	        return true;	
	        }
		}
		System.out.println("\n#EL USUARIO NO POSEE PREGUNTAS ABIERTAS.#\n");
		return false;
	}
	
	
	/**
	 * Muestra una lista de preguntas abiertas por las que un usuario puede votar, 
	 * ninguna de las preguntas y respuestas mostradas pertenecen al autor del nombre ingresado. 
	 * @param preguntas Lista de preguntas.
	 * @param nombreAutor Nombre del autor del cual no apareceran preguntas o respuestas. 
	 * @return true si se mostraron preguntas y false si no. 
	 */
	public boolean mostrarPreguntasParaVotar(List<Pregunta> preguntas, String nombreAutor) {
		int mostradas = 0;
		System.out.println("\n____________________PREGUNTAS Y RESPUESTAS POR LAS QUE PUEDE VOTAR:_________________\n");
		if(existenPreguntas(preguntas)) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta.") && !pregunta.getAutor().equals(nombreAutor)) { 
					System.out.println("------------------------------------------------");//Si la pregunta esta abierta y no es del autor del nombre ingresado se muestra.
					pregunta.mostrarComun(nombreAutor);
					mostradas++;
				}
	        }
	        if(mostradas>0) {
	        return true;	
	        }
		}
		System.out.println("\n#NO HAY PREGUNTAS ABIERTAS PARA VOTAR.#\n");
		return false;
	}
	
	
	
	
	
}
