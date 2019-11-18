/**
 * gestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que se usa para la comunicación de la base de datos con la app
 * <b>Caso de Uso:<b> 
 * @author Yuliana
 * @version 
 */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal{


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
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)//Crea una transaccion nueva
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = convertirComicDTOToComic(comicDTO);
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
		comic.setId(Long.parseLong(comicModificar.getId()));
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
		Comic comic = null;
		comic = new Comic();
		comic = em.find(Comic.class, Long.parseLong(idComic));
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
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

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long, java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	//TODO cual es el resultado de llamar a modificarComic
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if(comicNuevo == null) {
			comicModificar = em.find(Comic.class, id);
		}else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
		}
		comicModificar.setNombre(nombre);
		//TODO validar si el comic a modificar llega con datos
		em.merge(comicModificar);
	}

	/**
	 * Metodo que elimina un comic de acuerdo al id que se indica por parametro
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	public void eliminarComic(Long idComic) {
		Comic comicEliminar = em.find(Comic.class, idComic);
		if(comicEliminar != null) {
			em.remove(comicEliminar);
		}
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir un comicDTO a una entidad del comic
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param comicDTO
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		if(comicDTO.getId()!=null) {
			comic.setId(Long.parseLong(comicDTO.getId()));
		}
        comic.setNombre(comicDTO.getNombre());
        comic.setEditorial(comicDTO.getEditorial());
        comic.setTematicaEnum(comicDTO.getTematica());
        comic.setColeccion(comicDTO.getColeccion());
        comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
        comic.setPrecio(comicDTO.getPrecio());
        comic.setAutores(comicDTO.getAutores());
        comic.setColor(comicDTO.getColor());
        comic.setFechaVenta(comicDTO.getFechaVenta());
        comic.setEstadoEnum(comicDTO.getEstado());
        comic.setCantidad(comicDTO.getCantidad());
        return comic;
	}
	
	/**
	 * 
	 * Metodo encargado de convertir un comic a ComicDTO
	 * <b>Caso de Uso</b>
	 * @author Yuliana
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
        ComicDTO comicDTO = new ComicDTO();
        if(comic.getId()!=null) {
         comicDTO.setId(comic.getId().toString());
        }
        comicDTO.setNombre(comic.getNombre());
        comicDTO.setEditorial(comic.getEditorial());
        comicDTO.setTematicaEnum(comic.getTematicaEnum());
        comicDTO.setColeccion(comic.getColeccion());
        comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
        comicDTO.setPrecio(comic.getPrecio());
        comicDTO.setAutores(comic.getAutores());
        comicDTO.setColor(comic.getColor());
        comicDTO.setFechaVenta(comic.getFechaVenta());
        comicDTO.setEstadoEnum(comic.getEstadoEnum());
        comicDTO.setCantidad(comic.getCantidad());
        return comicDTO;
    }
}
