package _TDAs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stack implements IMostrarEtiqueta {
	
	private static int count3 = 0;
	private int idStack;
	private Usuario usuarioActivo;
	private List<Usuario> usuarios;
	private Preguntas preguntas;
	private List<Etiqueta> etiquetas;
	
	public Stack(List<Usuario> usuarios, Preguntas preguntas, List<Etiqueta> etiquetas) {
		this.usuarioActivo = null;
		this.usuarios = usuarios;
		this.preguntas = preguntas;
		this.etiquetas = etiquetas;
		setIdStack(++count3);
	}
	
	public Stack(Usuario usuarioA, List<Usuario> usuarios, Preguntas preguntas) {
		this.usuarioActivo = usuarioA;
		this.usuarios = usuarios;
		this.preguntas = preguntas;
	}

	
	public int getIdStack() {
		return idStack;
	}

	public void setIdStack(int idStack) {
		this.idStack = idStack;
	}

	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(Usuario usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Preguntas getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Preguntas preguntas) {
		this.preguntas = preguntas;
	}
	
	public void mostrarStack() {
		
		System.out.println("Stack Overflow "+idStack+":\n\n Usuario Activo:");
		if(usuarioActivo != null) {
			usuarioActivo.mostrarUsuario();
		}
		
		System.out.println("________________Usuarios__________________");
        for(Usuario user: usuarios){
            user.mostrarUsuario();
        }
        
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
	
	private Usuario getUserStack(String newUserName) {
		
		for(Usuario user: usuarios) {
			if(user.getName().equals(newUserName)) {
				return user;
			}
		}
		return null;
	}
	
	public boolean register(String newUserName, String newPass) {
		Usuario user = getUserStack(newUserName);
		if(user == null) {
			Usuario newUser = new Usuario(newUserName, newPass);
			usuarios.add(newUser);
			return true;
		}else {
			System.out.println("Nombre de usuario existentente");
			return false;
		}
	}
	
	public void login(String userName, String userPass) {
		Usuario user = getUserStack(userName);
		if(user == null) {
			System.out.println("Nombre de usuario inexistente");
		}
		else if(user.getPass().equals(userPass) && usuarioActivo == null) {
			usuarioActivo = user; System.out.println("Se inicio sesion");
		}
		else {
		System.out.println("Contraseña incorrecta");
		}
	}
	
	public void logout(String userName, String userPass) {

		if(usuarioActivo != null && usuarioActivo.getName().equals(userName) && usuarioActivo.getPass().equals(userPass)) {
			usuarioActivo = null;
			System.out.println("El usuario ah cerrado sesión.");
		}else {
		System.out.println("No existe usuario activo para cerrar sesión.");
		}
	}
	
	public void ask(String newTitulo, String newContenido, List<Etiqueta> newEtiquetas) {
		
		if(usuarioActivo != null) {
			preguntas.agregarPregunta(new Pregunta(usuarioActivo.getName(), newTitulo, newContenido, newEtiquetas));
			System.out.println("Se a agregado una nueva pregunta.");
		}else {
			System.out.println("No existe usuario activo para realizar la pregunta.");
		}
	}

	
	
	public Usuario getUsuarioStack_Name(String userName) {
		
        for(Usuario user: usuarios){
        	String actualName = user.getName();
			if(actualName.equals(userName)) {
				return user;
				
			}
        }
        return null;
	}

	public void answer(int idPregunta, String contenidoRespuesta) {
        Respuesta newRespuesta= new Respuesta(usuarioActivo.getName(), contenidoRespuesta);
        preguntas.getPreguntaStack_ID(idPregunta).getRespuestas().add(newRespuesta);
        System.out.println("Ha realizado una respuesta a la pregunta "+idPregunta);
	}
	
	public void reward(int idPregunta, int montoRecompensa) {

		int reputacionUA = usuarioActivo.getReputacion();
		if(reputacionUA >= montoRecompensa) {
			preguntas.getPreguntaStack_ID(idPregunta).setRecompensa(montoRecompensa, usuarioActivo.getName());
			usuarioActivo.setReputacion(reputacionUA-montoRecompensa);
			System.out.println("Ha ofrecido una recompensa de "+montoRecompensa+"puntos por la pregunta"+idPregunta);
		}
		System.out.println("Reputación insufuciente para realizar esta recompensa.");
	}
	
	public boolean mostrarPreguntasUsuarioActivo() {
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

