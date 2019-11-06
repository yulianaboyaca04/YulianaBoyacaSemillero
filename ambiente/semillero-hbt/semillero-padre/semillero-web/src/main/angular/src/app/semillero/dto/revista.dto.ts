/**
 * @description Clase revistaDTO que contiene la informacion de una revista
 * 
 * @author Mary Yuliana Boyacá Aguilar <mary.boyaca@uptc.edu.co>
 */
export class RevistaDTO {
    /**
     * identificar de la revista
     */
   public id:number;
   /**
    * nombre de la revista
    */
   public nombre: string;
   /**
    * Editorial que crea la revista
    */
    public editorial: string;
    /**
     * Tematica de la revista
     */
    public tematica: string;
    /**
     * numero de paginas de la revista
     */
    public numeroPaginas: number;
    /**
     * precio de la revista
     */
    public precio: number;
    /**
     * autores que crean la revista
     */
    public autores: string;
    /**
     * color de la revista
     */
    public aColor: boolean;
    /**
     * fecha de venta de la revista
     */
    public fechaVenta: Date;
    /**
     * Estado de la revista 
     */
    public estado: string;
}