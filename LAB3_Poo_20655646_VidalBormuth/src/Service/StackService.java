package Service;

import java.util.List;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Recompensa;
import _TDAs.Respuesta;
import _TDAs.Stack;
import _TDAs.Usuario;

public class StackService {
	private final Stack stack;
	private Usuario usuarioActivo; 

	public StackService(Stack stack, Usuario usuarioActivo) {
		this.stack = stack;
		this.usuarioActivo = usuarioActivo;
	}
	
	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(Usuario usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}

	public Stack getStack() {
		return stack;
	}
	
	private Pregunta getPregunta(int idPregunta) {
		
        for(Pregunta pregunta: stack.getPreguntas()){
			if(pregunta.getId() == idPregunta) {
				return pregunta;
			}
        }
        return null;
	}
	
	private Respuesta getRespuesta(Pregunta pregunta, int idRespuesta) {
	
        for(Respuesta respuesta: pregunta.getRespuestas()){
			if(respuesta.getId() == idRespuesta) {
				return respuesta;
			}
        }
        return null;
		
	}


	public void logout(String userName, String userPass) {
		
		if(usuarioActivo != null && usuarioActivo.getName().equals(userName) && usuarioActivo.getPass().equals(userPass)) {
			usuarioActivo = null;
			System.out.println("El usuario "+userName+" a cerrado sesión !!!");
		}else {
		System.out.println("#NO EXISTE USUARIO ACTIVO PARA CERRAR SESIÓN.");
		}
	}
	
	
	public void ask(String newTitulo, String newContenido, List<Etiqueta> newEtiquetas) {
		
		stack.getPreguntas().add(new Pregunta(usuarioActivo.getName(), newTitulo, newContenido, newEtiquetas));
		System.out.println("\nSe a agregado una nueva pregunta.\n");

	}
	
	
	public void answer(int idPregunta, String contenidoRespuesta) {
        
        Pregunta pregunta = getPregunta(idPregunta);
        if(pregunta != null) {
        	pregunta.getRespuestas().add(new Respuesta(usuarioActivo.getName(), contenidoRespuesta));
        	System.out.println("\nHa entragado una respuesta a la pregunta "+idPregunta+".\n");
        }else {
        	System.out.println("\n#NO SE A PODIDO REALIZAR LA RESPUESTA. Id inexistente.\n");
        }		
	}
	
	
	public void entregarRecompensa(Pregunta pregunta, int montoRecompensa, int reputacionUA) {
		
		RecompensaService rs = new RecompensaService(pregunta.getRecompensa());
		rs.aumentarRecompensa(montoRecompensa, usuarioActivo.getName());
		usuarioActivo.setReputacion(reputacionUA-montoRecompensa);
		System.out.println("\nHa ofrecido una recompensa de "+montoRecompensa+" puntos por la pregunta "+pregunta.getId()+" !!!");
	}
	
	
	public void reward(int idPregunta, int montoRecompensa) {
		
		int reputacionUA = usuarioActivo.getReputacion();
		if(reputacionUA >= montoRecompensa) {
			Pregunta pregunta = getPregunta(idPregunta);
			if(pregunta != null) {
				entregarRecompensa(pregunta, montoRecompensa, reputacionUA);
			}else {
				System.out.println("#ID DE PREGUNTA INCORRECTO. No se pudo ofrecer la recompensa");
			}
		}else {
			System.out.println("\n#REPUTACIÓN INSUFICIENTE. No puede ofrecer esta recompensa.");
		}
		
	}

	private Usuario tomarUser(String userName) {
		
		for(Usuario user: stack.getUsuarios()) {
			if(user.getName().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	private void aceptarRespuesta(Respuesta respuesta, Recompensa recompensa) {
		RecompensaService rs = new RecompensaService(recompensa);
		if(respuesta != null && respuesta.getEstado().equals("Pendiente.")) {
			respuesta.setEstado("Aceptada.");
			tomarUser(respuesta.getAutor()).agregarPuntosAReputacion((15+rs.entregarRecompensa()));
			usuarioActivo.agregarPuntosAReputacion(2);
			System.out.println("\nSe ha aceptado la respuesta "+respuesta.getId()+".");
		}else {
			System.out.println("\n#NO ES POSIBLE ACEPTAR");
		}
	}
	
	
	public void accept(int idPregunta, int idRespuesta) {

		Pregunta pregunta = getPregunta(idPregunta);
		if(pregunta != null && pregunta.getEstado().equals("Abierta.")) {
			Recompensa recompensa = pregunta.getRecompensa();
			Respuesta respuesta = getRespuesta(pregunta, idRespuesta);
			aceptarRespuesta(respuesta, recompensa);
		}else {
			System.out.println("\n#PREGUNTA INEXISTENTE");
		}

	}
}