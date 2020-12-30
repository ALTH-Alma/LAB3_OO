package _TDAs;

import java.util.ArrayList;
import java.util.List;


public class Pregunta extends Comun_Res_Preg {
	
	private static int count2 = 0;
	public String titulo;
	public String autorRecompensa;
	public int montoRecompensa;
	public List<Etiqueta> etiquetas;
	public List<Respuesta> respuestas;

	public Pregunta(String autor, String titulo, String contenido, List<Etiqueta> etiquetas) {
		super(autor, contenido);
		this.titulo = titulo;
		this.estado = "Abierta";
		this.etiquetas = etiquetas;
		respuestas = new ArrayList<Respuesta>();
		autorRecompensa = "No existe ofertor aun";
		montoRecompensa = 0;
		setId(++count2);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutorRecompensa() {
		return autorRecompensa;
	}

	public void setAutorRecompensa(String autorRecompensa) {
		this.autorRecompensa = autorRecompensa;
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
		super.mostrarComun();
		
		System.out.println("Titulo: "+titulo);
		System.out.println("Recompensa: "+autorRecompensa+"\n"+montoRecompensa);
		
		System.out.println("Etiquetas: ");
        for(int i=0;i<etiquetas.size();i++){
            etiquetas.get(i).mostrarEtiqueta();
        }
        
        System.out.println("Respuestas: ");
        for(int i=0;i<respuestas.size();i++){
            respuestas.get(i).mostrarComun();
        }
		
		
	}

}
