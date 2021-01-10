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
	
	public void ask(String newTitulo, String newContenido, Etiquetas newEtiquetas) {
		
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
	
	public void accept(int idPregunta, int idRespuesta) {

		Pregunta pregunta = preguntas.getPreguntaStack_ID(idPregunta);
		Respuesta respuesta = pregunta.getRespuesta_ID(idRespuesta);

		if(respuesta != null) {
			respuesta.setEstado("Aceptada.");

			Usuario autorRespuesta = usuarios.getUser_Name(respuesta.getAutor());
			autorRespuesta.mostrarUsuario();
			autorRespuesta.agregarPuntosAReputacion((14+pregunta.getRecompensa().tomarRecompensa()));
			usuarios.getUsuarioActivo().agregarPuntosAReputacion(2);
		}
	}

}

