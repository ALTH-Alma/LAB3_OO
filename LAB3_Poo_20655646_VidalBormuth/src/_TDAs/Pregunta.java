package _TDAs;

import java.util.ArrayList;
import java.util.List;


public class Pregunta extends Comun_Res_Preg{
	
	private static int count2 = 0;
	private String titulo;
	private Recompensa recompensa;
	private Etiquetas etiquetas;
	private List<Respuesta> respuestas;

	public Pregunta(String autor, String titulo, String contenido, Etiquetas etiquetas) {
		super(autor, contenido);
		this.titulo = titulo;
		setEstado("Abierta.");
		this.etiquetas = etiquetas;
		respuestas = new ArrayList<Respuesta>();
		recompensa = new Recompensa();
		setId(++count2);
	}

	public Pregunta(String autor, String titulo, String contenido, Etiquetas etiquetas, String estado, int votosAFavor, 
			int votosEnContra, int reportes, Recompensa recompensa, List<Respuesta> respuestas) {
		super(autor, contenido, estado, votosAFavor, votosEnContra, reportes);
		this.titulo = titulo;
		this.recompensa = recompensa;
		this.etiquetas = etiquetas;
		this.respuestas = respuestas;
		setId(++count2);
	}


	public String getTitulo() {
		return titulo;
	}

	public Etiquetas getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Etiquetas etiquetas) {
		this.etiquetas = etiquetas;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	public Recompensa getRecompensa() {
		return recompensa;
	}
	
	public boolean mostrarRespuestas() {
        if(!respuestas.isEmpty()) {
	        for(Respuesta respuesta: respuestas){
	            respuesta.mostrarComun();  
	        }
	        return true;
        }else {
        	System.out.println("Aun no existen respuestas a esta pregunta.\n");
        	return false;
        }
	}
	
	public Respuesta getRespuesta_ID(int idRespuesta) {
		
        for(Respuesta respuesta: respuestas){
        	int idActual = respuesta.getId();
			if(idActual == idRespuesta) {
				return respuesta;
			}
        }
        return null;
	}
	
	@Override
	public void mostrarComun() {
		
		System.out.println("ID Pregunta: "+getId()+"\nTitulo: "+titulo);
		super.mostrarComun();
		System.out.println("Recompensa ofrecida: "+recompensa.getMontoRecompensa()+" puntos.");
		System.out.println("----Etiquetas---- ");
		etiquetas.mostrarEtiquetas();
		System.out.println("----Respuestas---- ");
		mostrarRespuestas();
	}

	
}

