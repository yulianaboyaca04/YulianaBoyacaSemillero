/**
 * GestionarUsuarioBean.java
 */
package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidades.EstadoPersonaEnum;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Usuario;

/**
 * <b>Descripción:<b> Clase que determina la gestion de crear personas y
 * usuarios
 * 
 * @author Yuliana
 * @version
 */
@Stateless
public class GestionarUsuarioBean implements IGestionarUsuarioLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#crearPersona(com.hbt.semillero.dto.PersonaDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaDTO) {
		Persona persona = convertirPersonaDTOToPersona(personaDTO);
		em.persist(persona);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarPersonas()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonaDTO> consultarPersonas() {
		List<PersonaDTO> resultadosPersonasDTO = new ArrayList<PersonaDTO>();
		List<Persona> resultados = em.createQuery("select p from Persona p").getResultList();
		for (Persona persona : resultados) {
			resultadosPersonasDTO.add(convertirPersonaToPersonaDTO(persona));
		}
		return resultadosPersonasDTO;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarPersona(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonaDTO consultarPersona(Long idPersona) {
		return convertirPersonaToPersonaDTO(em.find(Persona.class, idPersona));
	}

	/**
	 * @throws Exception 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#crearUsuario(com.hbt.semillero.dto.UsuarioDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
		usuarioDTO.setNombre(generarNombreUsuario()); // Se genera el nombre del usuario
		if (usuarioDTO.getFehaCreacion().isBefore(LocalDate.now())) {
			Usuario usuario = convertirUsuarioDTOToUsuario(usuarioDTO);
			em.persist(usuario);
		} else {
			throw new Exception("Fecha de creacion invalida");
		}
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#modificarUsuario(java.lang.Long,
	 *      java.lang.String, com.hbt.semillero.dto.UsuarioDTO)
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
		if (usuarioEliminar != null) {
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
	 * 
	 * Metodo encargado de convertir persona a personaDTO <b>Caso de Uso</b>
	 * 
	 * @author Yuliana
	 * 
	 * @param persona
	 * @return
	 */
	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if (persona.getId() != null) {
			personaDTO.setId(persona.getId());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setNumIdentificacion(persona.getIdentificacion());
		return personaDTO;
	}

	/**
	 * 
	 * Metodo encargado de convertir una personaDTO a una persona <b>Caso de Uso</b>
	 * 
	 * @author Yuliana
	 * 
	 * @param personaDTO
	 * @return
	 */
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		if (personaDTO.getId() != null) {
			persona.setId(personaDTO.getId());
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setIdentificacion(personaDTO.getNumIdentificacion());
		return persona;
	}

	/**
	 * Metodo encargado de convertir un usuarioDTO a usuario <b>Caso de Uso</b>
	 * 
	 * @author Yuliana
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	private Usuario convertirUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		if (usuarioDTO.getId() != null) {
			usuario.setId(usuarioDTO.getId());
		}
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setFehaCreacion(usuarioDTO.getFehaCreacion());
		usuario.setEstado(usuarioDTO.getEstado());
		Persona persona = new Persona();
		persona = em.find(Persona.class, usuarioDTO.getIdPersona());
		usuario.setPersona(persona);
		return usuario;
	}

	/**
	 * 
	 * Metodo encargado de convertir un usuario a UsuarioDTO <b>Caso de Uso</b>
	 * 
	 * @author Yuliana
	 * 
	 * @param usuario
	 * @return
	 */
	private UsuarioDTO convertirUsuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		if (usuario.getId() != null) {
			usuarioDTO.setId(usuario.getId());
		}
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setFehaCreacion(usuario.getFehaCreacion());
		usuarioDTO.setIdPersona(usuario.getPersona().getId());
		return usuarioDTO;
	}

	/**
	 * 
	 * Metodo encargado de generar el nombvre del usuario de acuerdo a las
	 * especificaciones <b>Caso de Uso</b>
	 * 
	 * @author Yuliana
	 * 
	 * @return
	 */
	public String generarNombreUsuario() {
		char[] arrayLetras = new char[7];
		arrayLetras[0] = generarCaracterAleatorio(65, 90); // letra mayuscula
		arrayLetras[1] = generarCaracterAleatorio(48, 57);// numero 0-9
		for (int i = 2; i < arrayLetras.length; i++) {
			arrayLetras[i] = generarCaracterAleatorio(97, 122); // letra minuscula
		}
		System.out.println("hola.." + String.valueOf(arrayLetras));
		return String.valueOf(arrayLetras);
	}

	/**
	 * 
	 * Metodo encargado de generar un caracter en un rango determinado de acuerdo a
	 * la tabla ascii <b>Caso de Uso</b>
	 * 
	 * @author Yuliana
	 * 
	 * @return
	 */
	private static char generarCaracterAleatorio(int inicioRango, int finRango) {
		int randomCodigoCaracter = (int) Math.floor(Math.random() * (finRango - inicioRango + 1) + inicioRango);
		return (char) (randomCodigoCaracter);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#validarUsuarioActivo(java.lang.Long)
	 */
	@Override
	public boolean validarUsuarioActivo(Long idUsuario) {
		Usuario usuario = em.find(Usuario.class, idUsuario);
		if (usuario != null) {
			LocalDate fechaActual = LocalDate.now();
			if (usuario.getFehaCreacion().plusYears(1).isEqual(fechaActual)) {
				return false;
			}
		}
		return true;
	}

}
