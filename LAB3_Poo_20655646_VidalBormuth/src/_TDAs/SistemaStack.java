package _TDAs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaStack {
	
	private List<Stack> stacks;

	public SistemaStack(List<Stack> stacks) {
		this.stacks = stacks;
	}
	
	public SistemaStack() {
		stacks = new ArrayList<>();
	}
	
	public boolean mostrarStacksSistema() {
		System.out.println("-----------------Sistema stack overflow----------------\n\nEsta es una lista de los stacks disponibles:");
		if(! stacks.isEmpty()) {
			for(int i=0;i<stacks.size();i++){
        	System.out.println((i+1)+") ");
            stacks.get(i).mostrarStack();
			}
			return true;
		}else {
			System.out.println("El sistema aun no posee ningun stack");
			return false;
		}
	}
	
	
	public Stack escogerStack() {
		
		boolean aux = mostrarStacksSistema();
	    String directorioRaiz = System.getProperty("user.dir");
	    System.out.println("Directorio de trabajo = " + directorioRaiz);
		if(aux) {
			Scanner sn = new Scanner(System.in);
			int opcionStack = 0;
			System.out.println("Por favor ingrese el número del stack al que desea acceder:");
			opcionStack= sn.nextInt();
			if(opcionStack > stacks.size()) {
				System.out.println("#EL STACK NO EXISTE");
				return null;
			}
			Stack seleccionado = stacks.get(opcionStack-1);
			return seleccionado;
			
		}
		System.out.println("\n#EL SISTEMA NO POSEE NINGUN STACK");
		return null;	
	}

	public boolean existenStack() {
		return (!stacks.isEmpty());
	}
	
}
