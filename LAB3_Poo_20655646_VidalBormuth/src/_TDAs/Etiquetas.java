package _TDAs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Etiquetas {

	private List<Etiqueta> etiquetas;

	public Etiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
	public Etiquetas() {
		etiquetas = new ArrayList<>();
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	public boolean mostrarEtiquetas() {
		if(!etiquetas.isEmpty()) {
	        for(int i=0;i<etiquetas.size();i++){
				System.out.println((i+1)+")");
	            etiquetas.get(i).mostrarEtiqueta();
	        }
	        return true;
		}else {
			System.out.println("No existen etiquetas.");
			return false;
		}
	}
	
	public void agregarEtiquetaPorConsola(){
		
		Scanner seleccion = new Scanner(System.in);
		String aux = "";
		String aux1 = "";

		System.out.println("Por favor introduzca el nombre de la nueva etiqueta:");
		aux = seleccion.nextLine();
		System.out.println("Por favor introduzca la descripción de la nueva etiqueta:");
		aux1 = seleccion.nextLine();
		etiquetas.add(new Etiqueta(aux, aux1));
	}
	
	public void agregarNuevasEtiquetas() {
		
		Scanner seleccion = new Scanner(System.in);
			
		System.out.println("Etiquetas en Stack");
		mostrarEtiquetas();
		int auxV = 0;
			
		System.out.println("¿Desea agregar una nueva etiqueta en el stack antes de crear una pregunta?. "
						+ "Si su respuesta es 'si' por favor introduzca un 1. Si es 'no' introduzca un 2.");
		auxV = seleccion.nextInt();
		while(auxV != 1 && auxV != 2) {
			auxV = seleccion.nextInt();
		}
		while(auxV == 1) {
			auxV = 0;
			agregarEtiquetaPorConsola();
			System.out.println("¿Desea agregar otra etiqueta?. Si su respuesta es 'si' por favor introduzca un 1. Si es 'no' introduzca un 2.");
			while(auxV != 1 && auxV != 2) {
				auxV = seleccion.nextInt();
			}
		}
			
	}
	
	public Etiquetas seleccionarEtiquetas(){
		
		Scanner seleccion = new Scanner(System.in);
			
		System.out.println("Etiquetas en Stack");
		boolean aux = mostrarEtiquetas();
		List<Etiqueta> newList; 
		newList = new ArrayList<>();
		    
		if(aux) {  
		    System.out.println("Por favor introduzca el o los números de a uno, correspondientes a la etiqueta que desea agregar. Para finalizar la elección introduzca un 0.");
	        int numero = seleccion.nextInt();
		    while(numero != 0){	
		       newList.add(this.etiquetas.get(numero-1));
		       numero = seleccion.nextInt();	
		    }
		}
			
		Etiquetas etiquetasFinal = new Etiquetas(newList);
		return etiquetasFinal;
		
	}
	

	

}
