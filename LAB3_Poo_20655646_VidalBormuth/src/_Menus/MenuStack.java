package _Menus;

import java.util.Scanner;

/**
 * Clase que permite representar el meunu de motodos que puede utilizar un usuario con sesión iniciada en un stack.
 * @author Alma
 *
 */
public class MenuStack{

	/**
	 * Muestra por pantallas las acciones que puede realizar un usuario sobre un stack, acepta la opcion del usuario y implementa el metodo
	 * de un MenuOpiciones. 
	 * @param menuMetodos Clase con las acciones que puede realizar el stack activo sobre el stack para modificarlo. 
	 * @param nameUA Nombre del usuario activo. 
	 */
	public static void menuMetodosStack(MenuOpciones menuMetodos, String nameUA) {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		do{
			//Muestra el menu y las opciones.
			System.out.println("***Menu inicial:***");
			System.out.println("Usuario registrado: "+nameUA);
			System.out.println("\nEscoja su opción:");
			System.out.println("1. Agregar una nueva pregunta.");
			System.out.println("2. Responder pregunta.");
			System.out.println("3. Ofrecer recompensa.");
			System.out.println("4. Aceptar una respuesta.");
			System.out.println("5. Entregar un voto.");
			System.out.println("6. Cerrar sesión.");
				
			System.out.println("Ingrese de la opción deseada:");
			opcion= sc.nextInt(); //Pide y toma la opción escogida. 
				
			switch(opcion) {
				
				case 1: //Si la opción es 1 realiza una nueva pregunta en el stack.
					menuMetodos.envolturaAsk();
					break;
						
				case 2: //Si es 2 responde una pregunta abierta en el stack.
					menuMetodos.envolturaAnswer();
					break;
						
				case 3: //Si es 3 ofrece una recompensa por una pregunta abierta. 
					menuMetodos.envolturaReward();
				      break;
						
				case 4: //Si es 4 acepta una respuesta de una de sus preguntas abiertas.
					menuMetodos.envolturaAccept();
					break;
				case 5: //Si es 5 vota por una pregunta o respuesta. 
					System.out.println("\nEsta opcion no esta disponible por el momento.\n");
						break;
				case 6: //si es 6 cierra sesión.
					menuMetodos.envolturaLogout();
					salir = true; //Y sale del menu de metodos. 
					break;
					
				default: // si la opción es invalida lo indica y permite escoger denuevo. 
					System.out.println("#OPCIÓN INVALIDA#\n");
						
			}
		}while(!salir); //El menu se muestra hasta que se selecione cerrar sesión.
	}
	
	
	
	
}
