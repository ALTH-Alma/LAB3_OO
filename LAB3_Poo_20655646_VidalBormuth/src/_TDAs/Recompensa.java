package _TDAs;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase para representar una recompensa en el stack.
 * Cada recompensa queda determinada por un monto total de recompensa, una lista de montos ofrecidos y una lista de los nombres
 * de los usuarios que ofrecieron la recompensa. 
 * @author Alma
 *
 */
public class Recompensa {
	
	private int montoRecompensa; //Monto total de la recompensa.
	private List<String> ofertores; //Lista con los nombres de los usuarios que ofrecieron la recompensa.
	private List<Integer> montosOfrecidosRetenidos; //Lista con los montos que ofrecieron cada uno de los usuarios. 
	
	
	/**
	 * Crea una nueva recompensa a partir de un monto de recompensa, una lista de los nombres de los ofertores
	 * y la una lista de los montos ofrecidos. 
	 * @param montoRecompensa Monto total de recompensa (igual o mayor que 0).
	 * @param ofertores Lista de nombres de los ofertores (Posee el mismo largo que la lista de montos).
	 * @param montosOfrecidosRetenidos Lista de montos ofrecidos (la suma de los montos coincide con el monto tota).
	 */
	public Recompensa(int montoRecompensa, List<String> ofertores, List<Integer> montosOfrecidosRetenidos) {
		super();
		this.montoRecompensa = montoRecompensa;
		this.ofertores = ofertores;
		this.montosOfrecidosRetenidos = montosOfrecidosRetenidos;
	}
	
	/**
	 * Inicializa una recompensa vacía.
	 */
	public Recompensa() {
		montoRecompensa = 0;
		ofertores = new ArrayList<String>();
		montosOfrecidosRetenidos = new ArrayList<Integer>();
	}
	
	/**
	 * Entrega el monto total de recompensa.
	 * @return Monto total de la recompensa.
	 */
	public int getMontoRecompensa() {
		return montoRecompensa;
	}
	
	/**
	 * Permite modificar el monto total de recompensa.
	 * @param montoRecompensa Monto total de recopensa (mayor o igual que 0).
	 */
	public void setMontoRecompensa(int montoRecompensa) {
		this.montoRecompensa = montoRecompensa;
	}
	
	/**
	 * Entrega la lista con los nombres de los ofertores. 
	 * @return Una lista con los nombres de los usuarios que ofrecieron puntos por la recompensa.
	 */
	public List<String> getOfertores() {
		return ofertores;
	}
	
	/**
	 * Permite modificar la lista de ofertores.
	 * @param ofertores Lista con nombres de ofertores. 
	 */
	public void setOfertores(List<String> ofertores) {
		this.ofertores = ofertores;
	}
	
	/**
	 * Entraga una lista con los montos ofrecidos.
	 * @return Una lista con los montos ofrecidos por los usuarios. 
	 */
	public List<Integer> getMontosOfrecidosRetenidos() {
		return montosOfrecidosRetenidos;
	}
	
	/**
	 * Permite modificar la lista de montos ofrecidos.s
	 * @param montosOfrecidosRetenidos  Lista con los montos ofrecidos.
	 */
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
