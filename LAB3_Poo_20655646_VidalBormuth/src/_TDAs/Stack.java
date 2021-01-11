package _TDAs;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un stack.
 * Esta clase esta determinada por 
 * @author Alma
 *
 */
public class Stack  {
	
	private static int count3 = 0;
	private int idStack;
	private List<Usuario> usuarios;
	private List<Pregunta> preguntas;
	private List<Etiqueta> etiquetas;
	
	public Stack(List<Usuario> usuarios, List<Pregunta> preguntas, List<Etiqueta> etiquetas) {
		this.usuarios = usuarios;
		this.preguntas = preguntas;
		this.etiquetas = etiquetas;
		setIdStack(++count3);
	}
	public Stack() {
		usuarios = new ArrayList<>();
		preguntas = new ArrayList<>();
		etiquetas = new ArrayList<>();
	}

	public int getIdStack() {
		return idStack;
	}
	public void setIdStack(int idStack) {
		this.idStack = idStack;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
	public void mostrarStack() {
		
		System.out.println("Stack Overflow "+idStack);
		usuarios.mostrarUsuarios() por crear
		preguntas.mostrarPreguntas()
		
	}

	
	


	
}

