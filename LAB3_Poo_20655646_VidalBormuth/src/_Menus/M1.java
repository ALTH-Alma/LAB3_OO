package _Menus;

import java.util.Scanner;

import _TDAs.Etiquetas;
import _TDAs.Stack;


public class M1{
	

	public static void menuMetodosStack(Stack stack) {
		
		Scanner sc = new Scanner(System.in);
		String nameUser = stack.getUsuarios().getUsuarioActivo().getName();
		boolean salir = false;
		int opcion;
		
		do{
			
			System.out.println("Menu inicial:");
			System.out.println("Usuario registrado: "+nameUser);
			System.out.println("Escoja su opción:");
			System.out.println("1. Agregar una nueva pregunta.");
			System.out.println("2. Responder pregunta.");
			System.out.println("3. Ofrecer recompensa.");
			System.out.println("4. Aceptar una respuesta.");
			System.out.println("5. Entregar un voto.");
			System.out.println("6. Cerrar sesión.");
				
			System.out.println("Ingrese de la opción deseada:");
			opcion= sc.nextInt();
				
			String aux1 = "";
			String aux2 = "";
			int idAux = 0;
			int auxN = 0;
			boolean confirma = false;
			Scanner aux = new Scanner (System.in); 
			Scanner aux_1 = new Scanner (System.in); 
				
			switch(opcion) {
				
				case 1: 
					
					stack.getEtiquetas().agregarNuevasEtiquetas();
					System.out.println("Por favor ingrese titulo de la pregunta:");
			        aux1 = aux.nextLine ();
					System.out.println("Por favor ingrese contenido de la pregunta:");
					aux2 = aux.nextLine ();
					System.out.println("Por favor escoja etiquetas del stack para su pregunta:");
					Etiquetas etiquetasPregunta = stack.getEtiquetas().seleccionarEtiquetas();
						
					stack.ask(aux1, aux2, etiquetasPregunta);	
					System.out.println("\n_________________Actualización___________________________");
				    stack.mostrarStack();
					break;
						
				case 2:

				    confirma = stack.getPreguntas().mostrarPreguntas_Abiertas();
					if(confirma) {
							
						System.out.println("Por favor introduzca el ID correspondiente a la pregunta que desea responder."); 
						idAux = aux.nextInt();
						System.out.println("Por favor ingrese el contenido de la respuesta."); 
					    aux1 = aux_1.nextLine();
					    stack.answer(idAux, aux1);
						System.out.println("\n_________________Actualización___________________________");
						stack.mostrarStack(); 
					}else { System.out.println("#NO SE PUEDE REALIZAR ACCIÓN. No existen preguntas abiertas en stack.");}
					break;
						
				case 3:
					
				      confirma = stack.getPreguntas().mostrarPreguntas_Abiertas();
				      if(confirma) {
		
					        System.out.println("Por favor introduzca el ID correspondiente a la pregunta por la que desea entregar una recompensa."); 
					        idAux = aux.nextInt();
					        System.out.println("Por favor ingrese el monto de la recompensa que desea entregar."); 
					        auxN = aux.nextInt();
					        stack.reward(idAux, auxN);
					        System.out.println("\n_________________Actualización___________________________");
				        	stack.mostrarStack();
					        
						}else { System.out.println("#NO SE PUEDE REALIZAR ACCIÓN. No exiten preguntas abiertas en stack.");}
				        break;
						
				case 4:
			 
			        confirma = stack.getPreguntas().mostrarPreguntasAbiertas_Usuario(nameUser);
					if(confirma) {
	
				        System.out.println("Por favor introduzca el ID correspondiente a la pregunta a la que corresponde la respuesta que desea aceptar."); 
				        idAux = aux.nextInt();
				        System.out.println("Por favor ingrese el ID de la respuesta."); 
				        auxN = aux.nextInt();
				        stack.accept(idAux, auxN);
				        System.out.println("\n_________________Actualización___________________________");
				        stack.mostrarStack();
					}else { System.out.println("\n#NO SE PUEDE REALIZAR ESTA ACCIÓN. Usted no tiene respuestas abiertas en este momento.\n");}
					break;
				case 5:
						break;
				case 6:
					System.out.println("Por favor ingrese nombre:");
			        aux1 = aux.nextLine ();
					System.out.println("Por favor ingrese contraseña:");
					aux2 = aux.nextLine ();
			        stack.logout(aux1, aux2);
			
					salir = true;
					break;
					
				default:
					
					salir = true;
					System.out.println("OPCIÓN INVALIDA");
						
			}
		}while(!salir);
	}
	
	
	
	
}
