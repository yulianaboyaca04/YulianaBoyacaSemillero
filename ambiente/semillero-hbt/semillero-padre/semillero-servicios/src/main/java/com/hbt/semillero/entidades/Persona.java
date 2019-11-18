/**
 * Persona.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que representa una persona
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
@Entity
@Table(name = "TC_PERSONA")
public class Persona implements Serializable  {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 7856552075311713947L;
	private Long id;
	private String nombre;
	private Long identificacion;
	
	/**
	 * Constructor de la clase.
	 */
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SPID")
	@SequenceGenerator(allocationSize = 1, name = "PERSONA_SPID_GENERATOR", sequenceName = "SEQ_PERSONA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_SPID_GENERATOR")
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SCNOMBRE")
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
	 * Metodo encargado de retornar el valor del atributo identificacion
	 * @return El identificacion asociado a la clase
	 */
	@Column(name = "SCNUMIDENTIFICACION")
	public Long getIdentificacion() {
		return identificacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo identificacion
	 * @param identificacion El nuevo identificacion a modificar.
	 */
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	
}
