/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que contiene las pruebas de la clase gestionarComicPOJO
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
public class GestionarComicPOJOTest {

	/**
	 * 
	 * Metodo encargado de realizar las pruebas para el metodo que se encarga de crear comic
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 *
	 */
	@Test
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("1", "Dragon Ball Yamcha", "Planeta Cómic", "AVENTURAS",
				"Manga Shonen", 144, new BigDecimal(2100), "Dragon Garow Lee", Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO,
				20L);

		gestionarComicPOJO.agregarComicDtoLista(comicDTO);
		// prueba para validar que la lista no es nula
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		// prueba para validar que la lista no esta vacia
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);

		comicDTO = new ComicDTO();

		comicDTO.setId("2");
		comicDTO.setNombre("Captain America Corps 1-5 USA");
		comicDTO.setEditorial("Panini Comics");
		comicDTO.setTematica("FANTASTICO");
		comicDTO.setColeccion("BIBLIOTECA MARVEL");
		comicDTO.setNumeroPaginas(128);
		comicDTO.setPrecio(new BigDecimal(5000));
		comicDTO.setAutores("Phillippe Briones, Roger Stern");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(5L);

		gestionarComicPOJO.agregarComicDtoLista(comicDTO);
		
		//prueba para validar que el elemento numero 2 fue agregado
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);

		comicDTO = new ComicDTO();

		comicDTO.setId("3");
		comicDTO.setNombre("The Spectacular Spider-Man v2 USA");
		comicDTO.setEditorial("Panini Comics");
		comicDTO.setTematica("FANTASTICO");
		comicDTO.setColeccion("MARVEL COMICS");
		comicDTO.setNumeroPaginas(208);
		comicDTO.setPrecio(new BigDecimal(6225));
		comicDTO.setAutores("Straczynski,Deodato Jr.,Barnes,Eaton");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.INACTIVO);
		comicDTO.setCantidad(0L);

		gestionarComicPOJO.agregarComicDtoLista(comicDTO);

		//prueba para validar que se agrego el elemento numero 3
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);

		//cambiar el nombre al comic con id numero 2
		String nuevoNombre = "Capitan America Corps 1-5 USA";
		gestionarComicPOJO.modificarComicDTO("2", nuevoNombre);
		
		//prueba para validar la modificacion del comic
		Assert.assertEquals(gestionarComicPOJO.getListaComics().get(1).getNombre(), nuevoNombre);

		//se elimina el elemento 1 
		gestionarComicPOJO.eliminarComicDTO("1");
		
		//prueba para validar que se elimino un elemento de la lista 
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);
	}
}
