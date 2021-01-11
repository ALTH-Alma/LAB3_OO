package _TDAs;

public class Stack  {
	
	private static int count3 = 0;
	private int idStack;
	private Usuarios usuarios;
	private Preguntas preguntas;
	private Etiquetas etiquetas;
	
	public Stack(Usuarios usuarios, Preguntas preguntas, Etiquetas etiquetas) {
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
	
	public Etiquetas getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Etiquetas etiquetas) {
		this.etiquetas = etiquetas;
	}

	public void mostrarStack() {
		
		System.out.println("Stack Overflow "+idStack);
		usuarios.mostrarUsuarioActivo();
		usuarios.mostrarUsuarios_Todos();
		preguntas.mostrarPreguntas_Todas();
		
	}

	
	public void answer(int idPregunta, String contenidoRespuesta) {
        
        Pregunta pregunta = preguntas.getPreguntaStack_ID(idPregunta);
        if(pregunta != null) {
        	pregunta.getRespuestas().add(new Respuesta(usuarios.getUsuarioActivo().getName(), contenidoRespuesta));
        	System.out.println("\nHa entragado una respuesta a la pregunta "+idPregunta+".\n");
        }else {
        	System.out.println("\n#NO SE A PODIDO REALIZAR LA RESPUESTA. Id inexistente.\n");
        }		
	}
	
	public void reward(int idPregunta, int montoRecompensa) {

		int reputacionUA = usuarios.getUsuarioActivo().getReputacion();
		if(reputacionUA >= montoRecompensa) {
			preguntas.getPreguntaStack_ID(idPregunta).getRecompensa().setRecompensa(montoRecompensa, usuarios.getUsuarioActivo().getName());
			usuarios.getUsuarioActivo().setReputacion(reputacionUA-montoRecompensa);
			System.out.println("\nHa ofrecido una recompensa de "+montoRecompensa+" puntos por la pregunta "+idPregunta+" !!!");
		}else {
			System.out.println("\n#REPUTACIÓN INSUFICIENTE. No puede ofrecer esta recompensa.");
		}
		
	}
	
	public void accept(int idPregunta, int idRespuesta) {

		Pregunta pregunta = preguntas.getPreguntaStack_ID(idPregunta);
		if(pregunta != null) {
			Respuesta respuesta = pregunta.getRespuesta_ID(idRespuesta);
			if(respuesta != null && respuesta.getEstado().equals("Pendiente.")) {
				respuesta.setEstado("Aceptada.");
				Usuario autorRespuesta = usuarios.getUser_Name(respuesta.getAutor());
				autorRespuesta.agregarPuntosAReputacion((15+pregunta.getRecompensa().tomarRecompensa()));
				usuarios.getUsuarioActivo().agregarPuntosAReputacion(2);
			}else {
				System.out.println("\n#NO ES POSIBLE ACEPTAR");
			}
		}else {
			System.out.println("\n#PREGUNTA INEXISTENTE");
		}

	}

	
}

