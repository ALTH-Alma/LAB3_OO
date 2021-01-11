package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _TDAs.Etiqueta;


/**
 * Clase que representa los servicios o aplicaciones que brinda una lista de etiquetas.
 * Esta clase queda determinada por una lista de etiquetas.
 * @author Alma
 *
 */
public class EtiquetasService {

	private List<Etiqueta> etiquetas; //Lista de etiquetas.

	/**
	 * Crea la clase EtiquetasService a partir de una lista de etiquetas. 
	 * @param etiquetas Lists de etiquetas a las que se le aplicaran los servicios. 
	 */
	public EtiquetasService(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	/**
	 * Entrega la lista de etiquetas con la que se trabaja.
	 * @return Lista de etiquetas. 
	 */
	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	/**
	 * Permite determinara si la lista con la que se trabaja tienen etiquetas o no.
	 * @return Un boolean, un true si existen etiquetas en la lista y un false si no.
	 */
	private boolean existenEtiquetas() {
		return (!etiquetas.isEmpty() && etiquetas != null);
	}
	
	/**
	 * Permite mostrar una lista de etiquetas si es que existen, sino lo informa.
	 */
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
	
	/**
	 * Permite solicitar por consola una nueva etiqueta y agregarla a la lista de etiquetas.
	 * Solitada y recibe las entrada, crea la nueva etiqueta y la agrega a la lista.
	 */
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
	
	/**
	 * Permite agregar nuevas etiquetas por consola.
	 * Utiliza la función agregarEtiquetasPorConsola en un ciclo.
	 */
	public void agregarNuevasEtiquetas() {
		
		Scanner seleccion = new Scanner(System.in);
			
		System.out.println("\nEtiquetas para seleccionar:");
		mostrarEtiquetas(); //Muestra las etiquetas ya existentes.
		int auxV = 0;
			
		System.out.println("¿Desea agregar una nueva etiqueta en el stack antes de crear una pregunta?. "
						+ "Si su respuesta es 'si' por favor introduzca un 1. Si es 'no' introduzca un 2."); //Consulta si se desea agregar una nueva etiqueta.
		auxV = seleccion.nextInt();
		while(auxV != 1 && auxV != 2) { //Si la opción ingresada no es concordante con los datos se vuelve a pedir la entrada.
			auxV = seleccion.nextInt();
		}
		while(auxV == 1) { //Si se desea agregar etiquetas, se entra en un ciclo. 
			auxV = 0;
			agregarEtiquetaPorConsola(); //Se agrega la etiqueta.
			System.out.println("¿Desea agregar otra etiqueta?. Si su respuesta es 'si' por favor introduzca un 1. Si es 'no' introduzca un 2.");
			while(auxV != 1 && auxV != 2) { //se vuelve a pedir entrada mientras las entradas concuerden con los datos.
				auxV = seleccion.nextInt();
			}
		}//Una vez que se ingresa un 0 se termina la función. 
			
	}
	
	/**
	 * Permite seleccionar una lista de etiquetas de todas las etiquetas del stack por consola.
	 * @return Lista con las etiquetas seleccionadas.
	 */
	public List<Etiqueta> seleccionarEtiquetas(){
		
		Scanner seleccion = new Scanner(System.in);
			
		System.out.println("Etiquetas en Stack");
		mostrarEtiquetas(); //Se muestran las etiquetas.
		List<Etiqueta> newList; newList = new ArrayList<>(); //Se crea una lista vacia.
		    
		if(existenEtiquetas()) {  //Si existen etiquetas...
		    System.out.println("Por favor introduzca el o los números de a uno, correspondientes a la etiqueta que desea agregar. Para finalizar la elección introduzca un 0.");
	        int numero = seleccion.nextInt(); //Se piden los números correspondientes a las etiquetas y se van a gregando hasta que se ingrese un 0.
		    while(numero != 0 && numero<=etiquetas.size() ){	
		       newList.add(etiquetas.get(numero-1));
		       numero = seleccion.nextInt();	
		    }
		}else {
			System.out.println("No puede agregar etiquetas."); //Si no existen etiquetas se informa.
		}
			
		return newList; //Se retorna la lista de etiquetas creada. 
		
	}
}
