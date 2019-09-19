package com.dvivanco.springboot.apirest.models.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dvivanco.springboot.apirest.models.dto.HotelDTO;

public interface IHotelService {
	
	public List<HotelDTO> getAllItems();
	
	public HotelDTO getItemById(Long id);

	public HotelDTO saveItem(HotelDTO hotel);
	
	public HotelDTO updateItemById(Long id, HotelDTO hotel);
	
	public ResponseEntity<HotelDTO> delete(Long id);
}
