package _TDAs;

import java.util.ArrayList;
import java.util.List;

public class Preguntas{

	private List<Pregunta> preguntas;

	public Preguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Preguntas() {
		preguntas = new ArrayList<>();
	}
	
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public void agregarPregunta(Pregunta pregunta) {
		preguntas.add(pregunta);
	}
	
	public boolean existenPreguntas() {
		return preguntas.isEmpty();
	}

	public boolean mostrarPreguntas_Abiertas() {
		int mostradas = 0;
		System.out.println("\n_________________PREGUNTAS ABIERTAS STACK_________________\n");
		if(!preguntas.isEmpty()) {
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
	
	public void mostrarPreguntas_Todas() {
		System.out.println("\n___________________PREGUNTAS STACK____________________\n");
		if(!preguntas.isEmpty()) {
			for(Pregunta pregunta: preguntas){
				System.out.println("------------------------------------------------");
				pregunta.mostrarComun();
            }
		}else {System.out.println("\nAun no existen preguntas.\n");}  
	}
	
	public Pregunta getPreguntaStack_ID(int idPregunta) {
		
        for(Pregunta pregunta: preguntas){
			if(pregunta.getId() == idPregunta) {
				return pregunta;
			}
        }
        return null;
	}

	public boolean mostrarPreguntasAbiertas_Usuario(String nombreAutor) {
		int mostradas = 0;
		System.out.println("\n____________________PREGUNTAS USUARIO "+nombreAutor+":_________________\n");
		if(!preguntas.isEmpty()) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta") && pregunta.getAutor().equals(nombreAutor)) {
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
	
	public boolean mostrarPreguntasAbiertas_NoUsuario(String nombreAutor) {
		int mostradas = 0;
		System.out.println("\n____________________PREGUNTAS Y RESPUESTAS POR LAS QUE PUEDE VOTAR:_________________\n");
		if(!preguntas.isEmpty()) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta") && !pregunta.getAutor().equals(nombreAutor)) {
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
