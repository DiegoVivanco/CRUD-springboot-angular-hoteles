import { Injectable } from '@angular/core';
import { SelectItem } from 'primeng/primeng';

@Injectable()
export class CommonStaticService {
  constructor() {}

  /**
   * Retorna una lista seleccionable de tipos de hoteles
   * @returns listHotelOptions, lista seleccionable de tipos de hoteles
   */
  public static get GET_LISTA_HOTEL_OPTIONS(): SelectItem[] {
    const listHotelOptions = [
      { label: 'Selecciona un tipo de hotel', value: null },
      { label: 'Hotel 5 estrellas', value: 'Hotel 5 estrellas' },
      { label: 'Hotel 4 estrellas', value: 'Hotel 4 estrellas' },
      { label: 'Aparthotel', value: 'Aparthotel' },
      { label: 'Hostal', value: 'Hostal' },
      { label: 'Agroturismo', value: 'Agroturismo' }
    ];
    return listHotelOptions;
  }

  /**
   * Retorna una lista seleccioable de Si o No
   * @returns rs retorna una lista seleccionable con Sí y No
   */
  public static get GET_LISTA_SINO(): SelectItem[] {
    return [{ label: 'Sí', value: 'S' }, { label: 'No', value: 'N' }];
  }

  /**
   * Retorna una lista para la definición de los campos de las columnas de la tabla hoteles
   * @returns cols retorna una lista para la definición de los campos de las columnas de la tabla hoteles
   */
  public static get GET_COLUMNS_HOTELS(): any[] {
    const cols = [
      { field: 'id', header: 'Identificador' },
      { field: 'nombre', header: 'Nombre' },
      { field: 'tipo', header: 'Tipo' },
      { field: 'cadena', header: 'Cadena' },
      { field: 'zona', header: 'Zona' },
      { field: 'codigoficina', header: 'Código Oficina' },
      { field: 'activo', header: 'Activo' }
    ];

    return cols;
  }
}
