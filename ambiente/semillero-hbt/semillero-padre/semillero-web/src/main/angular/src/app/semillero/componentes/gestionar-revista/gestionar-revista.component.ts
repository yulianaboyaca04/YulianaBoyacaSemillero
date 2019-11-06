import { Component, OnInit } from '@angular/core';
import { RevistaDTO } from '../../dto/revista.dto';

/**
 * @description Componente el cual gestiona la revista
 * 
 * @author Yuliana Boyacá <mary.boyaca@uptc.edu.co>
 */
@Component({
  selector: 'gestionar-revista',
  templateUrl: './gestionar-revista.component.html'
})
export class GestionarRevistaComponent implements OnInit {

  /**
   * atributo que almacena la lista de revistas
   */
  public listaRevistas: Array<RevistaDTO>;

  /**
   * variable que almacena el mensaje a mostrar cuando se elimina una revista
   */
  public mensaje: string;

  /**
   * variable que determina si se muestra el mensaje o no
   */
  public mostrarMensaje: boolean;

  constructor() { }

  /**
   * Inicializa las variables de la clase y llama los metodos para su ejecución.
   */
  ngOnInit() {
    this.listaRevistas = new Array<RevistaDTO>();
    this.mostrarMensaje = false;
    this.crearRevistas();
    console.log(JSON.stringify(this.listaRevistas))
  }

  /**
   * crea las 5 revistas y las agrega a la lista de revistas
   */
  public crearRevistas(): void {
    let revistaDTO: RevistaDTO = new RevistaDTO();
    revistaDTO.id = 1;
    revistaDTO.nombre = 'batman';
    revistaDTO.editorial = 'marvel';
    revistaDTO.tematica = 'accion';
    revistaDTO.numeroPaginas = 50;
    revistaDTO.precio = 60, 500.99;
    revistaDTO.autores = 'Pedrito barrera';
    revistaDTO.aColor = true;
    revistaDTO.fechaVenta = new Date('10-10-2019');
    revistaDTO.estado = 'activo';
    this.listaRevistas.push(revistaDTO);

    revistaDTO = new RevistaDTO();
    revistaDTO.id = 2;
    revistaDTO.nombre = 'La mujer maravilla';
    revistaDTO.editorial = 'marvel';
    revistaDTO.tematica = 'accion';
    revistaDTO.numeroPaginas = 30;
    revistaDTO.precio = 90, 500.99;
    revistaDTO.autores = 'Pepino Sin nombre';
    revistaDTO.aColor = false;
    revistaDTO.fechaVenta = new Date('09-10-2017');
    revistaDTO.estado = 'activo';
    this.listaRevistas.push(revistaDTO);

    revistaDTO = new RevistaDTO();
    revistaDTO.id = 3;
    revistaDTO.nombre = 'Superman';
    revistaDTO.editorial = 'marvel';
    revistaDTO.tematica = 'accion';
    revistaDTO.numeroPaginas = 80;
    revistaDTO.precio = 30, 300.50;
    revistaDTO.autores = 'Pedrito Caro';
    revistaDTO.aColor = true;
    revistaDTO.fechaVenta = new Date('18-09-2017');
    revistaDTO.estado = 'activo';
    this.listaRevistas.push(revistaDTO);

    revistaDTO = new RevistaDTO();
    revistaDTO.id = 4;
    revistaDTO.nombre = 'Spiderman';
    revistaDTO.editorial = 'marvel';
    revistaDTO.tematica = 'accion';
    revistaDTO.numeroPaginas = 70;
    revistaDTO.precio = 45, 500.99;
    revistaDTO.autores = 'Huzman gonzalez';
    revistaDTO.aColor = true;
    revistaDTO.fechaVenta = new Date('09-10-2016');
    revistaDTO.estado = 'inactivo';
    this.listaRevistas.push(revistaDTO);

    revistaDTO = new RevistaDTO();
    revistaDTO.id = 5;
    revistaDTO.nombre = 'Flash';
    revistaDTO.editorial = 'marvel';
    revistaDTO.tematica = 'accion';
    revistaDTO.numeroPaginas = 10;
    revistaDTO.precio = 45, 500.99;
    revistaDTO.autores = 'Benito Susurro';
    revistaDTO.aColor = false;
    revistaDTO.fechaVenta = new Date('09-10-2018');
    revistaDTO.estado = 'inactivo';
    this.listaRevistas.push(revistaDTO);
  }

  /**
   * metodo que elimina la revista con la posicion indicada por el evento click
   * @param pos posicion de la revista a eliminar en la lista
   */
  public eliminarRevista(pos: number): void {
    if (this.listaRevistas.length > pos) {
      this.mostrarMensaje = true;
      this.mensaje = 'Se ha eliminado el comic nombreDelComic ' + this.listaRevistas[pos].nombre;
      this.listaRevistas.splice(pos, 1);
    } else {
      this.mostrarMensaje = false;
      this.mensaje = '';
    }
  }

  /**
   * Uso de operadores binding: foreach, delete, if else y this para buscar un elemento en la lista
   * @param revista nombre del elemento a buscar
   */
  public buscarRevista(revista: string): string{
    let mensaje: string;
    this.listaRevistas.forEach(element => {
      if(element.nombre === revista){
       delete element.aColor;
        mensaje = JSON.stringify(element);
      }else{
        mensaje = 'No se han encontrado resultados de la busqueda';
      }
    });
    return mensaje;
  }
}
