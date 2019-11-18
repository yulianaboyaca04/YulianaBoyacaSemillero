/**
 * Usuariuo.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que representa un usuario del sistema
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
@Entity
@Table(name = "TC_USUARIO")
public class Usuario implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 4282895887802570189L;
	private Long id;
	private String nombre;
	private LocalDate fehaCreacion;
	private EstadoPersonaEnum estado;
	private Persona persona;
	
	/**
	 * Constructor de la clase.
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SUID")
	@SequenceGenerator(allocationSize = 1, name = "USUARIO_SUID_GENERATOR", sequenceName = "SEQ_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SUID_GENERATOR")
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
	@Column(name = "SUNOMBRE", unique=true)
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
	@Column(name = "SUFECHA_CREACION")
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
	@Column(name = "SUESTADO")
	@Enumerated(value = EnumType.STRING)
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
	@Column(name = "SUIDPERSONA")
	@OneToOne
	public Persona getPersona() {
		return persona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * @param idPersona El nuevo idPersona a modificar.
	 */
	public void setPersona(Persona idPersona) {
		this.persona = idPersona;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo serialVersionUID
	 * @return El serialversionuid asociado a la clase
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
