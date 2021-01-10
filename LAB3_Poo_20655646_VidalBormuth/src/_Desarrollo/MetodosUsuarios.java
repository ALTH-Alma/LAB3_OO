package _Desarrollo;

import _TDAs.Usuario;
import _TDAs.Usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _TDAs.Etiqueta;
import _TDAs.Etiquetas;
import _TDAs.Respuesta;
import _TDAs.SistemaStack;
import _TDAs.Stack;
import _TDAs.Pregunta;
import _TDAs.Preguntas;
import _TDAs.Recompensa;
import _Menus.M1;

public class MetodosUsuarios {

	public static void main(String[] args) {
		
		// TODO Se cargan los datos iniciales solicitados.
		
		Usuario u1 = new Usuario("Eva", "Ev123", 75);
		Usuario u2= new Usuario("Ana", "A2000", 54);
		Usuario u3= new Usuario("Sam", "010102", 60);
		Usuario u4= new Usuario("Pedro", "P1999",70);
	
		List<Usuario> us1;
		us1 = new ArrayList<>(); us1.add(u1); us1.add(u2); us1.add(u3); us1.add(u4);
		Usuarios usuarios1 = new Usuarios(us1);
		
		Etiqueta et1 = new Etiqueta("Java", " java es un lenguaje de programación basado en el paradigma orientado a objetos.");
		Etiqueta et2 = new Etiqueta("Prolog", " prolog es un lenguaje de programación basado en el paradigma declarativo.");
		Etiqueta et3 = new Etiqueta("Scheme", " scheme es un lenguaje de programación basado en el paradigma funcional.");
		
		List<Etiqueta> etiquetas1;
		etiquetas1 = new ArrayList<Etiqueta>(); etiquetas1.add(et1); etiquetas1.add(et2); etiquetas1.add(et3);
		Etiquetas etiquetas2 = new Etiquetas(etiquetas1);
        
        Respuesta res1 = new Respuesta("Ana", "Esta es una respuesta del stack.", "Pendiente", 10, 5, 1);
        Respuesta res2 = new Respuesta("Sam", "Esta es una respuesta de prueba.", "Aceptada", 20, 3, 0);
        Respuesta res3 = new Respuesta("Pedro", "Esta es una respuesta.", "Rechazada", 4, 10, 3);
        Respuesta res4 = new Respuesta("Ana", "Esta es una respuesta para el stack.", "Aceptada", 34, 3, 2);
        Respuesta res5 = new Respuesta("Eva", "Este es una respuesta de Eva.", "Pendiente", 15, 1, 0);
        Respuesta res6 = new Respuesta("Pedro", "Esta es otra respuesta.", "Pendiente", 20, 2, 3);
        Respuesta res7 = new Respuesta("Sam", "Otra respuestas del stack más.", "Pendiente", 19, 4, 2);
        Respuesta res8 = new Respuesta("Eva", "Respuesta para stack.", "Aceptada", 20, 0, 0);
        Respuesta res9 = new Respuesta("Ana", "Contenido de otra respuesta.", "Pendiente", 17, 2, 0);
        Respuesta res10 = new Respuesta("Sam", "Contenido respuesta stack.", "Aceptada", 40, 4, 1);
        
		List<Respuesta> respuestas1, respuestas2, respuestas3, respuestas4, respuestas5;
		respuestas1 = new ArrayList<Respuesta>(); respuestas1.add(res2); respuestas1.add(res1); respuestas1.add(res3);
		respuestas2 = new ArrayList<Respuesta>(); respuestas2.add(res4); respuestas2.add(res5); respuestas2.add(res6);
		respuestas3 = new ArrayList<Respuesta>(); respuestas3.add(res7); respuestas1.add(res8); 
		respuestas4 = new ArrayList<Respuesta>(); respuestas4.add(res9); respuestas4.add(res10);
		respuestas5 = new ArrayList<Respuesta>();
		
		Recompensa rec = new Recompensa();
		Recompensa rec1 = new Recompensa();
		rec.setRecompensa(10, "Sam");
		
        Pregunta preg1 = new Pregunta("Eva", "¿Pregunta del stack 1?","Esta pregunta es una pregunta de relleno.", etiquetas2, "Abierta", 10, 4, 1, rec, respuestas1);
        Pregunta preg2 = new Pregunta("Sam", "¿Pregunta del stack 2?","Esta pregunta es una pregunta.", etiquetas2, "Abierta", 5, 3, 2, rec, respuestas2);
        Pregunta preg3 = new Pregunta("Pedro", "¿Pregunta del stack 3?","Esta pregunta es de pedro.", etiquetas2, "Cerrada", 20, 1, 1, rec1, respuestas3);
        Pregunta preg4 = new Pregunta("Eva", "¿Pregunta del stack 4?","Esta pregunta pregunta algo.", etiquetas2, "Abierta", 12, 1, 0, rec1, respuestas4);
        Pregunta preg5 = new Pregunta("Sam", "¿pregunta del stack 5?", "Esta pregunta es otra pregunta", etiquetas2, "Abierta", 0, 0, 0, rec, respuestas5);
        
		List<Pregunta> preguntas1;
		preguntas1 = new ArrayList<>(); preguntas1.add(preg1); preguntas1.add(preg2);preguntas1.add(preg3); preguntas1.add(preg4); preguntas1.add(preg5);
		Preguntas preguntas2 = new Preguntas(preguntas1);
	
		
        Stack s1= new Stack(usuarios1, preguntas2, etiquetas2);

        
        List<Stack> sistemaS;
        sistemaS= new ArrayList<>(); sistemaS.add(s1);
        SistemaStack sistema = new SistemaStack(sistemaS);
		
        
        
        Stack stackSelecionado = sistema.escogerStack();
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		
		do{
			System.out.println("Menu inicial:");
			System.out.println("1. Registrarse.");
			System.out.println("2. Iniciar sesión.");
			System.out.println("3. Salir del programa.");
			
			System.out.println("Ingrese el número la opción deseada:");
			System.out.println("Aqui muere");
			opcion= sn.nextInt();
			System.out.println("Ingrese el número la opción deseada:");
			String userName = "";
			String userPass = "";
			System.out.println("Ingrese el número la opción deseada:");
			Scanner uName = new Scanner (System.in); 
			Scanner uPass = new Scanner (System.in); 
			System.out.println("Ingrese el número la opción deseada:");
			switch(opcion) {
			
				case 1: 
			        System.out.println("____________________________________________");
			        stackSelecionado.mostrarStack();
			        
			        stackSelecionado.mostrarStack();
					System.out.println("Por favor ingrese un nombre de usuario:");
			        userName = uName.nextLine ();
					System.out.println("Por favor ingrese una contraseña:");
					userPass = uPass.nextLine ();
					stackSelecionado.register(userName, userPass);
					
			        System.out.println("____________________________________________");
			        stackSelecionado.mostrarStack();
			        System.out.println("Si desea realizar alguna acción en el stack, por favor inicie sesón.");
					break;
					
				case 2:
			        System.out.println("____________________________________________");
			        stackSelecionado.mostrarStack();
			        
					System.out.println("Por favor ingrese un nombre de usuario:");
			        userName = uName.nextLine ();
					System.out.println("Por favor ingrese una contraseña:");
					userPass = uPass.nextLine ();
					stackSelecionado.login(userName, userPass);
					
			        System.out.println("____________________________________________");
			        stackSelecionado.mostrarStack();
			        M1.menuMetodosStack(stackSelecionado);
			       
					break;
				
				case 3:
			        System.out.println("____________________________________________");
			        stackSelecionado.mostrarStack();
			        
					salir = true;
			}
					
		}while(!salir);
	}
	

}
