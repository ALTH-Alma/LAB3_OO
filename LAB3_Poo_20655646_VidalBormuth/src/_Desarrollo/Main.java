package _Desarrollo;

import _TDAs.Usuario;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _TDAs.Etiqueta;

import _TDAs.Respuesta;
import Service.SistemaStack;
import _TDAs.Stack;
import _TDAs.Pregunta;
import _TDAs.Recompensa;
import _Menus.MenuStack;

public class Main {

	public static void main(String[] args) {
		
		// TODO Se cargan los datos iniciales solicitados.
		
		Usuario u1 = new Usuario("Eva", "Ev123", 75);
		Usuario u2= new Usuario("Ana", "A2000", 54);
		Usuario u3= new Usuario("Sam", "010102", 60);
		Usuario u4= new Usuario("Pedro", "P1999",70);
	
		List<Usuario> usuarios1;
		usuarios1 = new ArrayList<>(); usuarios1.add(u1); usuarios1.add(u2); usuarios1.add(u3); usuarios1.add(u4);
		
		
		Etiqueta et1 = new Etiqueta("Java", " java es un lenguaje de programación basado en el paradigma orientado a objetos.");
		Etiqueta et2 = new Etiqueta("Prolog", " prolog es un lenguaje de programación basado en el paradigma declarativo.");
		Etiqueta et3 = new Etiqueta("Scheme", " scheme es un lenguaje de programación basado en el paradigma funcional.");
		
		List<Etiqueta> etiquetas1, etiquetas2;
		etiquetas1 = new ArrayList<Etiqueta>(); etiquetas1.add(et1); etiquetas1.add(et2); etiquetas1.add(et3);
		etiquetas2 = new ArrayList<Etiqueta>(); etiquetas2.add(et1); etiquetas2.add(et2); etiquetas2.add(et3);
       
        
        Respuesta res1 = new Respuesta("Ana", "Esta es una respuesta del stack.", "Pendiente.", 10, 5, 1);
        Respuesta res2 = new Respuesta("Sam", "Esta es una respuesta de prueba.", "Aceptada.", 20, 3, 0);
        Respuesta res3 = new Respuesta("Pedro", "Esta es una respuesta.", "Rechazada.", 4, 10, 3);
        Respuesta res4 = new Respuesta("Ana", "Esta es una respuesta para el stack.", "Aceptada.", 34, 3, 2);
        Respuesta res5 = new Respuesta("Eva", "Este es una respuesta de Eva.", "Pendiente.", 15, 1, 0);
        Respuesta res6 = new Respuesta("Pedro", "Esta es otra respuesta.", "Pendiente.", 20, 2, 3);
        Respuesta res7 = new Respuesta("Sam", "Otra respuestas del stack más.", "Pendiente.", 19, 4, 2);
        Respuesta res8 = new Respuesta("Eva", "Respuesta para stack.", "Aceptada.", 20, 0, 0);
        Respuesta res9 = new Respuesta("Ana", "Contenido de otra respuesta.", "Pendiente.", 17, 2, 0);
        Respuesta res10 = new Respuesta("Sam", "Contenido respuesta stack.", "Aceptada.", 40, 4, 1);
        
		List<Respuesta> respuestas1, respuestas2, respuestas3, respuestas4, respuestas5;
		respuestas1 = new ArrayList<Respuesta>(); respuestas1.add(res2); respuestas1.add(res1); respuestas1.add(res3);
		respuestas2 = new ArrayList<Respuesta>(); respuestas2.add(res4); respuestas2.add(res5); respuestas2.add(res6);
		respuestas3 = new ArrayList<Respuesta>(); respuestas3.add(res7); respuestas1.add(res8); 
		respuestas4 = new ArrayList<Respuesta>(); respuestas4.add(res9); respuestas4.add(res10);
		respuestas5 = new ArrayList<Respuesta>();
		
		Recompensa rec = new Recompensa();rec.setRecompensa(10, "Sam");
		Recompensa rec1 = new Recompensa();rec1.setRecompensa(20,"Eva");
		Recompensa rec2 = new Recompensa();
		Recompensa rec3 = new Recompensa();
		Recompensa rec4 = new Recompensa();
		
        Pregunta preg1 = new Pregunta("Eva", "¿Pregunta del stack 1?","Esta pregunta es una pregunta de relleno.", etiquetas2, "Abierta.", 10, 4, 1, rec, respuestas1);
        Pregunta preg2 = new Pregunta("Sam", "¿Pregunta del stack 2?","Esta pregunta es una pregunta.", etiquetas2, "Abierta.", 5, 3, 2, rec1, respuestas2);
        Pregunta preg3 = new Pregunta("Pedro", "¿Pregunta del stack 3?","Esta pregunta es de pedro.", etiquetas2, "Cerrada.", 20, 1, 1, rec2, respuestas3);
        Pregunta preg4 = new Pregunta("Eva", "¿Pregunta del stack 4?","Esta pregunta pregunta algo.", etiquetas2, "Abierta.", 12, 1, 0, rec3, respuestas4);
        Pregunta preg5 = new Pregunta("Sam", "¿pregunta del stack 5?", "Esta pregunta es otra pregunta", etiquetas2, "Abierta.", 0, 0, 0, rec4, respuestas5);
        
		List<Pregunta> preguntas1;
		preguntas1 = new ArrayList<>(); preguntas1.add(preg1); preguntas1.add(preg2);preguntas1.add(preg3); preguntas1.add(preg4); preguntas1.add(preg5);
	
		
        Stack s1= new Stack(usuarios1, preguntas1, etiquetas1);

        
        List<Stack> sistemaS;
        sistemaS= new ArrayList<>(); sistemaS.add(s1);
        SistemaStack sistema = new SistemaStack(sistemaS);
		
        
        
        Stack stackSeleccionado = sistema.escogerStack();
        if(stackSeleccionado != null) {
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
						boolean registro = stackSeleccionado.getUsuarios().register(userName, userPass);
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
						boolean inicio = stackSeleccionado.getUsuarios().login(userName, userPass);
						if(inicio) {
							System.out.println("____________________________________________");
							stackSeleccionado.mostrarStack();
							MenuStack.menuMetodosStack(stackSeleccionado);
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
