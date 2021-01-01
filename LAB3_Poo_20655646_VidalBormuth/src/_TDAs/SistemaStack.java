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
	
	public Stack escogerStack() {
		
		Scanner sn = new Scanner(System.in);
		int opcionStack;
		System.out.println("--------------------Sistema stack overflow----------------");
		System.out.println("Esta es una lista de los stacks disponibles:");
        for(int i=0;i<stacks.size();i++){
        	System.out.println(i+1+". ");
            stacks.get(i).mostrarStack();
        }
        
		System.out.println("Ingrese el número del stack que prefiera");
		opcionStack= sn.nextInt();
		return stacks.get(opcionStack-1);
	}

}
