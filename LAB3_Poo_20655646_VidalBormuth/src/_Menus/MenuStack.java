package _Menus;

import java.util.Scanner;

public class MenuStack{

	public static void menuMetodosStack(MenuOpciones menuMetodos, String nameUA) {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		do{
			
			System.out.println("Menu inicial:");
			System.out.println("Usuario registrado: "+nameUA);
			System.out.println("Escoja su opción:");
			System.out.println("1. Agregar una nueva pregunta.");
			System.out.println("2. Responder pregunta.");
			System.out.println("3. Ofrecer recompensa.");
			System.out.println("4. Aceptar una respuesta.");
			System.out.println("5. Entregar un voto.");
			System.out.println("6. Cerrar sesión.");
				
			System.out.println("Ingrese de la opción deseada:");
			opcion= sc.nextInt();
				
			switch(opcion) {
				
				case 1: 
					menuMetodos.envolturaAsk();
					break;
						
				case 2:
					menuMetodos.envolturaAnswer();
					break;
						
				case 3:
					menuMetodos.envolturaReward();
				      break;
						
				case 4:
					menuMetodos.envolturaAccept();
					break;
				case 5:
					System.out.println("Esta opcion no esta disponible por el momento.");
						break;
				case 6:
					menuMetodos.envolturaLogout();
					salir = true;
					break;
					
				default:
					System.out.println("OPCIÓN INVALIDA");
						
			}
		}while(!salir);
	}
	
	
	
	
}
