/**
 * EjerciciosMaratonTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
public class EjerciciosTest {

	
	private String brand;
	private boolean empty;
	/**
	 * 
	 * Metodo encargado de  probar el ejercicio 2
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 *
	 */
	@Test
	public  void ejercicio2() {
		System.out.print("Empty = " + empty);
		System.out.print(", Brand = " + brand);
		//La clase no compila con esta linea 	WaterBottle wb = new WatterBottle();
		//las salidas son: Empty = true, Brand = 
	}
	
	/**
	 * 
	 * Metodo encargado de probar el metodo de que si es primo o no
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 *
	 */
	@Test
	public void ejercicio3() {
		int numero1 = 5;
		int numero2 = 222;
		int numero3 = 0;
		Assert.assertEquals( EjerciciosPOJO.esPrimo(numero1), true); //5 es primo
		Assert.assertEquals( EjerciciosPOJO.esPrimo(numero2), false); //222 no es primo
		Assert.assertEquals(EjerciciosPOJO.esPrimo(numero3), false ); //0 no es primo
	}
	

	/**
	 * 
	 * Metodo encargado de probar el metodo de probar años
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 *
	 */
	@Test
	public void ejercicio4() {
		Assert.assertEquals( EjerciciosPOJO.validarAnio(LocalDate.of(2011, 1, 1), 19), LocalDate.now().getYear()); //5 es primo
	}
	
	/**
	 * 
	 * Metodo encargado de probar el metodo del ejercio 5 
	 * ordenar numeros
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 *
	 */
	@Test
	public void ejercicio5() {
		EjerciciosPOJO.ingresarValor(-2);
		EjerciciosPOJO.ingresarValor(1);
		EjerciciosPOJO.ingresarValor(50);
		EjerciciosPOJO.ingresarValor(249);
		
		EjerciciosPOJO.ordenarNumeros();
		
		Assert.assertEquals(EjerciciosPOJO.obtenerListNumeros().get(0), new Integer(-2));
		Assert.assertEquals(EjerciciosPOJO.obtenerListNumeros().get(3), new Integer(249));
		Assert.assertEquals(EjerciciosPOJO.obtenerListNumeros().size(),4);
	}
}
