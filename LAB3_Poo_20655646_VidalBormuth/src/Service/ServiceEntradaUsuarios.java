package Service;

import _TDAs.Stack;
import _TDAs.Usuario;

public class ServiceEntradaUsuarios {
	Stack stack;

	public ServiceEntradaUsuarios(Stack stack) {
		this.stack = stack;
	}
	
	private Usuario getUser(String userName) {
		
		for(Usuario user: stack.getUsuarios()) {
			if(user.getName().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	public boolean register(String newUserName, String newPass) {

		if(getUser(newUserName) == null) {
			stack.getUsuarios().add(new Usuario(newUserName, newPass));
			System.out.println("\nUsuario "+newUserName+" a sido registrado !!!");
			return true;
		}else {
			System.out.println("\nNOMBRE DE USUARIO EXISTENTE. Por favor, vuelva a intentar registrarse con un nuevo nombre de usuario.\n");
			return false;
		}
	}
	
	public Usuario login(String userName, String userPass) {
		Usuario user = getUser(userName);
		if(user == null) {
			System.out.println("\n#NOMBRE DE USUARIO INEXISTENTE");
			return null;
		}
		else if(user.getPass().equals(userPass)) {
			System.out.println("\n"+userName+" inicio sesión !!!");
			return user;
		}
		else {
		System.out.println("\n#CONTRASEÑA INCORRECTA");
		return null;
		}
	}
	
}
