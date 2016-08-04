package notificacion.entities;

public class ListaNotificacion {
	private String idNotificacion;
	private String idNotificacionTipo;
	private String codigo;
	private String idRelacionEntidad;
	private String ciudad;
	private selecItem tipo;
	
	
	
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public selecItem getTipo() {
		return tipo;
	}
	public void setTipo(selecItem tipo) {
		this.tipo = tipo;
	}
	public selecteme getEntidad() {
		return entidad;
	}
	public void setEntidad(selecteme entidad) {
		this.entidad = entidad;
	}
	private selecteme entidad;
	
	public String getIdNotificacion() {
		return idNotificacion;
	}
	public void setIdNotificacion(String idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public String getIdNotificacionTipo() {
		return idNotificacionTipo;
	}
	public void setIdNotificacionTipo(String idNotificacionTipo) {
		this.idNotificacionTipo = idNotificacionTipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getIdRelacionEntidad() {
		return idRelacionEntidad;
	}
	public void setIdRelacionEntidad(String idRelacionEntidad) {
		this.idRelacionEntidad = idRelacionEntidad;
	}
	public ListaNotificacion(	String idNotificacion,
								String idNotificacionTipo,
								String codigo,
								String idRelacionEntidad,
								String ciudad,
								selecItem tipo,
								selecteme entidad) {
		this.idNotificacion = idNotificacion;
		this.idNotificacionTipo = idNotificacionTipo;
		this.codigo = codigo;
		this.idRelacionEntidad = idRelacionEntidad;
		this.entidad=entidad;
		this.tipo = tipo;
		this.ciudad= ciudad;
		
	}
	@Override
	public String toString(){
		return "idNotificacion: "+idNotificacion+"" +
				"\nCodigo: "+codigo+"" +
			    "\nTipo: ("+tipo.getCodigo()+":"+tipo.getNombre()+")" +
			    "\nEntidad: ("+entidad.getCodigo()+":"+entidad.getNombre()+")";
		
	}

}
