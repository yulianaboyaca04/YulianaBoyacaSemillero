/**
 * UsuarioDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoPersonaEnum;

/**
 * <b>Descripción:<b> Clase que transfiere los datos del usuario a la vista
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
public class UsuarioDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private LocalDate fehaCreacion;
	private EstadoPersonaEnum estado;
	private String idPersona;
	
	/**
	 * Constructor de la clase.
	 */
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param fehaCreacion
	 * @param estado
	 * @param idPersona
	 */
	public UsuarioDTO(String id, String nombre, LocalDate fehaCreacion, EstadoPersonaEnum estado, String idPersona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fehaCreacion = fehaCreacion;
		this.estado = estado;
		this.idPersona = idPersona;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo fehaCreacion
	 * @return El fehaCreacion asociado a la clase
	 */
	public LocalDate getFehaCreacion() {
		return fehaCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fehaCreacion
	 * @param fehaCreacion El nuevo fehaCreacion a modificar.
	 */
	public void setFehaCreacion(LocalDate fehaCreacion) {
		this.fehaCreacion = fehaCreacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public EstadoPersonaEnum getEstado() {
		return estado;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoPersonaEnum estado) {
		this.estado = estado;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo idPersona
	 * @return El idPersona asociado a la clase
	 */
	public String getIdPersona() {
		return idPersona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * @param idPersona El nuevo idPersona a modificar.
	 */
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo serialVersionUID
	 * @return El serialversionuid asociado a la clase
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
