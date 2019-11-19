import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { GestionarUsuarioService } from '../../services/gestionar.usuario.service';
import { UsuarioDTO } from '../../dto/usuario.dto';
import { Location } from '@angular/common';

/**
 * @description Componenente consultar y editar usuario, el cual contiene la logica para mostrar el comic a consultar o editar
 * 
 * @author Mary Yuliana Boyacá Aguilar<mary.boyaca@uptc.edu.co>
 */
@Component({
  selector: 'consultar-usuario',
  templateUrl: './consultar-usuario-component.html'
})
export class ConsultarUsuarioComponent implements OnInit {

 /**
   * @description formulario que representa los datos del usuario
   */
  public gestionarUsuarioForm: FormGroup;

  /**
   * @description  varaible que determina si se el componente fue llamado para editar
   */
  public editando: boolean;

  /**
   *@description metodo constructor del componente
   *
   */
  constructor(private router: Router,  private activatedRoute: ActivatedRoute,
                 private fb: FormBuilder, private location: Location, private gestionarUsuarioService: GestionarUsuarioService) { 
      this.gestionarUsuarioForm = this.fb.group({
        nombre: [null],
        fechaCreacion: [null],
        estado: [null],
        idPersona: [null]
      });
    }

  /**
   * metodo que inicializan los valores del usuario deacuerdo a la ruta activada
   */
  ngOnInit() {
    let usuario = this.activatedRoute.snapshot.params;
    this.gestionarUsuarioForm.controls.nombre.setValue(usuario.nombre);
    this.gestionarUsuarioForm.controls.fechaCreacion.setValue(usuario.fechaCreacion);
    this.gestionarUsuarioForm.controls.estado.setValue(usuario.Estado);
    this.gestionarUsuarioForm.controls.idPersona.setValue(usuario.idPersona);
    this.gestionarUsuarioForm.controls.nombre.disable();
    this.gestionarUsuarioForm.controls.fechaCreacion.disable();
    this.gestionarUsuarioForm.controls.estado.disable();
    this.gestionarUsuarioForm.controls.idPersona.disable();
  }

  /**
   * @description  metodo que recibe el usuario en especifico a editar
   *  e invoca el servicio REST que finalmente guarda el usuario editado
   */
  editar(){
    let usuario = this.activatedRoute.snapshot.params;
    let usuarioDTO = new UsuarioDTO();
    usuarioDTO.id = usuario.id;
    usuarioDTO.nombre = this.gestionarUsuarioForm.controls.nombre.value;
    usuarioDTO.fehaCreacion = usuario.fechaCreacion;
    usuarioDTO.estado = usuario.Estado;
    usuarioDTO.idPersona = usuario.idPersona;
    this.gestionarUsuarioService.modificarUsuario(usuarioDTO).subscribe();
    this.editando = false;
  }

    /**
   * @description metodo que indica que el componnete fue invocado para editar
   * y habilita el campo nombre 
   */
  habilitarFormularioParaEditar(){
    this.editando = true;
    this.gestionarUsuarioForm.controls.nombre.enable();
  }

    /**
   * @description metodo que permite volver a la pantalla anterior
   */
  volver(){
    this.location.back();
  }
}
