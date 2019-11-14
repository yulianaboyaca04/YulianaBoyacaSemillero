/**
 * EjerciciosMaraton.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * <b>Descripción:<b> Clase que contiene los ejercicios maraton
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
public class EjerciciosPOJO {


	/**
	 * 
	 * Metodo encargado de averiguar si un numero es primo o no 
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param numero
	 * @return
	 */
	public static boolean esPrimo(int numero){
		  int contador = 2;
		  boolean primo=true;
		  while ((primo) && (contador!=numero)){
		    if (numero % contador == 0) {
		      primo = false;
		    }
		    contador++;
		  }
		  return primo;
	}
	
	/**
	 * 
	 * Metodo encargado de validar el anio de una persona con respecto a su fecha de nacimiento y edad
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param fechaNacimiento
	 * @return
	 */
	public static LocalDate validarAnio(LocalDate fechaNacimiento, int anios) {
		return fechaNacimiento.plusYears(anios);
	}
	
	//lista que almacena numeros para el ejecicio 5
	public static ArrayList listNumeros = new ArrayList<>();
	
	/**
	 * 
	 * Metodo encargado de ingresar los valores a la lista del ejercicio 5
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param numero
	 * @return
	 */
	public static ArrayList ingresarValor(int numero){
		listNumeros.add(numero);
		return listNumeros;
	}
	
	/**
	 * 
	 * Metodo encargado de ordenar los numeros de la lista
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @return
	 */
	public static void ordenarNumeros() {
		Collections.sort(listNumeros);
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listNumeros
	 * @return El listNumeros asociado a la clase
	 */
	public static ArrayList obtenerListNumeros() {
		return listNumeros;
	}
	
	/**
	 * 
	 * Metodo encargado de jugar tennis
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param puntajeJugador1
	 * @param puntajeJUgador2
	 * @return
	 */
	public static String juegoTennis(int[] puntajeJugador1, int[] puntajeJUgador2){
		Map<String, int[]> map = new HashMap<String, int[]>();
		
		return "hk";
	}
}
