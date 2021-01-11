package Service;


import java.util.List;
import java.util.Scanner;

import _TDAs.Stack;

/**
 * Clase externa de stack, sirve para almacenar diferentes stack y poder seleccionar uno con el cual trabajar.
 * Esta clase queda definido por una lista de stacks. 
 * @author Alma
 *
 */
public class SistemaStack {
	
	private List<Stack> stacks; //Lista de stacks.

	/**
	 * Crea un sistemaStack a partir de una lista de stack.
	 * @param stacks Lista de stacks.
	 */
	public SistemaStack(List<Stack> stacks) {
		this.stacks = stacks;
	}
	
	/**
	 * Permite agregar un stack al sistema. 
	 * @param stack Nuevo stack a agregar.
	 */
	public void addStack(Stack stack) {
		stacks.add(stack);
	}
	
	
	/**
	 * Muestra los stacks del sistema si es que existen. 
	 * @return Un boolean, true si se pudieron mostrar los stack (Existen stacks) y false sino.
	 */
	public boolean mostrarStacksSistema() {
		System.out.println("\n-----------------Sistema stack overflow----------------\n\nEsta es una lista de los stacks disponibles:");
		if(!stacks.isEmpty() && stacks != null) {
			for(int i=0;i<stacks.size();i++){
        	System.out.println("\n"+(i+1)+") ");
            stacks.get(i).mostrarStack();
			}
			return true;
		}else {
			System.out.println("El sistema aun no posee ningun stack");
			return false;
		}
	}
	
	
	/**
	 * Permite escoger por consola un stack con el que se desea trabajar.
	 * @return El stack escoguido. 
	 */
	public Stack escogerStack() {
		
		boolean aux = mostrarStacksSistema(); //Se muestran los stacks a escoger.
		
		if(aux) { //Si se mostraron los stacks.
			Scanner sn = new Scanner(System.in);
			System.out.println("Por favor ingrese el número del stack al que desea acceder:");
			int opcionStack= sn.nextInt(); //Permite escoger uno.
			while(opcionStack > stacks.size()) { //Si el seleccionado no existe, pide denuevo la entrada. 
				System.out.println("#EL STACK NO EXISTE. Por favor seleccione un stack existente.");
				opcionStack= sn.nextInt();
			}
			return stacks.get(opcionStack-1); //Entrega el stack seleccionado.
		}
		return null; //Si no existian stacks retorna null.	
	}

	
}
