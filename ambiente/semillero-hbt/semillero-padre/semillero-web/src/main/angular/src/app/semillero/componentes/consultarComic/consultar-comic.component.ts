import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Location } from '@angular/common';

/**
 * @description Componenente consultar comic, el cual contiene la logica para mostrar el comic a consultar
 * 
 * @author Mary Yuliana Boyacá Aguilar<mary.boyaca@uptc.edu.co>
 */
@Component({
  selector: 'consultar-comic',
  templateUrl: './consultar-comic.component.html',
  styleUrls: ['./consultar-comic.component.css']
})
export class ConsultarComicComponent implements OnInit {

  /**
  * Atributo que contiene los controles del formulario
  */
  public gestionarComicForm: FormGroup;

  /**
   * Constructor encargado de crear el formulario reactivo con sus respectivas validaciones
   * @param fb 
   * @param router 
   * @param activatedRouter 
   * @param _location 
   */
  constructor(private fb: FormBuilder, private router: Router, private activatedRouter: ActivatedRoute, private _location: Location) {
    this.gestionarComicForm = this.fb.group({
      nombre: [null, Validators.required],
      editorial: [null],
      tematica: [null],
      coleccion: [null],
      numeroPaginas: [null],
      precio: [null],
      autores: [null],
      color: [null]
    });
  }

  /**
   * Metodo que llama el metodo de consultarComic
   */
  ngOnInit() {
    this.consultarComic();

  }

  /**
   * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
   */
  public consultarComic(): void {
    let comic = this.activatedRouter.snapshot.params;
    this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
    this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
    this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
    this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
    this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
    this.gestionarComicForm.controls.precio.setValue(comic.precio);
    this.gestionarComicForm.controls.autores.setValue(comic.autores);
    this.gestionarComicForm.controls.color.setValue(comic.color);
    this.gestionarComicForm.controls.nombre.disable();
    this.gestionarComicForm.controls.editorial.disable();
    this.gestionarComicForm.controls.tematica.disable();
    this.gestionarComicForm.controls.coleccion.disable();
    this.gestionarComicForm.controls.numeroPaginas.disable();
    this.gestionarComicForm.controls.precio.disable();
    this.gestionarComicForm.controls.autores.disable();
    this.gestionarComicForm.controls.color.disable();
  }

  /**
   * Metodo que se regresa a la pagina anterior
   */
  regresar() {
    this._location.back();
  }
}
