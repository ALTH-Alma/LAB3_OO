package _TDAs;

import java.util.ArrayList;
import java.util.List;

public class Preguntas {

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

	public boolean mostrarPreguntasStack() {
		int mostradas = 0;
		System.out.println("Preguntas del Stack Overflow");
		if(preguntas != null) {
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
	
	public Pregunta getPreguntaStack_ID(int idPregunta) {
		
        for(Pregunta pregunta: preguntas){
        	int idActual = pregunta.getId();
			if(idActual == idPregunta) {
				return pregunta;
			}
        }
        return null;
	}

}
