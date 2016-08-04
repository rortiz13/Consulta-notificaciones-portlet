package notificacion.entities;

import java.io.Serializable;

public class selecMete implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	
	public selecMete(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public selecMete() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString(){
		return "id Ciudad: "+codigo+"\nNombre: "+nombre;
	}
}
