/**
 * Proveedor.java
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
 * <b>Descripción:<b> Clase que representa un proovedor en el sistema
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
@Entity
@Table(name = "TC_PROVEEDOR")
public class Proveedor implements Serializable{

	
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 5681725263083718085L;
	private Long id;
	private String direccion;
	private LocalDate fechaCreacion;
	private EstadoPersonaEnum estado;
	private Persona persona;
	private Long montoCredito;
	
	/**
	 * Constructor de la clase.
	 */
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SPID")
	@SequenceGenerator(allocationSize = 1, name = "PROVEEDOR_SPID_GENERATOR", sequenceName = "SEQ_PROVEEDOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVEEDOR_SPID_GENERATOR")
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
	 * Metodo encargado de retornar el valor del atributo direccion
	 * @return El direccion asociado a la clase
	 */
	@Column(name = "SPDIRECCION")
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * @param direccion El nuevo direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	@Column(name = "SPFECHA_CREACION")
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	@Column(name = "SPESTADO")
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
	 * Metodo encargado de retornar el valor del atributo persona
	 * @return El persona asociado a la clase
	 */
	@Column(name = "SPIDPERSONA")
	@OneToOne
	public Persona getPersona() {
		return persona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo persona
	 * @param persona El nuevo persona a modificar.
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * @return El montoCredito asociado a la clase
	 */
	@Column(name = "SPMONTO_CREDITO")
	public Long getMontoCredito() {
		return montoCredito;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo montoCredito
	 * @param montoCredito El nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(Long montoCredito) {
		this.montoCredito = montoCredito;
	}
	
	
	
}
