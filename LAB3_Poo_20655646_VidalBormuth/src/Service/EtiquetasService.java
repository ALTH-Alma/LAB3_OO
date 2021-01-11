package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _TDAs.Etiqueta;


public class EtiquetasService {

	private List<Etiqueta> etiquetas;

	public EtiquetasService(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}


	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	private boolean existenEtiquetas() {
		return (!etiquetas.isEmpty() && etiquetas != null);
	}
	
	public void mostrarEtiquetas() {
		if(existenEtiquetas()) {
	        for(int i=0;i<etiquetas.size();i++){
				System.out.println((i+1)+")");
	            etiquetas.get(i).mostrarEtiqueta();
	        }
		}else {
			System.out.println("No posee etiquetas.");
		}
	}
	
	private void agregarEtiquetaPorConsola(){
		
		Scanner seleccion, auxS; seleccion = new Scanner(System.in); auxS = new Scanner(System.in);
		String aux = "";
		String aux1 = "";

		System.out.println("Por favor introduzca el nombre de la nueva etiqueta:");
		aux = seleccion.nextLine();
		System.out.println("Por favor introduzca la descripción de la nueva etiqueta:");
		aux1 = auxS.nextLine();
		etiquetas.add(new Etiqueta(aux, aux1));
	}
	
	public void agregarNuevasEtiquetas() {
		
		Scanner seleccion = new Scanner(System.in);
			
		System.out.println("\nEtiquetas para seleccionar:");
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
	
	public List<Etiqueta> seleccionarEtiquetas(){
		
		Scanner seleccion = new Scanner(System.in);
			
		System.out.println("Etiquetas en Stack");
		mostrarEtiquetas();
		List<Etiqueta> newList; newList = new ArrayList<>();
		    
		if(existenEtiquetas()) {  
		    System.out.println("Por favor introduzca el o los números de a uno, correspondientes a la etiqueta que desea agregar. Para finalizar la elección introduzca un 0.");
	        int numero = seleccion.nextInt();
		    while(numero != 0){	
		       newList.add(this.etiquetas.get(numero-1));
		       numero = seleccion.nextInt();	
		    }
		}else {
			System.out.println("No pueden agregar etiquetas.");
		}
			
		return newList;
		
	}
}
