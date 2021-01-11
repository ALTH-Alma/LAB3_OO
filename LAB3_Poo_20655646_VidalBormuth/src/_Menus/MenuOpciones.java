package _Menus;

import java.util.List;
import java.util.Scanner;

import Service.EtiquetasService;
import Service.MostrarListStackService;
import Service.StackService;
import _TDAs.Etiqueta;

/**
 * Clase que permite encapsular a los metodos de stack, pidiendo sus parametros necesarios por consola e implementando los metodos 
 * de un stackService.
 * Esta clase queda determinada por un StackService.
 * @author Alma
 *
 */
public class MenuOpciones {
	
	private final StackService sService; //StackService;
	
	/**
	 * Crea un MenuOpciones en base a un StackService.
	 * @param sService StackService con los metodos que utiliza el stack.
	 */
	public MenuOpciones(StackService sService) {
		this.sService = sService;
	} 
	 
	
	/**
	 * Muestra por pantalla la opción del usuario.
	 * @param opcion Descripcion de la opción escogida.
	 */
	private void mostrarOpcion(String opcion) {
		System.out.println("A escogido la opción "+opcion);
	}
	
	/**
	 * Envuelve al metodo ask. Pide por consola el titulo de la pregunta, su contenido y etiquetas a agregar. Ademas, permite en un inicio agregar etiquetas
	 * en el stack, en caso de querer usar nuevas etiquetas en la pregunta a realizar. 
	 */
	public void envolturaAsk() {
		mostrarOpcion("1. Agregar una nueva pregunta."); //Se mensiona la opción.
		
		EtiquetasService eService = new EtiquetasService(sService.getStack().getEtiquetas());
		Scanner entrada, aux; entrada = new Scanner(System.in); aux = new Scanner(System.in);
		String aux1 = "", aux2 = "";
		
		eService.agregarNuevasEtiquetas(); //Se agregan nuevas etiquetas en caso de que el usuario crea.
		System.out.println("Por favor ingrese titulo de la pregunta:"); //Se solicitan y reciben las entradas para la nueva pregunta.
        aux1 = entrada.nextLine ();
		System.out.println("Por favor ingrese contenido de la pregunta:");
		aux2 = aux.nextLine ();
		System.out.println("Por favor escoja etiquetas del stack para su pregunta:");
		List<Etiqueta> etiquetasPregunta = eService.seleccionarEtiquetas();	 //Se crea una lista con las etiquetas seleccionadas por el usuario para la pregunta.
		sService.ask(aux1, aux2, etiquetasPregunta); //Se realiza la nueva pregunta. 
		System.out.println("\n_________________Actualización___________________________");
	    sService.getStack().mostrarStack(); //Se muestra el stack actualizado.
	}
	
	/**
	 * Envuelve al metodo answer. Pide por consola especificar el id de la pregunta que se quiere responder y el contenido de la respuesta. 
	 */
	public void envolturaAnswer() {
		mostrarOpcion("2. Responder pregunta.");
		
		MostrarListStackService mService = new MostrarListStackService();
	    boolean confirma = mService.mostrarPreguntasAbiertas(sService.getStack().getPreguntas()); //se muestran las preguntas Abiertas.
	    Scanner entrada, aux; entrada = new Scanner(System.in); aux = new Scanner(System.in);
	    int idAux = 0;
	    String aux1 = "";
		if(confirma) {
				
			System.out.println("Por favor introduzca el ID correspondiente a la pregunta que desea responder."); //Se solicitan y toman las entradas...
			idAux = entrada.nextInt();
			System.out.println("Por favor ingrese el contenido de la respuesta."); 
		    aux1 = aux.nextLine();
		    sService.answer(idAux, aux1); //Se realiza la respuesta a la pregunta. 
			System.out.println("\n_________________Actualización___________________________");
		    sService.getStack().mostrarStack(); //Se muestra el stack actualizado.
		}else { 
			System.out.println("#NO SE PUEDE REALIZAR ACCIÓN. No existen preguntas abiertas en stack.");
		}
	}
	
	/**
	 * Envuelve al metodo reward. Pide por consola el id de la pregunta por la que se quiere ofrecer una recompensa y el monto a ofrecer.
	 */
	public void envolturaReward() {
		mostrarOpcion("3. Ofrecer recompensa.");
		
		MostrarListStackService mService = new MostrarListStackService();
		boolean confirma = mService.mostrarPreguntasAbiertas(sService.getStack().getPreguntas()); //se muestran las preguntas abiertas.
		Scanner entrada = new Scanner(System.in);
		int idAux = 0, auxN = 0; 
		if(confirma) {
		
		    System.out.println("Por favor introduzca el ID correspondiente a la pregunta por la que desea entregar una recompensa."); //Se solicitan las entradas. 
			idAux = entrada.nextInt();
			System.out.println("Por favor ingrese el monto de la recompensa que desea entregar."); 
			auxN = entrada.nextInt();
			sService.reward(idAux, auxN); //Se realiza la recompensa.
			System.out.println("\n_________________Actualización___________________________");
		    sService.getStack().mostrarStack(); //Se muestra el satck actualizado.
		        
		 }else {
			 System.out.println("#NO SE PUEDE REALIZAR ACCIÓN. No exiten preguntas abiertas en stack.");
		 }
	}
	
	/**
	 * Envuelve al metodo accept. Pide por consola el id de la pregnta de la respuesta que se quiere aceptar y el id de la pregunta. 
	 */
	public void envolturaAccept() {
		mostrarOpcion("4. Aceptar una respuesta.");
		
		MostrarListStackService mService = new MostrarListStackService();
		//Se muestran las preguntas abiertas que el usuario puede aceptar.
		boolean confirma = mService.mostrarPreguntasAbiertas(sService.getStack().getPreguntas(),sService.getUsuarioActivo().getName());
		Scanner entrada = new Scanner(System.in);
		int idAux = 0, auxN = 0;
		if(confirma) {
			//Se solicitan entradas.
	        System.out.println("Por favor introduzca el ID correspondiente a la pregunta a la que corresponde la respuesta que desea aceptar."); 
	        idAux = entrada.nextInt();
	        System.out.println("Por favor ingrese el ID de la respuesta."); 
	        auxN = entrada.nextInt();
	        sService.accept(idAux, auxN); //Se acepta la respuesta.
	        System.out.println("\n_________________Actualización___________________________");
		    sService.getStack().mostrarStack(); //Se muestra el stack actualizado.
		}else { 
			System.out.println("\n#NO SE PUEDE REALIZAR ESTA ACCIÓN. Usted no tiene respuestas abiertas en este momento.\n");
		}
	}
	
	/**
	 * Envuelve al metodo logout. Pide por entrada el nombre del usuario activo y su contraseña
	 */
	public void envolturaLogout() {
		mostrarOpcion("6. Cerrar sesión.");
		Scanner entrada = new Scanner(System.in);
		String aux1 = "", aux2 = "";
		System.out.println("Por favor ingrese nombre:"); //Se solicitan y toman valores.
        aux1 = entrada.nextLine ();
		System.out.println("Por favor ingrese contraseña:");
		aux2 = entrada.nextLine ();
        sService.logout(aux1, aux2); //Se cierra sesión.

	}
		
}
