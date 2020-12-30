package _Desarrollo;

import _TDAs.Usuario;

import java.util.ArrayList;
import java.util.List;

import _TDAs.Etiqueta;
import _TDAs.Respuesta;
import _TDAs.Pregunta;

public class MetodosUsuario {

	public static void main(String[] args) {
		// TODO Pruebas
		
		Usuario alma= new Usuario("Alma", "Alma1234", 20);
		System.out.println("El nombre del usuario 1 es: " + alma.getName());
		System.out.println("La contraseña del usuario es: " + alma.getPass());
		System.out.println("La reputación del usuario es: " + alma.getReputacion());
		
		alma.mostrarUsuario();
		
		alma.setReputacion(alma.getReputacion() + 25);
		
		System.out.println(alma.getReputacion());
		
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
		
        
//		List<Respuesta> res1;
//		
//		res1 = new ArrayList<Respuesta>();
//		
//		res1.add(r2);
//		res1.add(r1);
//		res1.add(r3);
//		
//        for(int i=0;i<res1.size();i++){
//            res1.get(i).mostrarComun();
//        }
        System.out.println("____________________________________________");
        Pregunta p1= new Pregunta("Fabian", "¿Esta clase funciona correctamente?","Esta pregunta es una prueba para comprobar funcionalidades.", ets1);
        p1.getRespuestas().add(r1);
        p1.getRespuestas().add(r2);
        
        p1.mostrarComun();
        
        
	}

}
