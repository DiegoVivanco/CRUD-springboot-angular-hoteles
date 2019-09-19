package com.dvivanco.springboot.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.dvivanco.springboot.apirest.models.dto.HotelDTO;

import lombok.Data;

@Entity
@Data
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size( max = 50)
	private String nombre;
	
	@Size( max = 50)
	private String tipo;
	
	@Size( max = 50)
	private String cadena;
	
	@Size( max = 50)
	private String zona;
	
	@NotBlank
	@Size( max = 15)
	private String codigoficina;
	
	@NotBlank
	@Size( max = 1)
	private String activo;
	
	public HotelDTO entityToHotelDTO() {
		
		HotelDTO dto = new HotelDTO();
		 
		dto.setId(this.id);
		dto.setNombre(this.nombre);
		dto.setTipo(this.tipo);
		dto.setCadena(this.cadena);
		dto.setZona(this.zona);
		dto.setCodigoficina(this.codigoficina);
		dto.setActivo(this.activo);
		 
		return dto;
	}
}
