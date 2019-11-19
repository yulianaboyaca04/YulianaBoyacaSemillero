import { PersonaDTO } from './persona.dto';

/**
 * @description Clase UsuarioDTO que contiene la informacion del usuario de una persona
 * 
 * @author Mary Yuliana Boyacá Aguilar <mary.boyaca@uptc.edu.co>
 */
export class UsuarioDTO {

    /**
     * Identificador del usuario
     */
    public  id: number;
    
    /**
     * nombre del usuario
     */
    public  nombre: String;
    
    /**
     * Fecha de creación
     */
    public  fehaCreacion: Date;
   
    /** 
     * estado de usuario que indica si esta activo o no
    */
    public  estado: String;
    
    /**
     * persona a la que pertenece el usuario
     */
	public  idPersona: number;
	
}