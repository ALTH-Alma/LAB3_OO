package _Desarrollo;

import _TDAs.Usuario;

public class MetodosUsuario {

	public static void main(String[] args) {
		// TODO Pruebas
		
		Usuario alma= new Usuario("Alma", "Alma1234", 20);
		System.out.println("El nombre del usuario 1 es: " + alma.getName());
		System.out.println("La contraseña del usuario es: " + alma.getPass());
		System.out.println("La reputación del usuario es: " + alma.getReputacion());
		
		alma.setReputacion(alma.getReputacion() + 25);
		
		System.out.println(alma.getReputacion());

	}

}
