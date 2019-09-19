export class Hotel {
    id: number;
    nombre: string;
    tipo: string;
    cadena: string;
    zona: string;
    codigoOficina: string;
    activo: string;

    constructor(nombre: string, codigoOficina: string, activo: string) {
        this.nombre = nombre;
        this.codigoOficina = codigoOficina;
        this.activo = activo;
    }
}
