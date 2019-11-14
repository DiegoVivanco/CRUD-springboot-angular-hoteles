package com.dvivanco.springboot.apirest.models.dto;

import com.dvivanco.springboot.apirest.models.entity.Hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDTO {
	
	private Long id;
	private String nombre;
	private String tipo;
	private String cadena;
	private String zona;
	private String codigoficina;
	private String activo;
	
	
	public Hotel dtoToEntityHotel() {
		
		Hotel hotelEntity = new Hotel();
		 
		hotelEntity.setId(this.id);
		hotelEntity.setNombre(this.nombre);
		hotelEntity.setTipo(this.tipo);
		hotelEntity.setCadena(this.cadena);
		hotelEntity.setZona(this.zona);
		hotelEntity.setCodigoficina(this.codigoficina);
		hotelEntity.setActivo(this.activo);
		 
		return hotelEntity;
	}
}
