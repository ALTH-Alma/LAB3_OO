package _TDAs;

import java.util.ArrayList;
import java.util.List;


public class Pregunta extends Comun_Res_Preg {
	
	private static int count2 = 0;
	private String titulo;
	private int montoRecompensa;
	private List<String> ofertores;
	private List<Integer> montosOfrecidosRetenidos;
	private List<Etiqueta> etiquetas;
	private List<Respuesta> respuestas;

	public Pregunta(String autor, String titulo, String contenido, List<Etiqueta> etiquetas) {
		super(autor, contenido);
		this.titulo = titulo;
		this.estado = "Abierta";
		this.etiquetas = etiquetas;
		respuestas = new ArrayList<Respuesta>();
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
	public void mostrarComun() {
		
		System.out.println("ID Pregunta: "+id);
		System.out.println("Titulo: "+titulo);
		super.mostrarComun();
		System.out.println("Recompensa ofrecida: "+montoRecompensa+" puntos.");
		
		System.out.println("Etiquetas: ");
        for(int i=0;i<etiquetas.size();i++){
            etiquetas.get(i).mostrarEtiqueta();
        }
        
        System.out.println("Respuestas: ");
        for(int i=0;i<respuestas.size();i++){
            respuestas.get(i).mostrarComun();
        }	
	}

	
	public void setRecompensa(int montoNewRecompensa, String autorRecompensa) {
		if(ofertores == null) {
			ofertores = new ArrayList<>();
			montosOfrecidosRetenidos = new ArrayList<>();
		}
		ofertores.add(autorRecompensa);
		montosOfrecidosRetenidos.add(montoNewRecompensa);
		montoRecompensa = montoRecompensa + montoNewRecompensa;
			
	}
}
