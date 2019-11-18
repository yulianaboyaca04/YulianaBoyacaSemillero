/**
 * EstadoUsuarioEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina el estado de una persona en el sistema
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
public enum EstadoPersonaEnum {

	ACTIVO("enum.persona.activo"),
	INACTIVO("enum.persona.inactivo");
	
	private String codigoMensaje;
	
	/**
	 * Constructor de la clase.
	 * @param codigoMensaje
	 */
	private EstadoPersonaEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo codigoMensaje
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codigoMensaje
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

}
