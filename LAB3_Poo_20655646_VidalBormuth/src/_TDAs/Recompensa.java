package _TDAs;

import java.util.ArrayList;
import java.util.List;

public class Recompensa {
	
	private int montoRecompensa;
	private List<String> ofertores;
	private List<Integer> montosOfrecidosRetenidos;
	
	public Recompensa(int montoRecompensa, List<String> ofertores, List<Integer> montosOfrecidosRetenidos) {
		super();
		this.montoRecompensa = montoRecompensa;
		this.ofertores = ofertores;
		this.montosOfrecidosRetenidos = montosOfrecidosRetenidos;
	}
	public Recompensa() {
		montoRecompensa = 0;
		ofertores = new ArrayList<String>();
		montosOfrecidosRetenidos = new ArrayList<Integer>();
	}
	public int getMontoRecompensa() {
		return montoRecompensa;
	}
	public void setMontoRecompensa(int montoRecompensa) {
		this.montoRecompensa = montoRecompensa;
	}
	public List<String> getOfertores() {
		return ofertores;
	}
	public void setOfertores(List<String> ofertores) {
		this.ofertores = ofertores;
	}
	public List<Integer> getMontosOfrecidosRetenidos() {
		return montosOfrecidosRetenidos;
	}
	public void setMontosOfrecidosRetenidos(List<Integer> montosOfrecidosRetenidos) {
		this.montosOfrecidosRetenidos = montosOfrecidosRetenidos;
	}
	
	public void setRecompensa(int montoNewRecompensa, String autorRecompensa) {
		ofertores.add(autorRecompensa);
		montosOfrecidosRetenidos.add(montoNewRecompensa);
		montoRecompensa = montoRecompensa + montoNewRecompensa;		
	}
	
	public int tomarRecompensa() {
		if(ofertores.isEmpty()) {
			return 0; //no existe recompensa.
		}else {
			ofertores.clear();
			montosOfrecidosRetenidos.clear();
			int aux= montoRecompensa;
			montoRecompensa = 0;
			return aux;
		}
	}
	
}
