package _TDAs;

import java.util.ArrayList;
import java.util.List;


public class Pregunta extends Comun_Res_Preg implements IMostrarEtiqueta{
	
	private static int count2 = 0;
	private String titulo;
	private int montoRecompensa;
	private List<String> ofertores;
	private List<Integer> montosOfrecidosRetenidos;
	private List<Etiqueta> etiquetas;
	private List<Respuesta> respuestas;

	public Pregunta(String autor, String titulo, String contenido, List<Etiqueta> etiquetas) {
		super(autor, contenido);
		setTitulo(titulo);
		setEstado("Abierta.");
		this.etiquetas = etiquetas;
		respuestas = new ArrayList<Respuesta>();
		ofertores = new ArrayList<>();
		montosOfrecidosRetenidos = new ArrayList<>();
		montoRecompensa = 0;
		setId(++count2);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getMontoRecompensa() {
		return montoRecompensa;
	}

	public void setMontoRecompensa(int montoRecompensa) {
		this.montoRecompensa = montoRecompensa;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	@Override
	public boolean mostrarEtiquetas() {
		if(!etiquetas.isEmpty()) {
	        for(Etiqueta etiqueta: etiquetas){
	            etiqueta.mostrarEtiqueta();
	        }
	        return true;
		}else {
			System.out.println("No existen etiquetas.");
			return false;
		}
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
	
	@Override
	public void mostrarComun() {
		
		System.out.println("ID Pregunta: "+getId()+"\nTitulo: "+titulo);
		super.mostrarComun();
		System.out.println("Recompensa ofrecida: "+montoRecompensa+" puntos.");
		System.out.println("----Etiquetas---- ");
		mostrarEtiquetas();
		System.out.println("----Respuestas---- ");
		mostrarRespuestas();
	}

	public void setRecompensa(int montoNewRecompensa, String autorRecompensa) {
		ofertores.add(autorRecompensa);
		montosOfrecidosRetenidos.add(montoNewRecompensa);
		montoRecompensa = montoRecompensa + montoNewRecompensa;
			
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

	public int tomarRecompensa() {
		if(ofertores.isEmpty()) {
			return 0; //no existe recompensa.
			
		}else {
			ofertores.clear();
			montosOfrecidosRetenidos.clear();
			int aux= montoRecompensa;
			montoRecompensa = 0;
			return aux;
		}
	}
	
}

