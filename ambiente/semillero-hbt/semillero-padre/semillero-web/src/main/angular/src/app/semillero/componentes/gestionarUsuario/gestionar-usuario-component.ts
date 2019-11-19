import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PersonaDTO } from '../../dto/persona.dto';
import { UsuarioDTO } from '../../dto/usuario.dto';
import { Router } from '@angular/router';
import { GestionarUsuarioService } from '../../services/gestionar.usuario.service';

@Component({
  selector: 'gestionar-usuario',
  templateUrl: './gestionar-usuario-component.html',
  styleUrls: ['./gestionar-usuario-component.css']
})
export class GestionarUsuarioComponent implements OnInit {

  /**
   * Atributo que contiene los controles del formulario
   */
  public gestionarUsuarioForm: FormGroup;

  /**
   * Atributo que contendra la informacion de la persona
   */
  public persona: PersonaDTO;

  /**
   * Atributo que contendra la informacion del usuario de la persona
   */
  public usuario: UsuarioDTO;

  /**
   * Atributo que contendra la lista de usuarios creados
   */
  public listaUsuarios: Array<UsuarioDTO>;

  /**
 * Atributo que indica si se envio a validar el formulario
 */
  public submitted: boolean;

  /**
   * @description Este es el constructor del componente GestionarComicComponent
   * @author Mary Yuliana Boyacá Aguilar <mary.boyaca@uptc.edu.co>
   */
  constructor(private fb: FormBuilder,
    private router: Router, private gestionarUsuarioService: GestionarUsuarioService) {
    this.gestionarUsuarioForm = this.fb.group({
      nombre: [null, Validators.required],
      numIdentificacion: [null, Validators.required]
    });
  }

  /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Mary Yuliana Boyacá Aguilar <mary.boyaca@uptc.edu.co>
     */
  ngOnInit() {
    this.usuario = new UsuarioDTO();
    this.persona = new PersonaDTO();
    this.listaUsuarios = new Array<UsuarioDTO>();
  }

  /**
     * @description Metodo que se encarga de crear una persona con su respectivo usuario
     * @author Mary Yuliana Boyacá Aguilar <mary.boyaca@uptc.edu.co>
  */
  crearUsuarioDePersona(): void {
    this.submitted = true;
    this.persona = new PersonaDTO();
    this.persona.nombre = this.gestionarUsuarioForm.controls.nombre.value;
    this.persona.numIdentificacion = this.gestionarUsuarioForm.controls.numIdentificacion.value;
    this.gestionarUsuarioService.crearUsuario(this.persona).subscribe(data => {
      this.consultarComics();
      this.limpiarFormulario();
    }, error => {
      console.log(error);
    });
    
  }

  /**
   * @description Metodo encargado de consultar los usuarios existentes
   * @author Mary Yuliana Boyacá Aguilar <mary.boyaca@uptc.edu.co>
   */
  public consultarComics(): void {
    this.gestionarUsuarioService.consultarUsuarios().subscribe(listaUsuarios => {
      this.listaUsuarios = listaUsuarios;
    }, error => {
      console.log(error);
    });
  }

  /**
   * metodo que limpia el formulario
   */
  private limpiarFormulario(): void {
    this.submitted = false;
    this.gestionarUsuarioForm.controls.nombre.setValue(null);
    this.gestionarUsuarioForm.controls.numIdentificacion.setValue(null);
  }
}
