package com.dvivanco.springboot.apirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	private String codigoOficina;
	
	@NotBlank
	@Size( max = 1)
	private String activo;
}
