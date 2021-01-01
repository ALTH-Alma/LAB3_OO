package _TDAs;

import java.util.Date;

public class Comun_Res_Preg {
	
	protected int id;
	private String autor;
	private String contenido;
	private Date fechaDePublicacion;
	protected String estado;
	private int votosAFavor;
	private int votosEnContra;
	private int reportes;
	
	public Comun_Res_Preg(String autor, String contenido) {
		
		this.autor = autor;
		this.contenido = contenido;
		fechaDePublicacion = new Date();
		this.votosAFavor = 0;
		this.votosEnContra = 0;
		this.reportes = 0;
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

	public Date getFechaDePublicacion() {
		return fechaDePublicacion;
	}

	public void setFechaDePublicacion(Date fechaDePublicacion) {
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
		
		System.out.println("Contenido:\n "+contenido);
		System.out.println("Autor: "+autor);
		System.out.println("Fcha publicación: "+fechaDePublicacion);
		System.out.println("Estado: "+estado);
		System.out.println("Votos a favor: "+votosAFavor);
		System.out.println("Votos en contra: "+votosEnContra);
		System.out.println("Número de reportes: "+reportes);
		
	}

}
