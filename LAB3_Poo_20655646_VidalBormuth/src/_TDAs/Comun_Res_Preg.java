package _TDAs;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Comun_Res_Preg {
	
	private static int id = 0;
	private String autor;
	private Date fechaDePublicacion;
	private int votosAFavor;
	private int votosEnContra;
	private int reportes;
	private List<Etiqueta> etiquetas;
	
	public Comun_Res_Preg(String autor, Date fechaDePublicacion, int votosAFavor, int votosEnContra, int reportes,
			List<Etiqueta> etiquetas) {
		super();
		this.autor = autor;
		fechaDePublicacion = new Date();
		this.votosAFavor = votosAFavor;
		this.votosEnContra = votosEnContra;
		this.reportes = reportes;
		etiquetas = new ArrayList<>();
	}

}
