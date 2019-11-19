/**
 * IGestionarUsuarioBean.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.PersonaDTO;
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
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param personaDTO
	 */
	public void crearPersona(PersonaDTO personaDTO);

	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @return
	 */
	public List<PersonaDTO> consultarPersonas() ;

	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param idPersona
	 * @return
	 */
	public PersonaDTO consultarPersona(Long idPersona) ;
	
	
	/**
	 * 
	 * Metodo encargado de crear un usuario y persistirlo
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param usuarioNuevo
	 * @throws Exception 
	 * 
	 */
	public void crearUsuario(UsuarioDTO usuarioNuevo) throws Exception;
	
	
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
	
	/**
	 * 
	 * Metodo encargado de validar si un usuario esta activo de acuerdo a su fecha de creacion
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @return
	 */
	public boolean validarUsuarioActivo(Long idUsuario);
}
