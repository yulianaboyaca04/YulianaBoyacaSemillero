import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AbstractService } from '../services/template.service';
import { PersonaDTO } from '../dto/persona.dto';
import { UsuarioDTO } from '../dto/usuario.dto';

/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar usuario de las personas 
 * @author Mary Yuliana Boyacá Aguilar <mary.boyaca@uptc.edu.co>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarUsuarioService extends AbstractService {

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient: HttpClient) {
    super(injector);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST que permite consultar personas
   */
  public consultarPersonas(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarPersonas');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST que permite consultar una persona por el id
   * @param idPersona 
   */
  public consultarPersona(idPersona: number): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarPersona?idPersona=' + idPersona);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST que permite consultar todos los usuarios en el sistema
   */
  public consultarUsuarios(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarUsuarios');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST permite consultar un usuario en especifico
   * @param idUsuario identificador del usuario a consultar
   */
  public consultarUsuario(idUsuario: number): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarUsuario?idUsuario=' + idUsuario);
  }

  /**
   *  @description Metodo encargado de invocar el servicio REST que crea un usuario de acuerdo a una persona 
   * @param personaDTO
   */
  public crearUsuario(personaDTO: PersonaDTO) {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/crearUsuario', personaDTO);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST que permite modificar un usuario
   * @param usuarioDTO 
   */
  public modificarUsuario(usuarioDTO: UsuarioDTO) {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/modificarUsuario', { 'usuarioDTOModificado': usuarioDTO });
  }

  /**
   * @description Metodo encargado de invocar el servicio REST que permite eliminar un usuario, cambiando su estado de activo a inactivo
   * @param idUsuario
   */
  public eliminarUsuario(idUsuario: number) {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/eliminarUsuario?idUsuario=' + idUsuario);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST que valida el estado de un usuario de acuerdo 
   * @param idUsuario 
   */
  public validarUsuario(idUsuario: number) {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/validarUsuario?idUsuario=' + idUsuario);
  }
}