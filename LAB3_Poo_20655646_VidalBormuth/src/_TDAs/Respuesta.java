package _TDAs;

public class Respuesta extends Comun_Res_Preg {
	
	private static int count1 = 0;
	
	public Respuesta(String autor, String contenido) {
		super(autor, contenido);
		setId(++count1);
		this.estado = "Pendiente.";
	}
	

}