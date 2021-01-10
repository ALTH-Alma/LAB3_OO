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
		System.out.println("Preguntas del Stack Overflow");
		if(!preguntas.isEmpty()) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta.")) {
					pregunta.mostrarComun();
					mostradas++;
				}
	        }
	        if(mostradas>0) {
	        return true;	
	        }
		}
		System.out.println("No existen preguntas abiertas en este stack");
		return false;
	}
	
	public void mostrarPreguntas_Todas() {
		System.out.println("_________________Preguntas__________________");
		if(!preguntas.isEmpty()) {
			for(Pregunta pregunta: preguntas){
            pregunta.mostrarComun();
            }
		}else {System.out.println("Aun no existen preguntas.");}  
	}
	
	public Pregunta getPreguntaStack_ID(int idPregunta) {
		
        for(Pregunta pregunta: preguntas){
        	int idActual = pregunta.getId();
			if(idActual == idPregunta) {
				return pregunta;
			}
        }
        return null;
	}

	
	public boolean mostrarPreguntasAbiertas_Usuario(String nombreAutor) {
		int mostradas = 0;
		System.out.println("Preguntas del usuario "+nombreAutor+":");
		if(!preguntas.isEmpty()) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta") && pregunta.getAutor().equals(nombreAutor)) {
					pregunta.mostrarComun();
					mostradas++;
				}
	        }
	        if(mostradas>0) {
	        return true;	
	        }
		}
		System.out.println("No existen preguntas abiertas en este stack\n");
		return false;
	}

}
