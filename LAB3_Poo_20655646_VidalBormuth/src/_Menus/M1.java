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

public class M1 {

	public void menuMetodosStack(Stack stack) {

		String nameUser = stack.getUsuarioActivo().getName();
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		
		do{
			
			System.out.println("Menu inicial:");
			System.out.println("Usuario registrado: "+nameUser);
			System.out.println("Escoja su opción:");
			System.out.println("1. Agregar una nueva pregunta.");
			System.out.println("2. Responder pregunta.");
			System.out.println("4. Ofrecer recompensa.");
			System.out.println("5. Aceptar una respuesta.");
			System.out.println("6. Entregar un voto.");
			System.out.println("7. Cerrar sesión.");
			
			System.out.println("Ingrese la opción deseada:");
			opcion= sn.nextInt();
			
			String aux1 = "";
			String aux2 = "";
			List<Etiqueta> etiquetasPregunta;
			Scanner aux_1 = new Scanner (System.in); 
			Scanner aux_2 = new Scanner (System.in); 
			
			switch(opcion) {
			
				case 1: 
					System.out.println("Por favor ingrese titulo de la pregunta:");
			        aux1 = aux_1.nextLine ();
					System.out.println("Por favor ingrese contenido de la pregunta:");
					aux2 = aux_2.nextLine ();
					System.out.println("Por favor escoja etiquetas para su pregunta:");
					etiquetasPregunta = stack.mostrarYSeleccionarEtiquetasStack();
					
					stack.ask(aux1, aux2, etiquetasPregunta);
					
			        System.out.println("____________________________________________");
			        stack.mostrarStack();
					break;
					
				case 2:
			        System.out.println("____________________________________________");
			        stack.mostrarStack();
			        
					System.out.println("Por favor ingrese un nombre de usuario:");
			        userName = uName.nextLine ();
					System.out.println("Por favor ingrese una contraseña:");
					userPass = uPass.nextLine ();
					stackSelecionado.login(userName, userPass);
					
			        System.out.println("____________________________________________");
			        stack.mostrarStack();
					break;
				
				case 7:
			        System.out.println("____________________________________________");
			        stack.mostrarStack();
			        
					System.out.println("Por favor ingrese nombre:");
			        aux1 = aux_1.nextLine ();
					System.out.println("Por favor ingrese contraseña:");
					aux2 = aux_2.nextLine ();
			        stack.logout(aux1, aux2);
					
					salir = true;
			}
					
		}while(!salir);
	}
}
