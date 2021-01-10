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
		if(aux) {
			Scanner sn = new Scanner(System.in);
			int opcionStack = 0;
			System.out.println("Por favor ingrese el número del stack al que desea acceder:");
			opcionStack= sn.nextInt();
			Stack seleccionado = stacks.get(opcionStack-1);
			if(seleccionado != null) {
				return seleccionado;
			}
		}
		
		System.out.println("El stack no existe.");
		return null;	
	}

	public boolean existenStack() {
		return (!stacks.isEmpty());
	}
	
}
