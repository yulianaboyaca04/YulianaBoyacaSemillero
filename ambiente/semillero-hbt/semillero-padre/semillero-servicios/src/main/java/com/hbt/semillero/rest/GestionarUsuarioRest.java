/**
 * GestionarUsuarioRest.java
 */
package com.hbt.semillero.rest;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.ejb.IGestionarUsuarioLocal;

/**
 * <b>Descripción:<b> Clase que contiene todos los servicios de gestionar usuario
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
@Path("/GestionarUsuario")
public class GestionarUsuarioRest {
	
	/**
	 * Atriburo que permite gestionar un usuario
	 */
	@EJB
	private IGestionarUsuarioLocal gestionarUsuarioEJB;

	/**
	 * 
	 * Metodo encargado de traer la informacion de todos los usuarios
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarUsuarios
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> consultarUsuarios() {
		return gestionarUsuarioEJB.consultarUsuarios();
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarUsuario?idUsuario=1
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO consultarUsuario(@QueryParam("idComic") Long idUsuario) {
		if (idUsuario != null) {
			UsuarioDTO usuarioDTO = gestionarUsuarioEJB.consultarUsuario(idUsuario.toString());
			return usuarioDTO;
		}
		return null;
	}
	
	/**
	 * Servicio encargado de crear un usuario 
	 * http://localhost:8085/semillero-servicios/rest/GestionarUsuario/crearUsuario
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crearUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearUsuario(UsuarioDTO usuarioDTO) {
		gestionarUsuarioEJB.crearUsuario(usuarioDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Usuario creado exitosamente");
		return resultadoDTO;
		
	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un comic
	 * http://localhost:8085/semillero-servicios/rest/GestionarUsuario/modificar?idUsuario=1&nombre=nuevonombre
	 * @param idComic identificador del comic a buscar
	 * @param nombre nombre nuevo del comic
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarUsuario(@QueryParam("idUsuario") Long idUsuario, @QueryParam("nombre") String nombre) {
		gestionarUsuarioEJB.modificarUsuario(idUsuario, nombre);
	}

	/**
	 * 
	 * Metodo encargado de eliminar un usuario dado el id
	 * http://localhost:8085/semillero-servicios/rest/GestionarUsuario/eliminar?idUsuario=1
	 * @param idComic identificador del usuario
	 */
	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarUsuario(@QueryParam("idComic") Long idUsuario) {
		ResultadoDTO resultadoDTO;
		if (idUsuario != null) {
			UsuarioDTO usuarioDTO = gestionarUsuarioEJB.consultarUsuario(idUsuario.toString());
			gestionarUsuarioEJB.eliminarUsuario(Long.parseLong(usuarioDTO.getId()));
			resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Usuario eliminado exitosamente");
		}else {
			resultadoDTO = new ResultadoDTO(Boolean.FALSE, "Error al eliminar usuario");
		}
		return resultadoDTO;
	}
	
	
}
