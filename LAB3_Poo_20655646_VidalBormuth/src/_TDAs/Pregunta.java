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
		respuestas = new ArrayList<>();
		autorRecompensa = "No existe respuesta";
		montoRecompensa = 0;
		setId(++count2);
	}

}
