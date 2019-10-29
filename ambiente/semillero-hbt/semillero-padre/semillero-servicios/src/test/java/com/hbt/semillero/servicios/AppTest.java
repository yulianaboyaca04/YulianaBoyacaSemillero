package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}
