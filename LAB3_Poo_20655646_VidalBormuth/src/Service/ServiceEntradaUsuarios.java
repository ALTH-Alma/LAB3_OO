package Service;

import _TDAs.Stack;
import _TDAs.Usuario;

/**
 * Clase que representa los servicios de entrada de usuarios en el stack.
 * Esta clase queda representada por un stack con el que se trabaja.
 * @author Alma
 *
 */
public class ServiceEntradaUsuarios {
	private final Stack stack; //Stack con el que se trabaja.

	/**
	 * Crea un ServicioEntradaUsuarios en base a un stack.
	 * @param stack Stack con el que se desea trabajar.
	 */
	public ServiceEntradaUsuarios(Stack stack) {
		this.stack = stack;
	}
	
	/**
	 * Permite encontrar y entregar un usuario en la lista de usuarios del stack según su nombre.
	 * @param userName Nombre del usuarios buscado.
	 * @return Usuario con el nombre de entrada. 
	 */
	private Usuario getUser(String userName) {
		
		for(Usuario user: stack.getUsuarios()) {//Recorre toda la lista de usuarios hasta encontrarlo.
			if(user.getName().equals(userName)) {
				return user; //Si lo encuentra retorna al usuario. 
			}
		}
		return null; //Si no lo encuentra retorna null.
	}
	
	/**
	 * Permite registrar a un usuario. Agrega un nuevo usuario en la lista de usuarios del stack, si 
	 * el nombre del nuevo de usuario del usuario que desea ingresar es diferentes a todos los nombres de usuarios en el stack.
	 * Si el nombre ya existe no hace nada.
	 * @param newUserName El nuevo nombre de usuario de la persona que desea registrarse. 
	 * @param newPass La nueva clave que se desea usar en el registro.
	 * @return un booleano, true si se logra registrar al usuario y false sino. 
	 */
	public boolean register(String newUserName, String newPass) {

		if(getUser(newUserName) == null) { //Si no se encontro un usuario con el nuevo nombre de usuario...
			stack.getUsuarios().add(new Usuario(newUserName, newPass)); //Se agrega el nuevo usuario.
			System.out.println("\nUsuario "+newUserName+" a sido registrado !!!");
			return true; // Si se registra retorna true.
		}else { //Sino no hace nada y anuncia que no se pudo registrar al usuario.
			System.out.println("\nNOMBRE DE USUARIO EXISTENTE. Por favor, vuelva a intentar registrarse con un nuevo nombre de usuario.\n");
			return false; //si no se registra retorna false.
		}
	}
	
	/**
	 * Permite a un usuario registrarse en un stack. Si se autentifican los datos del usuario, el usuario se entrega por esta 
	 * funcion y pasa a ser el usuario activo en el menu que permite realizar cambios dentro de stack.
	 * @param userName Nombre del usuario que desea ingresar.
	 * @param userPass Contraseña del usuario.
	 * @return El usuario que inicia sesión, si no se inicia sesión retorna vacio.
	 */
	public Usuario login(String userName, String userPass) {
		Usuario user = getUser(userName); //Se obtiene al usuario con el nombre.
		if(user == null) { //Si el usuario no existe.
			System.out.println("\n#NOMBRE DE USUARIO INEXISTENTE"); //Nombre incorrecto.
			return null; //Retorna vacio.
		}
		else if(user.getPass().equals(userPass)) { //Si se encontro el usuario y la su clave coincide con la ingresada...
			System.out.println("\n"+userName+" inicio sesión !!!"); //Se inicia sesión.
			return user; //Se retorna el usuario.
		}
		else {
		System.out.println("\n#CONTRASEÑA INCORRECTA");// Si la clave no coincidia. Clave incorrecta.
		return null; //Retorna vacio.
		}
	}
	
}
