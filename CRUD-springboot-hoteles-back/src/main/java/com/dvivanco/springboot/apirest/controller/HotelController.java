package com.dvivanco.springboot.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dvivanco.springboot.apirest.models.dto.HotelDTO;
import com.dvivanco.springboot.apirest.models.service.IHotelService;

@CrossOrigin( origins = {"http://localhost:4200"} )
@RestController
@RequestMapping( value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class HotelController {
	
	@Autowired
	private IHotelService hotelService;
	
	@GetMapping("/hoteles")
	public List<HotelDTO> getAllItems(){
		return hotelService.getAllItems();
	}
	
	@GetMapping("/hoteles/{id}")
	public HotelDTO getItemById(@PathVariable Long id) {
		return hotelService.getItemById(id);
	}
	
	@PostMapping("/hoteles")
	@ResponseStatus(HttpStatus.CREATED)
	public HotelDTO saveItem(@RequestBody HotelDTO hotel ) {
		return hotelService.saveItem(hotel);
	}

	@PutMapping("/hoteles/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public HotelDTO updateItemById(@PathVariable Long id, @RequestBody HotelDTO hotel) {
		return hotelService.updateItemById(id, hotel);	
	}
	
	@DeleteMapping("/hoteles/{id}")
	public ResponseEntity<HotelDTO> deleteItemById(@PathVariable Long id) {
		return hotelService.delete(id);	
	}
}
