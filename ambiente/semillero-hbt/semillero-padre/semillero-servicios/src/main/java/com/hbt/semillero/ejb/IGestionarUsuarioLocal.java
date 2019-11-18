/**
 * IGestionarUsuarioBean.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.UsuarioDTO;

/**
 * <b>Descripción:<b> Clase que  expone los métodos del EJB GestionarUsuario 
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
public interface IGestionarUsuarioLocal {

	/**
	 * 
	 * Metodo encargado de crear un usuario y persistirlo
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param usuarioNuevo
	 */
	public void crearUsuario(UsuarioDTO usuarioNuevo);
	
	
	/**
	 * 
	 * Metodo encargado de modificar el nomvre del usuario
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param id
	 * @param nombre
	 */
	public void modificarUsuario(Long id, String nombre);

	/**
	 * 
	 * Metodo encargado de eliminar un usuario, cambia el estado del usuario
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param idComic
	 */
	public void eliminarUsuario(Long idUsuario);
	
	/**
	 * 
	 * Metodo encargado de retornar la informacion de un usuario
	 * 
	 * @param idComic identificador del usuario a ser consultado
	 * @return comic Resultado de la consulta
	 */
	public UsuarioDTO consultarUsuario(String idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar una lista de usuarios
	 * 
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuarios();
}
