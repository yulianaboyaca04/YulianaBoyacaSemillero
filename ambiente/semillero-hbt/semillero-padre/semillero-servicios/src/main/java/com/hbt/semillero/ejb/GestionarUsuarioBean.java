/**
 * GestionarUsuarioBean.java
 */
package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidades.EstadoPersonaEnum;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Usuario;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
@Stateless
public class GestionarUsuarioBean implements IGestionarUsuarioLocal{

	@PersistenceContext
    private EntityManager em;
	
	
	
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#crearUsuario(com.hbt.semillero.dto.UsuarioDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearUsuario(UsuarioDTO usuarioDTO) {
		usuarioDTO.setNombre(generarNombreUsuario()); // Se genera el nombre del usuario 
		try {
			if(usuarioDTO.getFehaCreacion().isBefore(LocalDate.now())) {
				Usuario usuario = convertirUsuarioDTOToUsuario(usuarioDTO);
				em.persist(usuario);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#modificarUsuario(java.lang.Long, java.lang.String, com.hbt.semillero.dto.UsuarioDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarUsuario(Long id, String nombre) {
		Usuario usuarioModificar = em.find(Usuario.class, id);
		usuarioModificar.setNombre(nombre);
		em.merge(usuarioModificar);
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#eliminarUsuario(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarUsuario(Long idUsuario) {
		Usuario usuarioEliminar = em.find(Usuario.class, idUsuario);
		if(usuarioEliminar != null) {
			usuarioEliminar.setEstado(EstadoPersonaEnum.INACTIVO);
			em.merge(usuarioEliminar);
		}
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarUsuario(java.lang.String)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UsuarioDTO consultarUsuario(String idUsuario) {
		Usuario usuario = new Usuario();
		usuario = em.find(Usuario.class, Long.parseLong(idUsuario));
		UsuarioDTO usuarioDTO = convertirUsuarioToUsuarioDTO(usuario);
		return usuarioDTO;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarUsuarios()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UsuarioDTO> consultarUsuarios() {
		List<UsuarioDTO> resultadoUsuarioDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> resultados = em.createQuery("select u from Usuario u").getResultList();
		for (Usuario usuario : resultados) {
			resultadoUsuarioDTO.add(convertirUsuarioToUsuarioDTO(usuario));
		}
		return resultadoUsuarioDTO;
	}

	/**
	 * Metodo encargado de convertir un usuarioDTO a  usuario
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param usuarioDTO
	 * @return
	 */	
	private Usuario convertirUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		if(usuarioDTO.getId()!=null) {
			usuario.setId(Long.parseLong(usuarioDTO.getId()));
		}
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setFehaCreacion(usuarioDTO.getFehaCreacion());
        usuario.setEstado(usuarioDTO.getEstado());
    	Persona persona = new Persona();
        persona = em.find(Persona.class, Long.parseLong(usuarioDTO.getIdPersona()));
        usuario.setPersona(persona);
        return usuario;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir un usuario a UsuarioDTO
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param usuario
	 * @return
	 */
	private UsuarioDTO convertirUsuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
        if(usuario.getId()!=null) {
        	usuarioDTO.setId(usuario.getId().toString());
        }
    	usuarioDTO.setNombre(usuario.getNombre());
    	usuarioDTO.setFehaCreacion(usuario.getFehaCreacion());
    	usuarioDTO.setIdPersona(usuario.getPersona().getId().toString());
        return usuarioDTO;
    }
	
	/**
	 * 
	 * Metodo encargado de generar el nombvre del usuario de acuerdo a las especificaciones
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @return
	 */
	public String generarNombreUsuario() {
		char[] arrayLetras =  new char[7];
		arrayLetras[0] =  generarCaracterAleatorio(65, 90); //letra mayuscula
		arrayLetras[1] = generarCaracterAleatorio(48, 57);// numero 0-9
	    for(int i = 2; i < arrayLetras.length; i++){
		    arrayLetras[i] = generarCaracterAleatorio(97, 122); //letra minuscula
	    }
	     System.out.println("hola.." + String.valueOf(arrayLetras));
		return String.valueOf(arrayLetras);
	}
	
	/**
	 * 
	 * Metodo encargado de generar un caracter en un rango determinado de acuerdo a la tabla ascii
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @return
	 */
	private static char generarCaracterAleatorio(int inicioRango, int finRango) {
		int randomCodigoCaracter = (int) Math.floor(Math.random()*(finRango-inicioRango+1)+inicioRango);
		return (char)(randomCodigoCaracter);
	}
	

	/**
	 * 
	 * Metodo encargado de validar si un usuario esta activo de acuerdo a la fecha de creación
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean validarUsuarioActivo(Usuario usuario) {
		LocalDate fechaActual = LocalDate.now();
		if (usuario.getFehaCreacion().plusYears(1).isEqual(fechaActual)) {
			return false;
		}
		return true;
	}
	
}
