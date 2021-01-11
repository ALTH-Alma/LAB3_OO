package _Menus;

import java.util.Scanner;

import Service.ServiceEntradaUsuarios;
import Service.StackService;
import _TDAs.Stack;
import _TDAs.Usuario;

public class MenuInicial {

	public void menuInicial(Stack stackSeleccionado) {
		System.out.println("\nAqui muere:");
		 if(stackSeleccionado != null) {
			 System.out.println("\nAqui muere1:");
			ServiceEntradaUsuarios uService = new ServiceEntradaUsuarios(stackSeleccionado);
	        Scanner sn = new Scanner(System.in);
			boolean salir = false;
			int opcion;
			do{
				System.out.println("\nMenu inicial:");
				System.out.println("1. Registrarse.");
				System.out.println("2. Iniciar sesión.");
				System.out.println("3. Salir del programa.");
				
				System.out.println("\nIngrese el número la opción deseada:");
				opcion= sn.nextInt();
			
				String userName = "";
				String userPass = "";
		
				Scanner uName = new Scanner (System.in); 
				Scanner uPass = new Scanner (System.in); 
				
				switch(opcion) {
				
					case 1: 
						System.out.println("____________________________________________");
				        stackSeleccionado.mostrarStack();
				        
				        stackSeleccionado.mostrarStack();
						System.out.println("Por favor ingrese un nombre de usuario:");
				        userName = uName.nextLine ();
						System.out.println("Por favor ingrese una contraseña:");
						userPass = uPass.nextLine ();
						boolean registro = uService.register(userName, userPass);
						if(registro) {
							System.out.println("____________________________________________");
							stackSeleccionado.mostrarStack();
							System.out.println("Si desea realizar alguna acción en el stack, por favor inicie sesión.");
						}
						break;
						
					case 2:
						System.out.println("____________________________________________");
				        stackSeleccionado.mostrarStack();
				        
						System.out.println("Por favor ingrese un nombre de usuario:");
				        userName = uName.nextLine ();
						System.out.println("Por favor ingrese una contraseña:");
						userPass = uPass.nextLine ();
						Usuario user = uService.login(userName, userPass);
						if(user != null) {
							System.out.println("____________________________________________");
							stackSeleccionado.mostrarStack();
							StackService sService = new StackService(stackSeleccionado, user);
							MenuOpciones menu = new MenuOpciones(sService);
							MenuStack.menuMetodosStack(menu, userName);
						}
						break;
					
					case 3:
						System.out.println("____________________________________________");
				        stackSeleccionado.mostrarStack();
						salir = true;
						System.out.println("\nUSTED A SALIDO DEL STACK");
						break;
						
					default:
						salir = true;
						System.out.println("OPCIÓN INVALIDA");
				}
						
			}while(!salir);
        }else {
        	System.exit(0);
        }

	}
	
}
