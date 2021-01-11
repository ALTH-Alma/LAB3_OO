package Service;

import java.util.List;

import _TDAs.Pregunta;
import _TDAs.Respuesta;
import _TDAs.Usuario;

public class MostrarListStackService {
	
	
	
	private boolean existenUsuarios(List<Usuario> usuarios){
		return (!usuarios.isEmpty() && usuarios != null);
	}
	
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
	
	
	private boolean existenRespuestas(List<Respuesta> respuestas){
		return (!respuestas.isEmpty() && respuestas != null);
	}
	
	//muestra todas respuestas
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

	
	//muestra respuestas que no sean de un determinado autor
	public boolean mostrarRespuestas(List<Respuesta> respuestas, String nameAutor) {
		int mostrar = 0;
        if(existenRespuestas(respuestas)) {
	        for(Respuesta respuesta: respuestas){
	        	if(!respuesta.getAutor().equals(nameAutor)) {
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
	
	
	private boolean existenPreguntas(List<Pregunta> preguntas){
		return (!preguntas.isEmpty() && preguntas != null);
	}
	
	//muestra todas preguntas
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
	
	//Muestra todas las preguntas abiertas.
	public boolean mostrarPreguntasAbiertas(List<Pregunta> preguntas) {
		int mostradas = 0;
		System.out.println("\n_________________PREGUNTAS ABIERTAS STACK_________________\n");
		if(existenPreguntas(preguntas)) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta.")) {
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
	
	
//Muestra las preguntas abiertas de un usuario. 
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
	
	
	public boolean mostrarPreguntasParaVotar(List<Pregunta> preguntas, String nombreAutor) {
		int mostradas = 0;
		System.out.println("\n____________________PREGUNTAS Y RESPUESTAS POR LAS QUE PUEDE VOTAR:_________________\n");
		if(existenPreguntas(preguntas)) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta.") && !pregunta.getAutor().equals(nombreAutor)) {
					System.out.println("------------------------------------------------");
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
