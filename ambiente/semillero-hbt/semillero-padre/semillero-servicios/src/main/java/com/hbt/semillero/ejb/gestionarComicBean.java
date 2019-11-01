/**
 * gestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
@Stateless
public class gestionarComicBean {

	@PersistenceContext
    private EntityManager em;
	
	/**
	 * 
	 * Metodo encargado de crear un comic 
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param comicDTO
	 */
	//TODO Agregar interfaz
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		
		//TODO
		/*
		 * Llenar con los demas datos
		 */
		em.persist(comic);
	}
	
	/**
	 * 
	 * Metodo encargado de modificar un comic
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param comicModificar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarComic(ComicDTO comicModificar) {
		Comic comic= new Comic();
		comic.setId(comicModificar.getId());
		em.merge(comicModificar);
	}
	
	/**
	 * 
	 * Metodo encargado de consultar un comic
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param idComic
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ComicDTO consultarComic(String idComic) {
		Comic comic = em.find(Comic.class, idComic);
		ComicDTO comicDTO = new ComicDTO(comic.getId(), comic.getNombre());
		return comicDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de consultar todos los comics
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarTodos(){
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}
	
}
