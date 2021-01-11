package _Menus;

import java.util.List;
import java.util.Scanner;

import Service.EtiquetasService;
import Service.MostrarListStackService;
import Service.StackService;
import _TDAs.Etiqueta;

public class MenuOpciones {
	
	private final StackService sService;
	private final Scanner entrada;
	
	public MenuOpciones(StackService sService, Scanner entrada) {
		this.sService = sService;
		this.entrada = entrada;
	} 
	 
	
	private void mostrarOpcion(String opcion) {
		System.out.println("A escogido la opción: "+opcion);
	}
	
	public void envolturaAsk() {
		mostrarOpcion("1. Agregar una nueva pregunta.");
		
		EtiquetasService eService = new EtiquetasService(sService.getStack().getEtiquetas());
		String aux1 = "", aux2 = "";
		
		eService.agregarNuevasEtiquetas();
		System.out.println("Por favor ingrese titulo de la pregunta:");
        aux1 = entrada.nextLine ();
		System.out.println("Por favor ingrese contenido de la pregunta:");
		aux2 = entrada.nextLine ();
		System.out.println("Por favor escoja etiquetas del stack para su pregunta:");
		List<Etiqueta> etiquetasPregunta = eService.seleccionarEtiquetas();	
		sService.ask(aux1, aux2, etiquetasPregunta);
		System.out.println("\n_________________Actualización___________________________");
	    sService.getStack().mostrarStack();
	}
	
	public void envolturaAnswer() {
		mostrarOpcion("2. Responder pregunta.");
		
		MostrarListStackService mService = new MostrarListStackService();
	    boolean confirma = mService.mostrarPreguntasAbiertas(sService.getStack().getPreguntas());
	    int idAux = 0;
	    String aux1 = "";
		if(confirma) {
				
			System.out.println("Por favor introduzca el ID correspondiente a la pregunta que desea responder."); 
			idAux = entrada.nextInt();
			System.out.println("Por favor ingrese el contenido de la respuesta."); 
		    aux1 = entrada.nextLine();
		    sService.answer(idAux, aux1);
			System.out.println("\n_________________Actualización___________________________");
		    sService.getStack().mostrarStack();
		}else { 
			System.out.println("#NO SE PUEDE REALIZAR ACCIÓN. No existen preguntas abiertas en stack.");
		}
	}
	
	public void envolturaReward() {
		mostrarOpcion("3. Ofrecer recompensa.");
		
		MostrarListStackService mService = new MostrarListStackService();
		boolean confirma = mService.mostrarPreguntasAbiertas(sService.getStack().getPreguntas());
		int idAux = 0, auxN = 0; 
		if(confirma) {
		
		    System.out.println("Por favor introduzca el ID correspondiente a la pregunta por la que desea entregar una recompensa."); 
			idAux = entrada.nextInt();
			System.out.println("Por favor ingrese el monto de la recompensa que desea entregar."); 
			auxN = entrada.nextInt();
			sService.reward(idAux, auxN);
			System.out.println("\n_________________Actualización___________________________");
		    sService.getStack().mostrarStack();
		        
		 }else {
			 System.out.println("#NO SE PUEDE REALIZAR ACCIÓN. No exiten preguntas abiertas en stack.");
		 }
	}
	
	public void envolturaAccept() {
		mostrarOpcion("4. Aceptar una respuesta.");
		
		MostrarListStackService mService = new MostrarListStackService();
		boolean confirma = mService.mostrarPreguntasAbiertas(sService.getStack().getPreguntas(),sService.getUsuarioActivo().getName());
		int idAux = 0, auxN = 0;
		if(confirma) {

	        System.out.println("Por favor introduzca el ID correspondiente a la pregunta a la que corresponde la respuesta que desea aceptar."); 
	        idAux = entrada.nextInt();
	        System.out.println("Por favor ingrese el ID de la respuesta."); 
	        auxN = entrada.nextInt();
	        sService.accept(idAux, auxN);
	        System.out.println("\n_________________Actualización___________________________");
		    sService.getStack().mostrarStack();
		}else { 
			System.out.println("\n#NO SE PUEDE REALIZAR ESTA ACCIÓN. Usted no tiene respuestas abiertas en este momento.\n");
		}
	}
	
	public void envolturaLogout() {
		mostrarOpcion("6. Cerrar sesión.");
		String aux1 = "", aux2 = "";
		System.out.println("Por favor ingrese nombre:");
        aux1 = entrada.nextLine ();
		System.out.println("Por favor ingrese contraseña:");
		aux2 = entrada.nextLine ();
        sService.logout(aux1, aux2);

	}
		
}
