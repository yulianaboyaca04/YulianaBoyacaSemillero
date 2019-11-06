import { Component, OnInit } from '@angular/core';

/**
 * @description Componente el cual contiene información personal 
 * 
 * @author Yuliana Boyacá <mary.boyaca@uptc.edu.co>
 */
@Component({
  selector: 'app-informacion-personal',
  templateUrl: './informacion-personal.component.html',
  styleUrls: ['./informacion-personal.component.css']
})
export class InformacionPersonalComponent implements OnInit {

  /**
    * Atributo que contendra la informacion del nombre y ciudad a mostrar
  */
  nombre: string;

  constructor() {
  }

  /**
  * Evento angular que se ejecuta al invocar el componente,
  * se asigna el valor a la variable nombre para que se muestre en pantalla
  */
  ngOnInit() {
    this.nombre = "Mary Yuliana Boyacá - Tunja";
    let nombreInstructor;
  }

}
