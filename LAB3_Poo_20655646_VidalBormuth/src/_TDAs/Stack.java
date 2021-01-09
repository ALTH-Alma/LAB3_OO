package _TDAs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stack implements IMostrarEtiqueta {
	
	private static int count3 = 0;
	private int idStack;
	private Usuarios usuarios;
	private Preguntas preguntas;
	private List<Etiqueta> etiquetas;
	
	public Stack(Usuarios usuarios, Preguntas preguntas, List<Etiqueta> etiquetas) {
		this.usuarios = usuarios;
		this.preguntas = preguntas;
		this.etiquetas = etiquetas;
		setIdStack(++count3);
	}

	
	public int getIdStack() {
		return idStack;
	}

	public void setIdStack(int idStack) {
		this.idStack = idStack;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Preguntas getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Preguntas preguntas) {
		this.preguntas = preguntas;
	}
	
	public void mostrarStack() {
		
		System.out.println("Stack Overflow "+idStack);
		usuarios.mostrarUsuarioActivo();
		usuarios.mostrarUsuarios_Todos();
		preguntas.mostrarPreguntas_Todas();
		
	}
	
	@Override
	public boolean mostrarEtiquetas() {
		if(!etiquetas.isEmpty()) {
	        for(int i=0;i<etiquetas.size();i++){
				System.out.println((i+1)+")");
	            etiquetas.get(i).mostrarEtiqueta();
	        }
	        return true;
		}else {
			System.out.println("No existen etiquetas.");
			return false;
		}
	}	
	
	public void agregarEtiquetaPorConsola(){
		
		try(Scanner seleccion = new Scanner(System.in)){
			String aux = "";
			String aux1 = "";

			System.out.println("Por favor introduzca el nombre de la nueva etiqueta:");
			aux = seleccion.nextLine();
			System.out.println("Por favor introduzca la descripción de la nueva etiqueta:");
			aux1 = seleccion.nextLine();
			Etiqueta newEtiqueta = new Etiqueta(aux, aux1);
			etiquetas.add(newEtiqueta);

		}
	}
	
	public List<Etiqueta> mostrarYSeleccionarEtiquetasStack() {
		try (Scanner seleccion = new Scanner(System.in);){
		
			System.out.println("Etiquetas en Stack Overflow "+idStack);
			boolean aux = mostrarEtiquetas();
			int auxV = 1;

			do {
				System.out.println("¿Desea agregar una nueva etiqueta en el stack antes de crear una pregunta?. "
						+ "Si su respuesta es 'si' por favor introduzca un 1. Si es 'no' introduzca un 2.");
				auxV = seleccion.nextInt();
				Etiqueta etiqueta = agregarEtiquetaPorConsola();
			}while(auxV == 1);
			
			if(aux) {
	
		        List<Etiqueta> newList; newList = new ArrayList<>();
		        Scanner seleccion = new Scanner(System.in);
		        
		        System.out.println("Por favor introduzca el o los números correspondientes a la etiqueta que desea agregar. Para finalizar la eleccion introduzca un 0");
	        	int numero = seleccion.nextInt();
		        do {	
		        	newList.add(this.etiquetas.get(numero-1));
		        	numero = seleccion.nextInt();	
		        }while(numero != 0);
		        
		        return newList;
			}
			return null;
		}
	}

	
	public boolean register(String newUserName, String newPass) {
		Usuario usuario = usuarios.getUser_Name(newUserName);
		if(usuario == null) {
			Usuario newUser = new Usuario(newUserName, newPass);
			usuarios.agregarUsuario(newUser);
			return true;
		}else {
			System.out.println("Nombre de usuario existentente");
			return false;
		}
	}
	
	public void login(String userName, String userPass) {
		Usuario user = usuarios.getUser_Name(userName);
		if(user == null) {
			System.out.println("Nombre de usuario inexistente");
		}
		else if(user.getPass().equals(userPass) && usuarios.getUsuarioActivo() == null) {
			usuarios.setUsuarioActivo(user); System.out.println("Se inicio sesion");
		}
		else {
		System.out.println("Contraseña incorrecta");
		}
	}
	
	public void logout(String userName, String userPass) {

		if(usuarios.getUsuarioActivo() != null && usuarios.getUsuarioActivo().getName().equals(userName) && usuarios.getUsuarioActivo().getPass().equals(userPass)) {
			usuarios.setUsuarioActivo(null);
			System.out.println("El usuario ah cerrado sesión.");
		}else {
		System.out.println("No existe usuario activo para cerrar sesión.");
		}
	}
	
	public void ask(String newTitulo, String newContenido, List<Etiqueta> newEtiquetas) {
		
		if(usuarios.getUsuarioActivo() != null) {
			preguntas.agregarPregunta(new Pregunta(usuarios.getUsuarioActivo().getName(), newTitulo, newContenido, newEtiquetas));
			System.out.println("Se a agregado una nueva pregunta.");
		}else {
			System.out.println("No existe usuario activo para realizar la pregunta.");
		}
	}
	
	public void answer(int idPregunta, String contenidoRespuesta) {
        Respuesta newRespuesta= new Respuesta(usuarios.getUsuarioActivo().getName(), contenidoRespuesta);
        preguntas.getPreguntaStack_ID(idPregunta).getRespuestas().add(newRespuesta);
        System.out.println("Ha realizado una respuesta a la pregunta "+idPregunta);
	}
	
	public void reward(int idPregunta, int montoRecompensa) {

		int reputacionUA = usuarios.getUsuarioActivo().getReputacion();
		if(reputacionUA >= montoRecompensa) {
			preguntas.getPreguntaStack_ID(idPregunta).getRecompensa().setRecompensa(montoRecompensa, usuarios.getUsuarioActivo().getName());
			usuarios.getUsuarioActivo().setReputacion(reputacionUA-montoRecompensa);
			System.out.println("Ha ofrecido una recompensa de "+montoRecompensa+"puntos por la pregunta"+idPregunta);
		}
		System.out.println("Reputación insufuciente para realizar esta recompensa.");
	}
	
	public boolean mostrarPreguntasUsuarioActivo() { //Hacer un metodo mostrar preguntas usuario por nombre.
		int mostradas = 0;
		System.out.println("Preguntas del usuario "+usuarioActivo.getName()+":");
		if(preguntas.existenPreguntas()) {
	        for(Pregunta pregunta: preguntas.getPreguntas()){
				if(pregunta.getEstado().equals("Abierta") && pregunta.getAutor().equals(usuarioActivo.getName())) {
					pregunta.mostrarComun();
					mostradas++;
				}
	        }
	        if(mostradas>0) {
	        return true;	
	        }
		}
		System.out.println("No existen preguntas abiertas en este stack\n");
		return false;
	}
	
	public void accept(int idPregunta, int idRespuesta) {

		Pregunta pregunta = preguntas.getPreguntaStack_ID(idPregunta);
		Respuesta respuesta = pregunta.getRespuesta_ID(idRespuesta);

		if(respuesta != null) {
			respuesta.setEstado("Aceptada.");

			Usuario autorRespuesta = getUsuarioStack_Name(respuesta.getAutor());
			autorRespuesta.mostrarUsuario();
			autorRespuesta.agregarPuntosAReputacion((14+pregunta.tomarRecompensa()));
			usuarioActivo.agregarPuntosAReputacion(2);
		}
	}

}

