import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic.dto';
/**
 * @description Componente el cual crea persona
 * 
 * @author Yuliana Boyacá <mary.boyaca@uptc.edu.co>
 */
@Component({
    selector: 'crear-persona',
    templateUrl: './crear-persona-component.html'
})
export class CrearPersonaComponent implements OnInit {

    public comicDTO: ComicDTO;
    public listaApellidos: Array<any> = new Array<any>();
    ngOnInit(): void {
        this.inicializarComponente();

        let miMapa: Map<string, string>;
        miMapa = new Map<string, string>();

        miMapa.set("1", "semillero");
        miMapa.get("1");
        let fecha = new Date();

        let miVariable: any = {
            id: 1,
            nombre: "pedro",
            apello: "aguirre"
        }

        miVariable.genero = "Femenino";
        delete miVariable.genero;

        this.listaApellidos.push(miVariable);
        for (let i = 0; i < this.listaApellidos.length; i++) {
            const element = this.listaApellidos[i];
            console.log(element);
        }

        console.log(fecha);

        //tipos de recorrer uan lista
        let lista = this.listaApellidos;


    }
    public inicializarComponente(): Array<string> {
        let retorno: any;
        let objeto = undefined;
        if (objeto !== null) {
            console.log("No es nulo")
        } else {
            console.log("Si es nulo");
        }

        console.log(1 == 1);
        console.log("1" == 1);
        console.log(1 === 1);
        console.log('1' === 1);

        this.comicDTO = new ComicDTO();
        this.comicDTO.autores = "Pablito";
        this.comicDTO.fechaVenta = new Date();
        console.log(this.comicDTO.autores);

        return retorno;
    }
}