package Service;

import _TDAs.Recompensa;

/**
 * Clase que representa los servicios que brinda una recompensa. 
 * Esta clase queda determinada por una recompensa. 
 * @author Alma
 *
 */
public class RecompensaService {

	private Recompensa recompensa; //Recompensa con la que se trabajara. 

	/**
	 * Crea un RecompensaService. 
	 * @param recompensa Recompensa con la que se trabaja.
	 */
	public RecompensaService(Recompensa recompensa) {
		this.recompensa = recompensa;
	}

	/**
	 * Entrega la recompensa de RecompensaService.
	 * @return La recompensa.
	 */
	public Recompensa getRecompensa() {
		return recompensa;
	}

	/**
	 * Permite modificar la recompensa.
	 * @param recompensa Nueva recompensa. 
	 */
	public void setRecompensa(Recompensa recompensa) {
		this.recompensa = recompensa;
	}
	
	/**
	 * Aumenta una recompensa, incrementanda el monto total con el monto de la nueva recompensa, una el monto a la lista de montos retenidos
	 * y agrega el nombre del usuario que realiza la nueva recompensa en el lista de ofertores.
	 * @param montoNewRecompensa Monto de la nueva recompensa a agregar a la recompensa actual. 
	 * @param autorRecompensa Nombre del autor de esta nueva recompensa. 
	 */
	public void aumentarRecompensa(int montoNewRecompensa, String autorRecompensa) {
		recompensa.getOfertores().add(autorRecompensa); //Agrega el nombre del ofertor en la lista de ofertores.
		recompensa.getMontosOfrecidosRetenidos().add(montoNewRecompensa); //Agrega la nueva recompensa a la lista de montos retenidos. 
		recompensa.setMontoRecompensa(recompensa.getMontoRecompensa()+montoNewRecompensa);//Incrementa el monto total de la recompensa. 
	}
	
	/**
	 * Entrega una recompensa, entregando el monto total, eliminando los montos retenidos de la lista de montos y los 
	 * nombres de los ofertores de la lista de ofertores. La recompensa se vacia, por lo tanto, monto total es igual a 0. 
	 * @return El monto total de la recompensa. 
	 */
	public int entregarRecompensa() {
		if(recompensa.getOfertores().isEmpty() || recompensa.getOfertores() == null){
			return 0; //Si no existe una lista de ofertores, entonces no existe recompensa, montoTotal = 0.
		}else { //Sino
			recompensa.getOfertores().clear(); //Se eliminan nombre de ofertores.
			recompensa.getMontosOfrecidosRetenidos().clear(); //Se eliminan montos retenidos.
			int aux= recompensa.getMontoRecompensa();
			recompensa.setMontoRecompensa(0);
			return aux; //Se entrega y vacia el monto total de la recompensa.
		}
	}
	
}
