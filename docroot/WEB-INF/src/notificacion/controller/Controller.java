package notificacion.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import notificacion.entities.ListaNotificacion;
import notificacion.persistence.PersistenceUtil;

public class Controller {
	
public static ResultSet selecNotificacionTipo(){
		
		String sql ="select * from NotificacionTipo " ;
		try {
			
			ResultSet result;			
			result=PersistenceUtil.realizaConsulta(sql);				
			if(result!=null){			
			       return result;
			}else{				
				System.out.println("no ahy  registro cargadas en la base de datos");
			}			
			PersistenceUtil.terminaOperacion();			
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Error de conexion a la bd  "+ex.getMessage());		
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Error  excepcion  "+ex.getMessage());		
		}
		return null;		
	}

public static ResultSet selecRelacion(){
	
	String sql ="select * from T081BRESPEENTI ";
	try {
		
		ResultSet result;			
		result=PersistenceUtil.realizaConsulta(sql);				
		if(result!=null){			
		       return result;
		}else{				
			System.out.println("no ahy  registro cargadas en la base de datos");
		}			
		PersistenceUtil.terminaOperacion();			
	} catch(SQLException ex){
		ex.printStackTrace();
		System.out.println("Error de conexion a la bd  "+ex.getMessage());		
	}
	catch(Exception ex){
		ex.printStackTrace();
		System.out.println("Error  excepcion  "+ex.getMessage());		
	}
	return null;		
}

public static ResultSet selecCiudad(){
	
	String sql ="select distinct(T.A081codiciud), C.A065DESCCIUD from T081BRESPEENTI T, T065BACIUDGENE C where T.A081CODICIUD = C.A065CODICIUD order by C.A065DESCCIUD";
	try {
		
		ResultSet result;			
		result=PersistenceUtil.realizaConsulta(sql);				
		if(result!=null){			
		       return result;
		}else{				
			System.out.println("no ahy  registro cargadas en la base de datos");
		}			
		PersistenceUtil.terminaOperacion();			
	} catch(SQLException ex){
		ex.printStackTrace();
		System.out.println("Error de conexion a la bd  "+ex.getMessage());		
	}
	catch(Exception ex){
		ex.printStackTrace();
		System.out.println("Error  excepcion  "+ex.getMessage());		
	}
	return null;		
}
	

	public static void enviarNotificacion(String idNotificacionTipo, String codigo, String idRelacionEntidad)
    {
			
        String sql = "";
        sql = "insert into NotificacionCodigo(IdNotificacionTipo,codigo,IdRelacionEntidad) " +
              "values('"+idNotificacionTipo.trim()+"','"+codigo.trim()+"','"+idRelacionEntidad.trim()+"')";
        System.out.println(sql);
        try
        {
            PersistenceUtil.ejecutaSentencia(sql);
            PersistenceUtil.terminaOperacion();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
	
		public static ResultSet listado(String filtros){
		String sql ="select c.A065DESCCIUD, nt.DESCRIPCION, nc.idNotificacionCodigo, t.A081DESCENESP, nc.Codigo ,t.A081CODIENTI,nt.IDNOTIFICACIONTIPO "+ 
					"from NotificacionCodigo nc, T081BRESPEENTI t,T065BACIUDGENE c, NotificacionTipo nt "+
					"where nc.IdNotificacionTipo = nt.IDNOTIFICACIONTIPO "+
					"and nc.IdRelacionEntidad = t.IdRelacionEntidad "+
					"and t.A081CODICIUD = c.A065CODICIUD" + filtros;
		System.out.println(sql);
		try {
			
			ResultSet result;			
			result=PersistenceUtil.realizaConsulta(sql);
			if(result!=null){			
			       return result;
			}else{				
				System.out.println("no ahy  registro cargadas en la base de datos");
			}			
			PersistenceUtil.terminaOperacion();			
		} catch(SQLException ex){
			//ex.printStackTrace();
			//System.out.println("Error de conexion a la bd  "+ex.getMessage());
			System.out.println("DATABASE error");
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Error  excepcion  "+ex.getMessage());		
		}
		return null;		
	}

		public static void eliminar(ListaNotificacion row) {
			String sql = "";
	        sql = "delete from NotificacionCodigo where IdNotificacionCodigo = "+row.getIdNotificacion();       
	        try
	        {
	            PersistenceUtil.ejecutaSentencia(sql);
	            PersistenceUtil.terminaOperacion();
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
		}

		public static void editar(ListaNotificacion row) {
			System.out.println("codigo editar contrller "+row.getCodigo());
			String sql = "";
	        sql = 	" update NotificacionCodigo "+
	        		" set idnotificaciontipo = "+row.getTipo().getCodigo() +
	        		" ,codigo = '"+row.getCodigo() +
	        		"' ,idRelacionEntidad = "+row.getEntidad().getCodigo() +
	        		" where idNotificacionCodigo = "+row.getIdNotificacion();
	        System.out.println("******"+sql);
	        try
	        {
	            PersistenceUtil.ejecutaSentencia(sql);
	            PersistenceUtil.terminaOperacion();
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
		}
		
		public static void agregarActuacion(String descripcion)
		{
			String sql = "";
	        sql = "insert into Notificaciontipo(descripcion) " +
	              "values('"+descripcion+"')";    
	        System.out.println("SQL: "+sql);
	        try
	        {
	            PersistenceUtil.ejecutaSentencia(sql);
	            PersistenceUtil.terminaOperacion();
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	            System.out.println("ERROR: "+e.getMessage());
	        }
		}
}
