package _TDAs;

public class Etiqueta {
	
	private String name;
	private String descripcion;
	
	//Constructor.
	public Etiqueta(String name, String descripcion) {
		this.name = name;
		this.descripcion = descripcion;
	}
	
	//Getter y Setter del nombre de la etiqueta.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Getter y Setter de la descripción de la etiqueta.
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void mostrarEtiqueta() {
		System.out.println(name+":");
		System.out.println(descripcion+"\n");
	}
	

}
