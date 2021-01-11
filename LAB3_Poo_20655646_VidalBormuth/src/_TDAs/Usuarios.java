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
	

	public boolean register(String newUserName, String newPass) {
		Usuario usuario = getUser_Name(newUserName);
		if(usuario == null) {
			usuarios.add(new Usuario(newUserName, newPass));
			System.out.println("\nUsuario "+newUserName+" a sido registrado !!!");
			return true;
		}else {
			System.out.println("\nNOMBRE DE USUARIO EXISTENTE. Por favor, vuelva a intentar registrarse con un nuevo nombre de usuario.\n");
			return false;
		}
	}
	
	public boolean login(String userName, String userPass) {
		Usuario user = getUser_Name(userName);
		if(user == null) {
			System.out.println("\n#NOMBRE DE USUARIO INEXISTENTE");
			return false;
		}
		else if(user.getPass().equals(userPass) && usuarioActivo == null) {
			setUsuarioActivo(user); System.out.println("\n"+userName+" inicio sesión !!!");
			return true;
		}
		else {
		System.out.println("\n#CONTRASEÑA INCORRECTA");
		return false;
		}
	}
	
	public void logout(String userName, String userPass) {

		if(usuarioActivo != null && usuarioActivo.getName().equals(userName) && usuarioActivo.getPass().equals(userPass)) {
			setUsuarioActivo(null);
			System.out.println("El usuario "+userName+" a cerrado sesión !!!");
		}else {
		System.out.println("#NO EXISTE USUARIO ACTIVO PARA CERRAR SESIÓN.");
		}
	}
}

