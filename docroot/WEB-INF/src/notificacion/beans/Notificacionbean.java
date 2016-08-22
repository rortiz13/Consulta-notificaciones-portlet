package notificacion.beans;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import notificacion.entities.ListaNotificacion;
import notificacion.entities.selecItem;
import notificacion.entities.selecMete;
import notificacion.entities.selecteme;


import notificacion.controller.Controller;

import com.liferay.util.bridges.jsf.common.FacesMessageUtil;

@ManagedBean(name = "Notificacionbean")
@ViewScoped
public class Notificacionbean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idNotificacionCodigo;
	private String idNotificacionTipo;
	private String codigo;
	private String ciudadSeleccionada;
	private String idRelacionEntidad;
	private List<selecItem> idNotificacionTipos;
	private List<SelectItem> notificacionTipos;
	private List<selecteme> idRelacionEntidades;
	private List<SelectItem> relacionEntidades;
	private List<selecteme> idRelacionEntidadesOrg;
	private List<selecItem> RelacionEntidadesOrg;
	private List<selecMete> ciudades;
	private List<SelectItem> ciudadesNuevas;
	private List<SelectItem> ciudadesItems;
	private List<ListaNotificacion> listado;
	private ListaNotificacion actual;
	private selecMete ciudad;
	private selecMete ciudadActual;
	private String descripcion;
	
	public List<SelectItem> getCiudadesNuevas() {
		return ciudadesNuevas;
	}

	public void setCiudadesNuevas(List<SelectItem> ciudadesNuevas) {
		this.ciudadesNuevas = ciudadesNuevas;
	}

	public List<SelectItem> getNotificacionTipos() {
		return notificacionTipos;
	}

	public void setNotificacionTipos(List<SelectItem> notificacionTipos) {
		this.notificacionTipos = notificacionTipos;
	}

	public void setIdRelacionEntidades(List<selecteme> idRelacionEntidades) {
		this.idRelacionEntidades = idRelacionEntidades;
	}

	public List<selecteme> getIdRelacionEntidadesOrg() {
		return idRelacionEntidadesOrg;
	}

	public void setIdRelacionEntidadesOrg(List<selecteme> idRelacionEntidadesOrg) {
		this.idRelacionEntidadesOrg = idRelacionEntidadesOrg;
	}

	public String getCiudadSeleccionada() {
		return ciudadSeleccionada;
	}

	public void setCiudadSeleccionada(String ciudadSeleccionada) {
		this.ciudadSeleccionada = ciudadSeleccionada;
	}
	
	public selecMete getCiudadActual() {
		return ciudadActual;
	}

	public void setCiudadActual(selecMete ciudadActual) {
		this.ciudadActual = ciudadActual;
	}

	public selecMete getCiudad() {
		return ciudad;
	}

	public void setCiudad(selecMete ciudad) {
		System.out.println("entrando");
		this.ciudad = ciudad;
	}

	public List<selecMete> getCiudades() {
		return ciudades;
	}

	public void filtrarEntidades() {
		idRelacionEntidades = new ArrayList<selecteme>();
		relacionEntidades = new ArrayList<SelectItem>();
		if(ciudadSeleccionada!=null && !ciudadSeleccionada.equals("")){
			for(selecteme ent: idRelacionEntidadesOrg)
			{
				if(ent.getIdCiudad().equals(ciudadSeleccionada)){
					idRelacionEntidades.add(new selecteme(ent.getCodigo(), ent.getNombre(), ent.getIdCiudad()));
					relacionEntidades.add(new SelectItem(ent.getCodigo(), ent.getNombre(), ent.getIdCiudad()));
				}					
			}
			
		}else{
			System.out.println("NADA");
		}
		System.out.println(idRelacionEntidades.size());
	}

	public void filtrarEntidadesEditar() {
		System.out.println("Entro a Filtrar Entidades Editar");
		idRelacionEntidades = new ArrayList<selecteme>();
		relacionEntidades = new ArrayList<SelectItem>();
		ciudadSeleccionada = actual.getEntidad().getIdCiudad();
		actual.getEntidad().setIdCiudad("");
		if(ciudadSeleccionada!=null && !ciudadSeleccionada.equals("")){
			for(selecteme ent: idRelacionEntidadesOrg)
			{
				if(ent.getIdCiudad().equals(ciudadSeleccionada))
				{
					idRelacionEntidades.add(ent);
					System.out.println("VALOR: "+ent.getCodigo()+" - "+ent.getNombre()+" - "+ent.getIdCiudad());
				}
			}
			
		}else{
			System.out.println("NADA");
		}
		System.out.println(idRelacionEntidades.size());
	}

	public void setCiudades(List<selecMete> ciudades) {
		this.ciudades = ciudades;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ListaNotificacion getActual() {
		return actual;
	}

	public void setActual(ListaNotificacion actual) {
		this.actual = getNotificacion(actual.getIdNotificacion());
		this.actual.setTipo(getTipoNombre(this.actual.getIdNotificacionTipo()));
		this.actual.setEntidad(getEntidad(this.actual.getIdRelacionEntidad()));
		ciudadSeleccionada = actual.getEntidad().getIdCiudad();
		ciudadActual = getCiudad(ciudadSeleccionada);
		filtrarEntidades();
		System.out.println(this.actual);
	}

	public List<ListaNotificacion> getListado() {
		return listado;
	}

	public void setListado(List<ListaNotificacion> listado) {
		this.listado = listado;
	}

	public List<selecItem> getIdNotificacionTipos() {
		return idNotificacionTipos;
	}

	public void setIdNotificacionTipos(List<selecItem> idNotificacionTipos) {
		this.idNotificacionTipos = idNotificacionTipos;
	}

	public List<selecteme> getIdRelacionEntidades() {
		return idRelacionEntidades;
	}

	public void setIdRelacionEntidas(List<selecteme> idRelacionEntidades) {
		this.idRelacionEntidades = idRelacionEntidades;
	}

	public String getIdNotificacionCodigo() {
		return idNotificacionCodigo;
	}

	public void setIdNotificacionCodigo(String idNotificacionCodigo) {
		this.idNotificacionCodigo = idNotificacionCodigo;
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

	public Notificacionbean() throws SQLException {
		idNotificacionTipos = new ArrayList<selecItem>();
		notificacionTipos = new ArrayList<SelectItem>();
		ResultSet rs1 = Controller.selecNotificacionTipo();
		selecTipo(rs1);
		idRelacionEntidadesOrg = new ArrayList<selecteme>();
		ResultSet rs = Controller.selecRelacion();
		slectRela(rs);
		ciudades = new ArrayList<selecMete>();
		ciudadesNuevas = new ArrayList<SelectItem>();
		ResultSet rs2 =Controller.selecCiudad();
		selecCiudad(rs2);
		ciudadActual = new selecMete();

	}
	
	public void cargarRelacion(){
		System.out.println("entro en cargar relacion");
		idNotificacionTipos = new ArrayList<selecItem>();
		ResultSet rs1 = Controller.selecNotificacionTipo();
		selecTipo(rs1);
		idRelacionEntidadesOrg = new ArrayList<selecteme>();
		ResultSet rs = Controller.selecRelacion();
		slectRela(rs);
		ciudades = new ArrayList<selecMete>();
		ciudadesNuevas = new ArrayList<SelectItem>();
		ResultSet rs2 =Controller.selecCiudad();
		selecCiudad(rs2);
		ciudadActual = new selecMete();
	}
	
	private void selecCiudad(ResultSet result) {
		try {
			if (result != null) {
				for (; result.next(); ciudadesNuevas.add(new SelectItem(
						result.getString(1), result.getString(2)))) {
				}
			} else {
				System.out.println("no ahy coincidencias de busqueda");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void selecTipo(ResultSet result) {
		try {
			if (result != null) {
				for (; result.next(); notificacionTipos.add(new SelectItem(
						result.getString(1), result.getString(2)))) {
				}
			} else {
				System.out.println("no ahy coincidencias de busqueda");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void slectRela(ResultSet result) {
		try {
			if (result != null) {
				for (; result.next(); idRelacionEntidadesOrg.add(new selecteme(
						result.getString(1), result.getString(5), result.getString(2)))) {
				}
			} else {
				System.out.println("no ahy coincidencias de busqueda");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void enviarNotificacion() throws SQLException {
		

		if (idNotificacionTipo == null || idNotificacionTipo.equals("")) {
			FacesMessageUtil.error(FacesContext.getCurrentInstance(),"Debe seleccionar una Descripcion");
			return;
		}

		if (codigo == null || codigo.equals("")) {
			FacesMessageUtil.error(FacesContext.getCurrentInstance(),"Debe escribir Codigo");
			return;

		}
		if (idRelacionEntidad == null || idRelacionEntidad.equals("")) {
			FacesMessageUtil.error(FacesContext.getCurrentInstance(),"Debe seleccionar una Entidad ");
			return;

		}
		if (idRelacionEntidad.equals("")) {
			limpiar();
			FacesContext.getCurrentInstance().addMessage("error",new FacesMessage(" Error"));
		} else {
			if(validarNotificacion()){
				System.out.println("codigo agregar"+codigo);
				Controller.enviarNotificacion(idNotificacionTipo, codigo,idRelacionEntidad);
				FacesMessageUtil.info(FacesContext.getCurrentInstance(),"Se agrego una nueva Notificacion");
			}else{
				FacesMessageUtil.error(FacesContext.getCurrentInstance(),"El tipo de Notificacion ya existe ");
			}
			}			
			limpiar();
			
		}
	


	public void limpiar() {
		idNotificacionCodigo = null;
		idNotificacionTipo = null;
		codigo = null;
		idRelacionEntidad = null;
	}

	public void cargar() throws SQLException {
		String filtros = "";
		System.out.println("entro en cargar");
		if (ciudadSeleccionada != null && ciudadSeleccionada != "") {
			filtros += " AND c.A065CODICIUD = " + ciudadSeleccionada;
		}
		if (idNotificacionTipo != null && idNotificacionTipo != "") {
			filtros += " AND nt.IDNOTIFICACIONTIPO=" + idNotificacionTipo;
		}
		if (codigo != null && codigo != "") {
			filtros += " AND nc.Codigo=" + codigo;
		}
		if (idRelacionEntidad != null && !idRelacionEntidad.equals(""))
			filtros += " AND t.IdRelacionEntidad = " + idRelacionEntidad;
		
		cargarRelacion();
		listarNotificacion(Controller.listado(filtros));
	}

	public void eliminar(ListaNotificacion row){
		Controller.eliminar(row);
		listado = null;
		try {
			cargar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(){
		System.out.println("codigo editar "+actual.getCodigo());
		Controller.editar(actual);
		listado = null;
		try {
			cargar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public selecteme getEntidad(String idEntidad){
		for(selecteme s: idRelacionEntidadesOrg){
			if(s.getNombre().equals(idEntidad))
				return s;
		}
		for(selecteme s: idRelacionEntidadesOrg){
			if(s.getCodigo().equals(idEntidad))
				return s;
		}
		return new selecteme("", "", "");
	}
	
	public ListaNotificacion getNotificacion(String idNotificacion){
		for(ListaNotificacion s: listado){
			if(s.getIdNotificacion().equals(idNotificacion))
				return s;
		}
		return new ListaNotificacion("", "", "", "", "", new selecItem("", ""), new selecteme("", "", ""));
	}
	
	public selecItem getTipoNombre(String idTipo){
		for(selecItem s: idNotificacionTipos){
			if(s.getNombre().equals(idTipo)){
				return s;
			}
		}
		
		for(selecItem s: idNotificacionTipos){
			if(s.getCodigo().equals(idTipo)){
				return s;
			}
		}
		return new selecItem("", "");
	}
	
	public selecMete getCiudad(String Ciudad){
		for(selecMete s: ciudades){
			if(s.getNombre().equals(Ciudad)){
				return s;
			}
		}
		return ciudad;
	}
	
	public String getCiudadNombre(String idCiudad) {
		for(selecMete s: ciudades){
			if(s.getCodigo().equals(idCiudad))
				return s.getNombre(); 
		}
		return null;
	}
	
	public void listarNotificacion(ResultSet result) throws SQLException {
		System.out.println("entro en listar notificacion");
		listado = new ArrayList<ListaNotificacion>();
		if (result != null) {
			while (result.next()) {
				listado.add(new ListaNotificacion(	result.getString(3),
													result.getString(2),
													result.getString(5),
													result.getString(4),
													result.getString(1),
													getTipoNombre(result.getString(2)),
													getEntidad(result.getString(4))
													));
			}
		}
	}

	public void agregarActuacion(){
		if(descripcion == null || descripcion.equals("")){
			FacesMessageUtil.error(FacesContext.getCurrentInstance(),"Debe Agregar una Actuación");
			return;
		}else{
			Controller.agregarActuacion(descripcion);
			FacesContext.getCurrentInstance().addMessage("Succesful",new FacesMessage("Actuación Agregada con exito"));
		}
		
	}
	
	public boolean validarNotificacion() throws SQLException {
		listarNotificacion(Controller.listado(""));
		actual = new ListaNotificacion("",idNotificacionTipo,codigo,idRelacionEntidad,getCiudadNombre(ciudadSeleccionada),getTipoNombre(idNotificacionTipo),getEntidad(idRelacionEntidad));
		System.out.println(actual);
		for(ListaNotificacion i:listado){
			if(	actual.getCodigo().trim().equals(i.getCodigo().trim()) &&
				actual.getEntidad().getCodigo().trim().equals(i.getEntidad().getCodigo().trim()) &&
				actual.getTipo().getCodigo().trim().equals(i.getTipo().getCodigo().trim()))
					return false;
		}
		return true;
	}

	public List<SelectItem> getCiudadesItems() throws SQLException {
		ciudadesItems = new ArrayList<SelectItem>();
		ResultSet result =Controller.selecCiudad();
		if (result != null) {
			for (; result.next(); ciudadesItems.add(new SelectItem(
					result.getString(1), result.getString(2)))) {
			}
		} else {
			System.out.println("no ahy coincidencias de busqueda");
		}
				
		return ciudadesItems;
	}	
	
	public void setCiudadesItems(List<SelectItem> ciudadesItems) {
		this.ciudadesItems = ciudadesItems;
	}
	public List<selecItem> getRelacionEntidadesOrg() {
		return RelacionEntidadesOrg;
	}

	public void setRelacionEntidadesOrg(List<selecItem> relacionEntidadesOrg) {
		RelacionEntidadesOrg = relacionEntidadesOrg;
	}

	public List<SelectItem> getRelacionEntidades() {
		return relacionEntidades;
	}

	public void setRelacionEntidades(List<SelectItem> relacionEntidades) {
		this.relacionEntidades = relacionEntidades;
	}
	
	
}
