
package _TDAs;

public class Usuario {

	// TODO Se define la clase usuario: cada usuario posee un nombre, una  contraseña y una reputación.
	private String name;
	private String pass;
	private int reputacion;
	
	//TODO se crea el constructor.
	
	public Usuario(String name, String pass) {
		this.name = name;
		this.pass = pass;
		this.reputacion = 0;
	}
	
	public Usuario(String name, String pass, int reputacion) {
		this.name = name;
		this.pass = pass;
		this.reputacion = reputacion;
	}

	//Getter y Setter para nombre de usuario.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Getter y Setter para contradeña del usuario.	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	//Getter y Setter para reputación del usuario.
	public int getReputacion() {
		return reputacion;
	}

	public void setReputacion(int reputacion) {
		this.reputacion = reputacion;
	}
	
	public void mostrarUsuario() {
		System.out.println("Nombre: "+name+"\nContraseña: "+pass+"\nReputación: "+reputacion+"\n");
	}

	public void agregarPuntosAReputacion(int monto) {
		reputacion = reputacion + monto;
	}


}
