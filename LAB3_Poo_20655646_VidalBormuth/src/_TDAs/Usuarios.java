package _TDAs;

import java.util.List;
public class Usuarios {
	
	private List<Usuario> usuarios;
	private Usuario usuarioActivo;
	
	public Usuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
		this.usuarioActivo = null;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(Usuario usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}
	
	
	
	public void mostrarUsuarioActivo() {
		System.out.println("\nUsuario Activo:");
		if(usuarioActivo != null) {
			usuarioActivo.mostrarUsuario();
		}else {
			System.out.println("No existe usuario Activo.");
		}
	}
	public void mostrarUsuarios_Todos() {
		System.out.println("________________Usuarios__________________");
        for(Usuario user: usuarios){
            user.mostrarUsuario();
        }
	}

	public Usuario getUser_Name(String userName) {
		
		for(Usuario user: usuarios) {
			if(user.getName().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	public void agregarUsuario(Usuario user) {
		usuarios.add(user);
	}

}

