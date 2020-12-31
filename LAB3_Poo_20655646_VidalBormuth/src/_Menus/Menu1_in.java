package _Menus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Respuesta;
import _TDAs.Stack;
import _TDAs.Usuario;

public class Menu1_in {
	
	
	public static void Main(String[] args){
		Usuario u1= new Usuario("Alma", "Alma1234");
		Usuario u2= new Usuario("Ana", "A234");
		Usuario u3= new Usuario("Sam", "samvid");
		Usuario u4= new Usuario("Pedro", "P200");
	
		List<Usuario> us1;
		us1= new ArrayList<>();
		us1.add(u1);
		us1.add(u2);
		us1.add(u3);
		us1.add(u4);
		
		u1.mostrarUsuario();
		
		u1.setReputacion(u1.getReputacion() + 25);
		
		System.out.println(u1.getReputacion());
		
		Etiqueta et1= new Etiqueta("Java", " java es un lenguaje de programación basado en el paradigma orientado a objetos.");
		System.out.println("la nueva etiqueta es: " + et1.getName() + et1.getDescripcion());
		
		Etiqueta et2= new Etiqueta("Prolog", " java es un lenguaje de programación basado en el paradigma declarativo.");
		System.out.println("la nueva etiqueta es: " + et2.getName() + et2.getDescripcion());
		
		List<Etiqueta> ets1;
		
		ets1 = new ArrayList<Etiqueta>();
		ets1.add(et1);
		ets1.add(et2);
		
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
		
		res1.add(r2);
		res1.add(r1);
		res1.add(r3);
		
        for(int i=0;i<res1.size();i++){
            res1.get(i).mostrarComun();
        }
        System.out.println("____________________________________________");
        Pregunta p1= new Pregunta("Fabian", "¿Esta clase funciona correctamente?","Esta pregunta es una prueba para comprobar funcionalidades.", ets1);
        p1.getRespuestas().add(r1);
        p1.getRespuestas().add(r2);
        
        Pregunta p2= new Pregunta("Tomas", "¿Pregunta 2?","Esta pregunta es una prueba para comprobar funcionalidades.", ets1);
        p2.getRespuestas().add(r3);
        p2.getRespuestas().add(r2);
        
        p2.mostrarComun();
        
		List<Pregunta> pre1;
		
		pre1 = new ArrayList<>();
		
		pre1.add(p1);
		pre1.add(p2);

        System.out.println("____________________________________________");
        Stack s1= new Stack(us1, pre1);
        
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
		
		
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		do{
			System.out.println("Menu inicial:");
			System.out.println("1. Registrarse");
			System.out.println("2. Iniciar sesión");
			System.out.println("3. Salir.");
			
			System.out.println("Ingrese la opción deseada:");
			opcion= sn.nextInt();
			
			String userName = "";
			String userPass = "";
			Scanner uName = new Scanner (System.in); 
			Scanner uPass = new Scanner (System.in); 
			
			switch(opcion) {
			
				case 1: 
					System.out.println("Por favor ingrese un nombre de usuario:");
			        userName = uName.nextLine ();
					System.out.println("Por favor ingrese una contraseña:");
					userPass = uPass.nextLine ();
					s1.register(userName, userPass);
					break;
					
				case 2:
					System.out.println("Por favor ingrese un nombre de usuario:");
			        userName = uName.nextLine ();
					System.out.println("Por favor ingrese una contraseña:");
					userPass = uPass.nextLine ();
					s1.login(userName, userPass);
					break;
				
				case 3:
					salir = true;
			
			}
					
		}while(!salir);
		
	}
	
	




}
