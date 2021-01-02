package _Menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Respuesta;
import _TDAs.SistemaStack;
import _TDAs.Stack;
import _TDAs.Usuario;

public class M1 implements MenuMetodos{
	

	public void menuMetodosStack(Stack stack) {

		String nameUser = stack.getUsuarioActivo().getName();
		Scanner sc = new Scanner(System.in);
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
			
			System.out.println("Ingrese la opción deseada:");
			opcion= sc.nextInt();
			
			String aux1 = "";
			String aux2 = "";
			int idAux = 0;
			int auxN = 0;
			boolean confirma = false;
			List<Etiqueta> etiquetasPregunta;
			Scanner aux = new Scanner (System.in); 
			Scanner aux_1 = new Scanner (System.in); 
			
			switch(opcion) {
			
				case 1: 
					
					System.out.println("Por favor ingrese titulo de la pregunta:");
			        aux1 = aux.nextLine ();
					System.out.println("Por favor ingrese contenido de la pregunta:");
					aux2 = aux.nextLine ();
					System.out.println("Por favor escoja etiquetas para su pregunta:");
					etiquetasPregunta = stack.mostrarYSeleccionarEtiquetasStack();
					
					stack.ask(aux1, aux2, etiquetasPregunta);
					
			        System.out.println("____________________________________________");
			        stack.mostrarStack();
					break;
					
				case 2:
			        System.out.println("____________________________________________");
			        stack.mostrarStack();
			     
			        confirma = stack.mostrarPreguntasStack();
					if(confirma) {
						
				        System.out.println("Por favor introduzca el ID correspondiente a la pregunta que desea responder."); 
				        idAux = aux.nextInt();
				        System.out.println("Por favor ingrese el contenido de la respuesta."); 
				        aux1 = aux_1.nextLine();
				        stack.answer(idAux, aux1);
				        
					}else { System.out.println("No se puede realizar esta accion por el momento.");}
			
					break;
					
				case 3:
			        System.out.println("____________________________________________");
			        stack.mostrarStack();
		 
			        confirma = stack.mostrarPreguntasStack();
					if(confirma) {
	
				        System.out.println("Por favor introduzca el ID correspondiente a la pregunta por la que desea entregar una recompensa."); 
				        idAux = aux.nextInt();
				        System.out.println("Por favor ingrese el monto de la recompensa que desea entregar."); 
				        auxN = aux.nextInt();
				        stack.reward(idAux, auxN);
				        
					}else { System.out.println("No se puede realizar esta accion por el momento.");}
	
			        System.out.println("____________________________________________");
			        stack.mostrarStack();
					break;
					
				
				case 6:
			        System.out.println("____________________________________________");
			        stack.mostrarStack();
					System.out.println("Por favor ingrese nombre:");
			        aux1 = aux.nextLine ();
					System.out.println("Por favor ingrese contraseña:");
					aux2 = aux.nextLine ();
			        stack.logout(aux1, aux2);
			
					salir = true;
					
			}

		}while(!salir);
	}
}
