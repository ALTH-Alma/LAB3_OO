package _TDAs;

public class Respuesta extends Comun_Res_Preg {
	
	private static int count1 = 0;
	
	public Respuesta(String autor, String contenido) {
		super(autor, contenido);
		setId(++count1);
		setEstado("Pendiente.");
	}
	
	public Respuesta(String autor, String contenido, String estado, int votosAFavor, int votosEnContra, int reportes) {
		super(autor, contenido, estado, votosAFavor, votosEnContra, reportes);
		setId(++count1);
	}


	@Override
	public void mostrarComun() {
		
		System.out.println("ID Respuesta: "+getId());
		super.mostrarComun();	
		System.out.println("\n");
	}
	

}
