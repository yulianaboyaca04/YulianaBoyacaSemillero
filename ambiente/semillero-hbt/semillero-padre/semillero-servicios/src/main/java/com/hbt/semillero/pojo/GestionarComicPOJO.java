/**
c * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Yuliana
 * @version
 */
public class GestionarComicPOJO {

	private List<ComicDTO> listaComics = null;

	/**
	 * 
	 * Metodo encargado de crear un comic a partir de los parametros
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fechaVenta
	 * @param estado
	 * @param cantidad
	 * @return
	 */
	public ComicDTO crearComicDTO(String id, String nombre, String editorial, TematicaEnum tematica, String coleccion,
			int  numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta,
			EstadoEnum estado, Long cantidad) {
		ComicDTO comicDTO =  new ComicDTO(id, nombre, editorial, tematica, coleccion, numeroPaginas, precio, autores, 
				color, fechaVenta, estado, cantidad);
		return comicDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de agregar un comic a la lista de comics
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param comicDTO
	 */
	public void agregarComicDtoLista(ComicDTO comicDTO) {
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de crear un comic, seteando valores quemados
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId("100");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}
	
	/**
	 * 
	 * Metodo encargado de modificar un comic, recibiendo el comic modificado como parametro
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param i
	 * @param comicDTO
	 */
	public void modificarComicDTO(int i, ComicDTO comicDTO) {
		listaComics.set(i, comicDTO);
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el nombre de un comic
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param id
	 * @param comicDTO
	 */
	public void modificarComicDTO(String id, String nombre) {
		ComicDTO comicAModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {//ciclo que recorre la lista de comics para buscar el comic que se desea editar
			comicAModificar = listaComics.get(i);
			if(comicAModificar.getId().equals(id)) {				
				comicAModificar.setNombre(nombre);	
				return;
			}
		}
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
	
	/**
	 * 
	 * Metodo encargado de eliminar un comic por su id
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param idComic
	 */
	public void eliminarComicDTO(String idComic) {
		int tamanio = this.listaComics.size();
		int contador = 0;
		boolean encontrado = false;
		while (contador<=tamanio && !encontrado) {
			if (this.listaComics.get(contador).getId().equals(idComic)) {
				this.listaComics.remove(contador);
				encontrado = true;
				return;
			}
			contador++;
		}
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}
}
