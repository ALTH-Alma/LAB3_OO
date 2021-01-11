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
	 * Entrega la lista con los nombres de los ofertores. 
	 * @return Una lista con los nombres de los usuarios que ofrecieron puntos por la recompensa.
	 */
	public List<String> getOfertores() {
		return ofertores;
	}
	
	/**
	 * Entraga una lista con los montos ofrecidos.
	 * @return Una lista con los montos ofrecidos por los usuarios. 
	 */
	public List<Integer> getMontosOfrecidosRetenidos() {
		return montosOfrecidosRetenidos;
	}

	public void aumentarRecompensa(int montoNewRecompensa, String autorRecompensa) {
		ofertores.add(autorRecompensa);
		montosOfrecidosRetenidos.add(montoNewRecompensa);
		montoRecompensa = montoRecompensa + montoNewRecompensa;		
	}
	
	public int entregarRecompensa() {
		if(ofertores.isEmpty() || ofertores == null) {
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
