export class Hotel {
    id: number;
    nombre: string;
    tipo: string;
    cadena: string;
    zona: string;
    codigoficina: string;
    activo: string;

    constructor(nombre: string, codigoficina: string, activo: string) {
        this.nombre = nombre;
        this.codigoficina = codigoficina;
        this.activo = activo;
    }
}
