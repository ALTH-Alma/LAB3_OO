package _TDAs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comun_Res_Preg {
	
	private int id;
	private String autor;
	private String contenido;
	private String fechaDePublicacion;
	private String estado;
	private int votosAFavor;
	private int votosEnContra;
	private int reportes;
	
	public Comun_Res_Preg(String autor, String contenido) {
		
		this.autor = autor;
		this.contenido = contenido;
		DateFormat df = new SimpleDateFormat("dd,MM,yyyy HH:mm");
		Date fecha= new Date();
		fechaDePublicacion = df.format(fecha);
		this.votosAFavor = 0;
		this.votosEnContra = 0;
		this.reportes = 0;
	}
	
	
	public Comun_Res_Preg(String autor, String contenido, String estado,
			int votosAFavor, int votosEnContra, int reportes) {
		
		this.autor = autor;
		this.contenido = contenido;
		DateFormat df = new SimpleDateFormat("dd,MM,yyyy HH:mm");
		Date fecha= new Date();
		fechaDePublicacion = df.format(fecha);
		this.estado = estado;
		this.votosAFavor = votosAFavor;
		this.votosEnContra = votosEnContra;
		this.reportes = reportes;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFechaDePublicacion() {
		return fechaDePublicacion;
	}

	public void setFechaDePublicacion(String fechaDePublicacion) {
		this.fechaDePublicacion = fechaDePublicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getVotosAFavor() {
		return votosAFavor;
	}

	public void setVotosAFavor(int votosAFavor) {
		this.votosAFavor = votosAFavor;
	}

	public int getVotosEnContra() {
		return votosEnContra;
	}

	public void setVotosEnContra(int votosEnContra) {
		this.votosEnContra = votosEnContra;
	}

	public int getReportes() {
		return reportes;
	}

	public void setReportes(int reportes) {
		this.reportes = reportes;
	}
	
	public void mostrarComun() {
		
		System.out.println("Contenido:\n "+contenido+"\nAutor: "+autor+"\nFecha publicación: "+fechaDePublicacion+
				"\nEstado: "+estado+"\nVotos a favor: "+votosAFavor+"\nVotos en contra: "+votosEnContra+"\nNúmero de reportes: "+reportes);
		
	}
	

}
