/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;



/**
 * <b>Descripción:<b> Clase que se utiliza para que gestionarComicBean se comunique con el mundo exterior
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
@Path("/GestionarComic")
public class GestionarComicRest {

	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	/**
	 * 
	 * Servicio encargado de recibir la petición que devuelve un saludo
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @return
	 */
	@GET
	@Path("/saludo") //ruta de acceso
	@Produces // define le tipo de recurso a producir
	public String primerRest() {
		return "Hola mundo";
	}
	
	/**
	 * 
	 * Metodo encargado de recibir la petición para la consulta de un comic
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic") //ruta de acceso
	@Produces (MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if(idComic != null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}
	
}
