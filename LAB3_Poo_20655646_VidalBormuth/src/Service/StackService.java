package Service;

import java.util.List;

import _TDAs.Etiqueta;
import _TDAs.Pregunta;
import _TDAs.Recompensa;
import _TDAs.Respuesta;
import _TDAs.Stack;
import _TDAs.Usuario;

/**
 * Clase que representa los servicios que ofrece stack overflow a un usuario con sesión inicada. 
 * Esta determinado por un stack y un usuario Activo. 
 * @author Alma
 *
 */
public class StackService {
	private final Stack stack; //Stack con el que se trabaja.
	private Usuario usuarioActivo; //Usuario Activo que realiza cambios en el stack. 

	/**
	 * Crea un stackService en base a un satck y un usuario activo.
	 * @param stack Stack con el que se trabaja.
	 * @param usuarioActivo Usuario Activo que realiza cambios en stack.
	 */
	public StackService(Stack stack, Usuario usuarioActivo) {
		this.stack = stack;
		this.usuarioActivo = usuarioActivo;
	}
	
	/**
	 * Entrega el usuario activo de StackService.
	 * @return Usuario activo.
	 */
	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	/**
	 * Modifica al usuario activo del StackService.
	 * @param usuarioActivo Nuevo usuario activo.
	 */
	public void setUsuarioActivo(Usuario usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}

	/**
	 * Entrega el stack de StackService.
	 * @return Stack.
	 */
	public Stack getStack() {
		return stack;
	}
	
	
	/**
	 * Enceuntra y entrega una pregunta en la lista de preguntas segun su id.
	 * @param idPregunta Identificador de la pregunta buscada.
	 * @return Pregunta del id si es que se encuentra. 
	 */
	private Pregunta getPregunta(int idPregunta) {
		
        for(Pregunta pregunta: stack.getPreguntas()){
			if(pregunta.getId() == idPregunta) {
				return pregunta;
			}
        }
        return null;
	}
	
	/**
	 * Encuentra y entrega una respuestas de una pregunta segun su id.
	 * @param pregunta Pregunta donde se encuentra la respuesta.
	 * @param idRespuesta //Identificador de la respuesta que se busca.
	 * @return Respuesta buscada.
	 */
	private Respuesta getRespuesta(Pregunta pregunta, int idRespuesta) {
	
        for(Respuesta respuesta: pregunta.getRespuestas()){
			if(respuesta.getId() == idRespuesta) {
				return respuesta;
			}
        }
        return null;
		
	}

	/**
	 * Permite que un usuario activo desactive su sesión. 
	 * @param userName Nombre del usuario activo.
	 * @param userPass Clave del usuario activo.
	 */
	public void logout(String userName, String userPass) {
		
		if(usuarioActivo != null && usuarioActivo.getName().equals(userName) && usuarioActivo.getPass().equals(userPass)) {//Si los datos corresponden al usuario...
			usuarioActivo = null; //Se cierra sesión y usario activo vacio.
			System.out.println("El usuario "+userName+" a cerrado sesión !!!");
		}else {
		System.out.println("#NO EXISTE USUARIO ACTIVO PARA CERRAR SESIÓN.");
		}
	}
	
	
	/**
	 * Le permite a un usuario realizar una nueva pregunta en un stack. Agrega una pregunta a la lista de preguntas del stack.
	 * @param newTitulo Titulo de la nueva pregunta.
	 * @param newContenido Contenido de la nueva pregunta.
	 * @param newEtiquetas Lista de etiquetas para la nueva pregunta. 
	 */
	public void ask(String newTitulo, String newContenido, List<Etiqueta> newEtiquetas) {
		
		stack.getPreguntas().add(new Pregunta(usuarioActivo.getName(), newTitulo, newContenido, newEtiquetas));
		System.out.println("\nSe a agregado una nueva pregunta.\n");

	}
	
	
	/**
	 * Le permite a un usuario con sesión activa responde una pregunta abierta en el stack. 
	 * @param idPregunta Identificador de la pregunta que se quiere responder. 
	 * @param contenidoRespuesta Contenido de la nueva respuesta.
	 */
	public void answer(int idPregunta, String contenidoRespuesta) {
        
        Pregunta pregunta = getPregunta(idPregunta);
        if(pregunta != null && pregunta.getEstado().equals("Abierta.")) { //Si existe la pregunta y esta abierta
        	pregunta.getRespuestas().add(new Respuesta(usuarioActivo.getName(), contenidoRespuesta)); //Se le agrega una respuesta a su lista de respuestas.
        	System.out.println("\nHa entragado una respuesta a la pregunta "+idPregunta+".\n");
        }else {
        	System.out.println("\n#NO SE A PODIDO REALIZAR LA RESPUESTA. Id inexistente.\n"); //Sino no hace nada.
        }		
	}
	
	
	/**
	 * Permite agregar una recompensa por una pregunta. Actualiza reputación del ofertor. 
	 * @param pregunta Pregunta a la que se le entrega la recompensa.
	 * @param montoRecompensa Monto que se le agrega a la recompensa (Debe der menor que la reputación actual del usuario al realizarce).
	 * @param reputacionUA //Reputacion del usuario activo que agrega la recompensa.
	 */
	public void entregarRecompensa(Pregunta pregunta, int montoRecompensa, int reputacionUA) {
		
		RecompensaService rs = new RecompensaService(pregunta.getRecompensa());
		rs.aumentarRecompensa(montoRecompensa, usuarioActivo.getName()); //Se realiza la recompensa.
		usuarioActivo.setReputacion(reputacionUA-montoRecompensa); //se actualiza reputacion de usuario activo.
		System.out.println("\nHa ofrecido una recompensa de "+montoRecompensa+" puntos por la pregunta "+pregunta.getId()+" !!!");
	}
	
	/**
	 * Le permite a un usuario con sesión activa entrgar una recompensa por una pregunta abierta.
	 * @param idPregunta Identificador de la pregunta a la que se le quiere agregar recompensa. 
	 * @param montoRecompensa Monto a agregar en la recompensa (debe ser menor que la reputación
	 * del usuario activo.
	 */
	public void reward(int idPregunta, int montoRecompensa) {
		
		int reputacionUA = usuarioActivo.getReputacion(); 
		if(reputacionUA >= montoRecompensa) {//Si la recompensa es menor que la reputacion de UA...
			Pregunta pregunta = getPregunta(idPregunta); 
			if(pregunta != null && pregunta.getEstado().equals("Abierta.")) {//Y si la pregunta con el id existe y esta abierta.
				entregarRecompensa(pregunta, montoRecompensa, reputacionUA); //Se entrega la recompensa.
			}else {
				System.out.println("#ID DE PREGUNTA INCORRECTO. No se pudo ofrecer la recompensa");
			}
		}else {
			System.out.println("\n#REPUTACIÓN INSUFICIENTE. No puede ofrecer esta recompensa."); //Sino no hace nada.
		}
		
	}

	
	/**Permite tomar un usuario de la lista de usuarios del usuarios en el stack segun su nombre.
	 * @param userName Nombre del usuario que se busca.
	 * @return Usuario buscado si se encuentra sino vacio.
	 */
	private Usuario tomarUser(String userName) {
		
		for(Usuario user: stack.getUsuarios()) {
			if(user.getName().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	/**Permite aceptar una respuesta y modificar recompensas segun lo establecido por stack overflow.
	 * @param respuesta Respuesta  que se quiere aceptar.
	 * @param recompensa Recompensa por la pregunta a la que corresponde la respuesta. 
	 */
	private void aceptarRespuesta(Respuesta respuesta, Recompensa recompensa) {
		RecompensaService rs = new RecompensaService(recompensa);
		if(respuesta != null && respuesta.getEstado().equals("Pendiente.")) {//Si la respuesta existe y su estado es pendiente.
			respuesta.setEstado("Aceptada."); //Se acepta la respuesta.
			tomarUser(respuesta.getAutor()).agregarPuntosAReputacion((15+rs.entregarRecompensa())); //Se actualiza reputacion de autor de la respuesta.
			usuarioActivo.agregarPuntosAReputacion(2);//Se actualiza reputación del usuario Activo.
			System.out.println("\nSe ha aceptado la respuesta "+respuesta.getId()+".");
		}else {
			System.out.println("\n#NO ES POSIBLE ACEPTAR");
		}
	}
	
	/**
	 * Permite a un usuario con sesión activa  aceptar una respuesta de una de sus preguntas.
	 * @param idPregunta Identificador de la pregunta a la que corresponde la respuestas. 
	 * @param idRespuesta Identificador de la respuesta a aceptar. 
	 */
	public void accept(int idPregunta, int idRespuesta) {

		Pregunta pregunta = getPregunta(idPregunta);
		if(pregunta != null && pregunta.getEstado().equals("Abierta.")) { //Si la pregunta existe y esta abierta
			Recompensa recompensa = pregunta.getRecompensa();
			Respuesta respuesta = getRespuesta(pregunta, idRespuesta);
			aceptarRespuesta(respuesta, recompensa); //Se acepta la respuesta tomando como parametros la respuesta y la recompensa de la pregunta.
		}else {
			System.out.println("\n#PREGUNTA INEXISTENTE"); //Sino no se hace nada.
		}

	}
}
