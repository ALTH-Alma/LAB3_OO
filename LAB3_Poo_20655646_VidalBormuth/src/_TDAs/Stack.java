package _TDAs;

import java.util.List;

public class Stack {
	
	private Usuario usuarioActivo;
	private List<Usuario> usuarios;
	private List<Pregunta> preguntas;
	
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
		
		System.out.println("Stack Overflow:\n\n Usuario Activo:");
		if(usuarioActivo != null) {
			usuarioActivo.mostrarUsuario();
		}
		
		System.out.println("Usuarios");
        for(int i=0;i<usuarios.size();i++){
            usuarios.get(i).mostrarUsuario();
        }
        
//		System.out.println("Preguntas");
//        for(int i=0;i<preguntas.size();i++){
//            preguntas.get(i).mostrarComun();
//        }
		
	}
	
	private Usuario getUser(String newUserName) {
		
		for(Usuario user: usuarios) {
			if(user.getName().equals(newUserName)) {
				return user;
			}
		}
		return null;
	}
	
	public void register(String newUserName, String newPass) {
		Usuario user = getUser(newUserName);
		if(user == null) {
			Usuario newUser = new Usuario(newUserName, newPass);
			usuarios.add(newUser);
		}
	}
	
	public void login(String userName, String userPass) {
		Usuario user = getUser(userName);
		if(user == null) {
			System.out.println("Nombre de usuario inexistente");
		}
		else if(user.getPass().equals(userPass) && usuarioActivo == null) {
			usuarioActivo = user;
			System.out.println("Se inicio sesion");
		}else {
		System.out.println("Contraseña incorrecta");
		}
	}
	
	public void logout(String userName, String userPass) {
		if(usuarioActivo != null && usuarioActivo.getName().equals(userName) && usuarioActivo.getPass().equals(userPass)) {
			usuarioActivo = null;
			System.out.println("El usuario ah cerrado sesión.");
		}else {
		System.out.println("No existe usuario activo para cerrar sesión.");
		}
	}

}
