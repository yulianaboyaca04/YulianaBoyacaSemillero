package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	@Test
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 170L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}

	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}
	
	@Test
	public void pruebaInvertirCadena() {
		String cadena = "cadena";
		String resultado = invertirCadena(cadena);
		String resultadoEsperado = "anedac";
		Assert.assertEquals(resultado, resultadoEsperado);
		
		cadena = "test";
		resultado = invertirCadena(cadena);
		resultadoEsperado = "tste";
		Assert.assertNotEquals(resultado, resultadoEsperado);
		
		cadena = "";
		resultado = invertirCadena(cadena);
		resultadoEsperado = "";
		Assert.assertEquals(resultado, resultadoEsperado);
		
		cadena = "";
		resultado = invertirCadena(cadena);
		resultadoEsperado = " ";
		Assert.assertNotEquals(resultado, resultadoEsperado);
		
		cadena = "cadena a invertir ";
		resultado = invertirCadena(cadena);
		resultadoEsperado = "ritrevni a anedac ";
		Assert.assertNotEquals(resultado, resultadoEsperado);
		
		cadena = "  ";
		resultado = invertirCadena(cadena);
		resultadoEsperado = "  ";
		Assert.assertEquals(resultado, resultadoEsperado);
		
		cadena = "  ";
		resultado = invertirCadena(cadena);
		resultadoEsperado = "";
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}
	
	/**
	 * 
	 * Metodo encargado de hacer las pruebas del enumerado Estado
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 *
	 */
	@Test(enabled=false)
	public void pruebaEnumeradoEstado() {
		//Instanciar un enum de la clase EstadoEnum
		EstadoEnum estadoActivo= EstadoEnum.ACTIVO;
		
		//Devuelve un String con el nombre de la constante (ACTIVO)
		String nombreActivo = estadoActivo.name();
		Assert.assertEquals(nombreActivo, "ACTIVO");
		
		//Devuelve un entero con la posición del enum según está declarada
		int posicion = estadoActivo.ordinal();
		
		//Compara el enum con el parámetro según el orden en el que están declarados lo enum
		int posicionEstadoActivoEsperada = 0;
		Assert.assertEquals(estadoActivo.ordinal(), posicionEstadoActivoEsperada);
		
		posicionEstadoActivoEsperada = 1;
		Assert.assertNotEquals(estadoActivo.ordinal(), posicionEstadoActivoEsperada);
		
		//Devuelve un array que contiene todos los enum
		EstadoEnum[] listEstados =  EstadoEnum.values();
	}
	
	
	@Test
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		
	}
	
	@Test
	public void crearComicDTOTestParametros() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

	}
	
	@Test
	public void agregarComicDTOLista() {
		
	}
}
