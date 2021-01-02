package _Desarrollo;

import _TDAs.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _TDAs.Etiqueta;
import _TDAs.Respuesta;
import _TDAs.SistemaStack;
import _TDAs.Stack;
import _TDAs.Pregunta;
import _Menus.M1;
import _Menus.MenuMetodos;

public class MetodosUsuario {

	public static void main(String[] args) {
		// TODO Pruebas
		
		Usuario u1= new Usuario("Alma", "Alma1234"), u2= new Usuario("Ana", "A234"), u3= new Usuario("Sam", "samvid"), u4= new Usuario("Pedro", "P200");
	
		List<Usuario> us1;
		List<Usuario> us2;
		us1= new ArrayList<>(); us1.add(u1); us1.add(u2); us1.add(u3); us1.add(u4);
		us2= new ArrayList<>(); us2.add(u2); us2.add(u3);
		u1.mostrarUsuario();
		u1.setReputacion(u1.getReputacion() + 25);
		System.out.println(u1.getReputacion());
		
		Etiqueta et1= new Etiqueta("Java", " java es un lenguaje de programación basado en el paradigma orientado a objetos.");
		System.out.println("la nueva etiqueta es: " + et1.getName() + et1.getDescripcion());
		
		Etiqueta et2= new Etiqueta("Prolog", " java es un lenguaje de programación basado en el paradigma declarativo.");
		System.out.println("la nueva etiqueta es: " + et2.getName() + et2.getDescripcion());
		
		List<Etiqueta> ets1;
		
		ets1 = new ArrayList<Etiqueta>(); ets1.add(et1); ets1.add(et2);
		
        for(int i=0;i<ets1.size();i++){
            ets1.get(i).mostrarEtiqueta();
        }
        
        Respuesta r1= new Respuesta("Alma", "Esta clase funciona correctamente.");
        r1.setEstado("Aceptada");
        r1.setVotosAFavor(r1.getVotosAFavor() + 1);
        //r1.mostrarComun();
		
        Respuesta r2= new Respuesta("Pamela", "Este metodo funciona perfectamente.");
        //r2.mostrarComun();
        
        Respuesta r3= new Respuesta("Anto", "Confirma id.");
        //r3.mostrarComun();
        
		List<Respuesta> res1;
		res1 = new ArrayList<Respuesta>();
		res1.add(r2); res1.add(r1); res1.add(r3);
		
        for(int i=0;i<res1.size();i++){
            res1.get(i).mostrarComun();
        }
        System.out.println("____________________________________________");
        Pregunta p1= new Pregunta("Fabian", "¿Esta clase funciona correctamente?","Esta pregunta es una prueba para comprobar funcionalidades.", ets1);
        p1.getRespuestas().add(r1);
        p1.getRespuestas().add(r2);
        
        Pregunta p2= new Pregunta("Tomas", "¿Pregunta 2?","Esta pregunta es una prueba para comprobar funcionalidades.", ets1);
        p2.getRespuestas().add(r3); p2.getRespuestas().add(r2);
        p2.mostrarComun();
        
		List<Pregunta> pre1;
		pre1 = new ArrayList<>(); pre1.add(p1); pre1.add(p2);
		List<Pregunta> pre2;
		pre2 = new ArrayList<>(); pre2.add(p2);

        System.out.println("____________________________________________");
        Stack s1= new Stack(us1, pre1, ets1);
        Stack s2= new Stack(us2, pre2, ets1);
        
        s1.mostrarStack();
        
        System.out.println("____________________________________________");
        s1.register("ana", "Pamela123");
        
        s1.mostrarStack();
        
        System.out.println("____________________________________________");
        s1.login("Alma", "Alma1234");
        s1.ask("¿Funciona ask?", "Esta es la primera prueba directa para verificar el metodo ask de stack.", ets1);
        s1.mostrarStack();
        s1.logout("Alma", "Alma1234");
        s1.mostrarStack();
        
        List<Stack> sistemaS;
        sistemaS= new ArrayList<>(); sistemaS.add(s1); sistemaS.add(s2);
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
			opcion= sn.nextInt();
			
			String userName = "";
			String userPass = "";
			Scanner uName = new Scanner (System.in); 
			Scanner uPass = new Scanner (System.in); 
			
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
			        M1 menu = new M1();
			        menu.menuMetodosStack(stackSelecionado);
					break;
				
				case 3:
			        System.out.println("____________________________________________");
			        stackSelecionado.mostrarStack();
			        
					salir = true;
			}
					
		}while(!salir);
	}
	

}
