package _TDAs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stack {
	
	private static int count3 = 0;
	private int idStack;
	private Usuario usuarioActivo;
	private List<Usuario> usuarios;
	private List<Pregunta> preguntas;
	private List<Etiqueta> etiquetas;
	
	public Stack(List<Usuario> usuarios, List<Pregunta> preguntas, List<Etiqueta> etiquetas) {
		this.usuarioActivo = null;
		this.usuarios = usuarios;
		this.preguntas = preguntas;
		this.etiquetas = etiquetas;
		setIdStack(++count3);
	}
	
	public Stack(Usuario usuarioA, List<Usuario> usuarios, List<Pregunta> preguntas) {
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

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public void mostrarStack() {
		
		System.out.println("Stack Overflow "+idStack+":\n\n Usuario Activo:");
		if(usuarioActivo != null) {
			usuarioActivo.mostrarUsuario();
		}
		
		System.out.println("________________Usuarios__________________");
        for(int i=0;i<usuarios.size();i++){
            usuarios.get(i).mostrarUsuario();
        }
        
		System.out.println("_________________Preguntas__________________");
        for(int i=0;i<preguntas.size();i++){
            preguntas.get(i).mostrarComun();
        }
		
	}
	
	public List<Etiqueta> mostrarYSeleccionarEtiquetasStack() {
		
		System.out.println("Etiquetas en Stack Overflow"+idStack);
		if(etiquetas != null) {
	        for(int i=0;i<etiquetas.size();i++){
				System.out.println("Etiqueta "+(i+1)+":");
	            etiquetas.get(i).mostrarEtiqueta();
	        }
	
	        List<Etiqueta> newList; newList = new ArrayList<>();
	        Scanner seleccion = new Scanner(System.in);
	        int numero = 0;
	        
	        System.out.println("Por favor introduzca el o los números correspondientes a la etiqueta que desea agregar. Para finalizar la eleccion introduzca un 0");
        	numero = seleccion.nextInt();
	        do {	
	        	newList.add(etiquetas.get(numero-1));
	        	numero = seleccion.nextInt();	
	        }while(numero != 0);
	        
	        return newList;
		}
		return null;
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
			Pregunta pregunta = new Pregunta(usuarioActivo.getName(), newTitulo, newContenido, newEtiquetas);
			preguntas.add(pregunta);
			System.out.println("Se a agregado una nueva pregunta.");
		}else {
			System.out.println("No existe usuario activo para realizar la pregunta.");
		}
	}

	
	public boolean mostrarPreguntasStack() {
		int mostradas = 0;
		System.out.println("Preguntas del Stack Overflow"+idStack);
		if(preguntas != null) {
	        for(Pregunta pregunta: preguntas){
				if(pregunta.getEstado().equals("Abierta")) {
					pregunta.mostrarComun();
					mostradas++;
				}
	        }
	        if(mostradas>0) {
	        return true;	
	        }
		}
		System.out.println("No existen preguntas abiertas en este stack");
		return false;
	}
	
	public Pregunta getPreguntaStack_ID(int idPregunta) {
		
        for(Pregunta pregunta: preguntas){
        	int idActual = pregunta.getId();
			if(idActual == idPregunta) {
				return pregunta;
			}
        }
        return null;
	}
	
	
	public void answer(int idPregunta, String contenidoRespuesta) {
        Respuesta newRespuesta= new Respuesta(usuarioActivo.getName(), contenidoRespuesta);
        getPreguntaStack_ID(idPregunta).getRespuestas().add(newRespuesta);
        System.out.println("Ha realizado una respuesta a la pregunta "+idPregunta);
	}
	
	public void reward(int idPregunta, int montoRecompensa) {
		int reputacionUA = usuarioActivo.getReputacion();
		if(reputacionUA >= montoRecompensa) {
			getPreguntaStack_ID(idPregunta).setRecompensa(montoRecompensa, usuarioActivo.getName());
			reputacionUA = reputacionUA - montoRecompensa;
			usuarioActivo.setReputacion(reputacionUA);
			System.out.println("Ha ofrecido una recompensa de "+montoRecompensa+"puntos por la pregunta"+idPregunta);
		}
	}
}
