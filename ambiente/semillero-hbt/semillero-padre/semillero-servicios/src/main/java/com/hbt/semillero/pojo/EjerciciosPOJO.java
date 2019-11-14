/**
 * EjerciciosMaraton.java
 */
package com.hbt.semillero.pojo;

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
	
}
