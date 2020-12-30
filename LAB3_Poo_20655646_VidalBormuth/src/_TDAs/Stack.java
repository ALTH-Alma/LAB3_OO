package _TDAs;

import java.util.List;

public class Stack {
	
	public Usuario usuarioActivo;
	public List<Usuario> usuarios;
	public List<Pregunta> preguntas;
	
	public Stack(List<Usuario> usuarios, List<Pregunta> preguntas) {
		this.usuarioActivo = null;
		this.usuarios = usuarios;
		this.preguntas = preguntas;
	}
	
	public Stack(Usuario usuarioA, List<Usuario> usuarios, List<Pregunta> preguntas) {
		this.usuarioActivo = usuarioA;
		this.usuarios = usuarios;
		this.preguntas = preguntas;
	}

	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(Usuario usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
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
	
	public void mostrarStack() {
		
		System.out.println("Stack Overflow:\n Usuario Activo:");
		//usuarioActivo.mostrarUsuario();
		
		System.out.println("Usuarios");
        for(int i=0;i<usuarios.size();i++){
            usuarios.get(i).mostrarUsuario();
        }
        
		System.out.println("Preguntas");
        for(int i=0;i<preguntas.size();i++){
            preguntas.get(i).mostrarComun();
        }
		
	}

}
