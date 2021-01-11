package _TDAs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa los elementos qu tienen en común una respuesta y una pregunta.
 * Esta clase es heredada por la clase Pregunta y la clase Respuesta.
 * Esta clase queda determinada por un identificador númerico, el nombre de autor, un contenido, una fecha de publicación, un estado, una cantidad de votos a favor, 
 * cantidad de votos en contra y cantidad de reportes. 
 * @author Alma
 *
 */
public class ComunResPreg {
	
	private int id; //Identificador númerico del objeto. 
	private String autor; //Nombre de autor.
	private String contenido; //Contenido.
	private String fechaDePublicacion; //Fecha de publicación.
	private String estado; //Estado.
	private int votosAFavor; //Cantidad de votos a favor (Mayor o igual a 0).
	private int votosEnContra; //Cantidad de votos en contra (Mayor o igual a 0).
	private int reportes; //Cantidad de reportes (Mayor o igual a 0).
	
	/**
	 * Crea un nuevo objeto ComunResPreg a partir de un nombre de autor y un contenido.
	 * @param autor Nombre del autor del contenido.
	 * @param contenido Contenido.
	 */
	public ComunResPreg(String autor, String contenido) {
		
		this.autor = autor;
		this.contenido = contenido;
		DateFormat df = new SimpleDateFormat("dd,MM,yyyy HH:mm"); //Se crea un formato para la fecha.
		Date fecha= new Date(); //Se obtiene la fecha del sistema.
		fechaDePublicacion = df.format(fecha); //Se le aplica el formato a la fecha obtenida. 
		//La cantidad de votos a favor, en contra y reportes empiezan desde 0.
		this.votosAFavor = 0;
		this.votosEnContra = 0;
		this.reportes = 0;
	}
	
	
	/**
	 * Crea un nuevo objeto ComResPreg a partir de todos sus atributos, a excepción de la fecha de publicación y el id único.
	 * @param autor Nombre del autor del contenido.
	 * @param contenido Contenido.
	 * @param estado Estado en el que se encuentra. 
	 * @param votosAFavor Cantidad de votos a favor (Mayor o igual a 0).
	 * @param votosEnContra Cantidad de votos en contra (Mayor o igual a 0).
	 * @param reportes Cantidad de reportes (Mayor o igual a 0).
	 */
	public ComunResPreg(String autor, String contenido, String estado,
			int votosAFavor, int votosEnContra, int reportes) {
		
		this.autor = autor;
		this.contenido = contenido;
		DateFormat df = new SimpleDateFormat("dd,MM,yyyy HH:mm"); //Se crea un formato para la fecha.
		Date fecha= new Date(); //Se obtiene la fecha del sistema.
		fechaDePublicacion = df.format(fecha); //Se le aplica el formato a la fecha obtenida. 
		this.estado = estado;
		this.votosAFavor = votosAFavor;
		this.votosEnContra = votosEnContra;
		this.reportes = reportes;
	}


	/**
	 * Entrega el indentificador númerico del objeto. 
	 * @return Identificador númerico del objeto. 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Permite modificar el id del objeto.
	 * @param id Identificador númerico.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Entrega el nombre del autor del objeto. 
	 * @return Nombre del autor.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Permite modificar el nombre del autor del objeto. 
	 * @param autor Nombre de usuario.
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Entrega el contenido del objeto.
	 * @return Contenido del objeto.
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * Permite modificar el contenido de la pregunta. 
	 * @param contenido Un string de contenido.
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * Entrega la fecha de publicación del objeto.
	 * @return Fecha de publicación del objeto.
	 */
	public String getFechaDePublicacion() {
		return fechaDePublicacion;
	}

	/**
	 * Permite modificar la fecha de publicación del objeto.
	 * @param fechaDePublicacion Una fecha.
	 */
	public void setFechaDePublicacion(String fechaDePublicacion) {
		this.fechaDePublicacion = fechaDePublicacion;
	}

	/**
	 * Entrega el estado en el que se encuentra el objeto.
	 * @return Estado del objeto.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Permite modificar el estado de un objeto.
	 * @param estado Nuevo estado del objeto.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Entraga la cantidad de votos a favor del objeto.
	 * @return Cantidad de votos a favor.
	 */
	public int getVotosAFavor() {
		return votosAFavor;
	}

	/**
	 * Permite modificar la cantidad de votos a favor del objeto.
	 * @param votosAFavor Nueva cantidad de votos a favor.
	 */
	public void setVotosAFavor(int votosAFavor) {
		this.votosAFavor = votosAFavor;
	}
	
	/**
	 * Entraga la cantidad de votos en contra del objeto.
	 * @return Cantidad de votos en contra.
	 */
	public int getVotosEnContra() {
		return votosEnContra;
	}
	
	/**
	 * Permite modificar la cantidad de votos en contra del objeto.
	 * @param votosEncontra Nueva cantidad de votos en contra.
	 */
	public void setVotosEnContra(int votosEnContra) {
		this.votosEnContra = votosEnContra;
	}

	/**
	 * Entraga la cantidad de reportes del objeto.
	 * @return Cantidad de reportes.
	 */
	public int getReportes() {
		return reportes;
	}
	
	/**
	 * Permite modificar la cantidad de reportes del objeto.
	 * @param reportes Nueva cantidad de reportes.
	 */
	public void setReportes(int reportes) {
		this.reportes = reportes;
	}
	
	
	/**
	 * Muestra el objeto comunResPreg
	 */
	public void mostrarComun() {
		
		System.out.println("Contenido:\n "+contenido+"\nAutor: "+autor+"\nFecha publicación: "+fechaDePublicacion+
				"\nEstado: "+estado+"\nVotos a favor: "+votosAFavor+"\nVotos en contra: "+votosEnContra+"\nNúmero de reportes: "+reportes);
		
	}
	

}
