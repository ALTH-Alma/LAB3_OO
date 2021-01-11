package _Menus;

import java.util.Scanner;

import Service.ServiceEntradaUsuarios;
import Service.StackService;
import _TDAs.Stack;
import _TDAs.Usuario;

/**
 * Clase que representa el menu inical del sistema stack overflow, permite que un usuario se registre y/o entre a un stack.
 * @author Alma
 *
 */
public class MenuInicial {

	/**
	 * Muestra el menu principal y da las opciones para registrar un nuevo usuario en el stack y/o iniciar sesión
	 * Al iniciar sesión permite el paso del usuario al siguiente menu, para poder realizar cambios en el stack como usuario activo. 
	 * @param stackSeleccionado Stack con el que se trabaja (Al que se le registra un nuevo usuario y/o se ingresa con login para realizar modificaciones).
	 */
	public void menuInicial(Stack stackSeleccionado) {
		
		 if(stackSeleccionado != null) { //Mientras el stack con el que se trabaja sea diferente de null.
			 
			ServiceEntradaUsuarios uService = new ServiceEntradaUsuarios(stackSeleccionado);
	        Scanner sn = new Scanner(System.in);
			boolean salir = false;
			int opcion;
			do{
				System.out.println("\n*********Menu inicial***********"); //Se muestra menu.
				System.out.println("1. Registrarse.");
				System.out.println("2. Iniciar sesión.");
				System.out.println("3. Salir del programa.");
				
				System.out.println("\nIngrese el número de la opción deseada:"); //Se solicita y recibe opción seleccionada. 
				opcion= sn.nextInt();
			
				String userName = "";
				String userPass = "";
		
				Scanner uName = new Scanner (System.in); 
				Scanner uPass = new Scanner (System.in); 
				
				switch(opcion) {
				
					case 1: //Si la opción es 1.
						System.out.println("____________________________________________");
				        stackSeleccionado.mostrarStack(); //Se muestra stack antes de realizar cambio.
				        
				        //Se solicitan datos: nuevo nombre y contraseña.
						System.out.println("Por favor ingrese un nombre de usuario:");
				        userName = uName.nextLine ();
						System.out.println("Por favor ingrese una contraseña:");
						userPass = uPass.nextLine ();
						boolean registro = uService.register(userName, userPass); //Se intenta registrar usuario.
						if(registro) { //si se registra correctamente...
							System.out.println("____________________________________________"); //Se muestra actualizacion de stack.
							stackSeleccionado.mostrarStack();
							System.out.println("Si desea realizar alguna acción en el stack, por favor inicie sesión.");
						}
						break;
						
					case 2: //Si es 2.
						System.out.println("____________________________________________");
				        stackSeleccionado.mostrarStack();//Se muestra stack antes de realizar cambio.
				        
				        //Se solicitan datos: nombre de usuario y contraseña.
						System.out.println("Por favor ingrese un nombre de usuario:");
				        userName = uName.nextLine ();
						System.out.println("Por favor ingrese una contraseña:");
						userPass = uPass.nextLine ();
						Usuario user = uService.login(userName, userPass); //Se intenta logiar usuario.
						if(user != null) { //Si se logeo...
							System.out.println("____________________________________________");
							stackSeleccionado.mostrarStack(); //Se muestra actualización.
							StackService sService = new StackService(stackSeleccionado, user);//Se crea un StackService para el usuario activo.
							MenuOpciones menu = new MenuOpciones(sService); //Se crea un menu de opciones para el StackService.
							MenuStack.menuMetodosStack(menu, userName); //Se utiliza el menu de metodos del stack.
						}
						break;
					
					case 3: //si es 3.
						System.out.println("____________________________________________");//Se muestra stack
				        stackSeleccionado.mostrarStack();
						salir = true; //Y se sale del menu inical del stack.
						System.out.println("\nUSTED A SALIDO DEL STACK");
						break;
						
					default: //si no fue ninguna de las otras...
						salir = true;
						System.out.println("OPCIÓN INVALIDA"); //Se sale del menu inicial.
				}
						
			}while(!salir); //El menu se ejecuta hasta que se selecciona salir o se ingresa una opcion incorrecta.
        }else {
        	System.exit(0); //Si no existe stack se cierra el programa. 
        }

	}
	
}
