package notificacion.entities;

public class selecteme {
	
	private String codigo;
	private String nombre;
	private String idCiudad;
	
	
	public selecteme(String codigo,String nombre, String idCiudad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.idCiudad = idCiudad;
		
	}
	public String getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
