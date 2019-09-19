import { HotelService } from '../services/hotel.service';
import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/hotel/models/hotelmodel';
import { SelectItem } from 'primeng/components/common/selectitem';
import { MessageService } from 'primeng/components/common/messageservice';
import { CommonStaticService } from '../services/common.static.service';

/**
 * INICIO CONSTANSTES PARA EL USO DE LOS MENSAJES DE OPERACIONES DEL CRUD
 */
const ERROR_MSG = 'Error al realizar la operación.';
const ERROR_GETLIST = 'Error interno al obtener el listado de datos.';
const INFO_GETLIST = 'La tabla no contiene datos, puede crear hoteles mediante el botón "Añadir nuevo Hotel"';
const SUCESS_MSG = 'Operación realizada correctamente';
const SUMMARY_MSG = 'Mensaje de Operación';
const TYPE_MSG_INFO = 'INFO';
const TYPE_MSG_ERROR = 'ERROR';
const TYPE_MSG_SUCESS = 'SUCESS';
/**
 * FIN CONSTANSTES PARA EL USO DE LOS MENSAJES DE OPERACIONES DEL CRUD
 */

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css'],
  providers: [MessageService]
})
export class HotelComponent implements OnInit {
  // Uso Tabla Primeng
  hotels: Hotel[] = [];
  hotel: Hotel;
  selectedHotel: any;
  cols: any[];

  // Control de Operaciones
  displayDialog: boolean;
  newHotel: boolean;

  // Uso Dropdown del formulario
  tipoHoteles: SelectItem[];
  opcionesActivo: SelectItem[];

  constructor(private hotelService: HotelService, private messageService: MessageService) {
    this.hotel = this.initHotelObject();
    this.tipoHoteles = CommonStaticService.GET_LISTA_HOTEL_OPTIONS;
    this.opcionesActivo = CommonStaticService.GET_LISTA_SINO;
  }

  ngOnInit() {
    this.getHotelsList();
    this.cols = CommonStaticService.GET_COLUMNS_HOTELS;
  }

  /**
   * Muestra el panel para añadir/editar hoteles
   */
  showDialogToAdd() {
    this.newHotel = true;
    this.hotel = this.initHotelObject();
    this.displayDialog = true;
  }

  /**
   * llama al servicio getHotels(listar hoteles) para obtener una lista de hoteles y visualizarla en la tabla
   */
  getHotelsList() {
    this.hotelService.getHotels().subscribe(
      (data: Hotel[]) => {
        if (data.length > 0) {
          this.hotels = data;
        } else {
          this.generarMensajesCRUD(TYPE_MSG_INFO, INFO_GETLIST);
        }
      },
      err => {
        this.generarMensajesCRUD(TYPE_MSG_ERROR, ERROR_GETLIST);
        console.log('getHotelList(). Error al obtener datos: ' + JSON.stringify(err));
      }
    );
  }

  /**
   * llama al servicio createHotel(crear un nuevo hotel) o updateHotel(modificar un hotel).
   * la llamada al cualquier servicio se controla mediante una variable booleana
   */
  save() {
    if (this.newHotel) {
      this.hotelService.createHotel(this.hotel).subscribe(
        data => {
          if (data) {
            this.hotels.push(data);
            this.generarMensajesCRUD(TYPE_MSG_SUCESS);
          } else {
            this.generarMensajesCRUD(TYPE_MSG_ERROR);
          }
        },
        err => {
          this.generarMensajesCRUD(TYPE_MSG_ERROR);
          console.log('save(). Error insertando datos: ' + JSON.stringify(err));
        }
      );
    } else {
      this.hotelService.updateHotel(this.hotel).subscribe(
        data => {
          if (data) {
            this.hotels[this.hotels.indexOf(this.selectedHotel)] = data;
            this.generarMensajesCRUD(TYPE_MSG_SUCESS);
          } else {
            this.generarMensajesCRUD(TYPE_MSG_ERROR);
          }
        },
        err => {
          this.generarMensajesCRUD(TYPE_MSG_ERROR);
          console.log('save(). Error actualizando datos: ' + JSON.stringify(err));
        }
      );
    }
    this.hotel = this.initHotelObject();
    this.displayDialog = false;
  }

  /**
   * llama al servicio deleteHotel(borrar un hotel)
   */
  delete() {
    this.hotelService.deleteHotel(this.hotel.id).subscribe(
      data => {
        const index = this.hotels.indexOf(this.selectedHotel);
        if (index >= 0) {
          this.hotels.splice(index, 1);
        }
        this.generarMensajesCRUD(TYPE_MSG_SUCESS);
      },
      err => {
        this.generarMensajesCRUD(TYPE_MSG_ERROR);
        console.log('delete(). Error borrando datos: ' + JSON.stringify(err));
      },
      () => {
        this.hotel = this.initHotelObject();
        this.displayDialog = false;
      }
    );
  }

  /**
   * llama al servicio getHotel(obtener un hotel) pasandole como parámetro el identificador del hotel.
   * @param event información de la fila seleccionada
   */
  onRowSelect(event) {
    this.newHotel = false;
    this.hotelService.getHotel(event.data.id).subscribe(
      data => {
        if (data) {
          this.hotel = data;
        } else {
          this.generarMensajesCRUD(TYPE_MSG_ERROR);
        }
      },
      err => {
        this.generarMensajesCRUD(TYPE_MSG_ERROR);
        console.log('onRowSelect(). Error al obtener datos: ' + JSON.stringify(err));
      }
    );

    this.displayDialog = true;
  }

  /**
   * Retorna un objecto hotel inicial, se rellenan los campos obligatorios de la Entidad definido en el modelo del back.
   * @returns Hotel regresa un hotel inicializado
   */
  initHotelObject(): Hotel {
    return new Hotel('', '', 'S');
  }

  /**
   * @param tipoMsg tipo de mensaje, que es controlado en un swith para visualizar un mensaje en concreto
   * @param msg mensaje opcional, si este es pasado como parametro se rellena en la generación del mensaje
   */
  generarMensajesCRUD(tipoMsg: string, msg?: string) {
    switch (tipoMsg) {
      case TYPE_MSG_SUCESS:
        const detailMsgSucess = msg ? msg : SUCESS_MSG;
        this.messageService.add({ severity: 'success', summary: SUMMARY_MSG, detail: detailMsgSucess });
        break;
      case TYPE_MSG_ERROR:
        const detailMsgError = msg ? msg : ERROR_MSG;
        this.messageService.add({ severity: 'error', summary: SUMMARY_MSG, detail: detailMsgError });
        break;
      case TYPE_MSG_INFO:
        const detailMsgInfo = msg ? msg : SUCESS_MSG;
        this.messageService.add({ severity: 'info', summary: SUMMARY_MSG, detail: detailMsgInfo, life: 4000 });
        break;
    }
  }
}
