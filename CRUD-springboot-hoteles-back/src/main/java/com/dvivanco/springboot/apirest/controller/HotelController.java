package com.dvivanco.springboot.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvivanco.springboot.apirest.dao.HotelRepository;
import com.dvivanco.springboot.apirest.exception.EntityNotFoundException;
import com.dvivanco.springboot.apirest.model.Hotel;

@CrossOrigin( origins = {"http://localhost:4200"} )
@RestController
@RequestMapping("/api")
public class HotelController {
	
	@Autowired
	private HotelRepository hotelrepository;
	
	@PostMapping("/saveHotel")
	public Hotel saveHotel(@RequestBody Hotel hotel ) {
		hotelrepository.save(hotel);
		return hotelrepository.findById(hotel.getId()).orElseThrow(() -> new EntityNotFoundException("Hotel", "id", hotel.getId()));
	}
	
	@GetMapping("/getAllHotels")
	public List<Hotel> getAllHotels(){
		return hotelrepository.findAll();
	}
	
	@GetMapping("/getHotel/{id}")
	public Hotel getHotelById(@PathVariable Long id) {
		return hotelrepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel", "id", id));
	}
	
	@PutMapping("/updateHotel/{id}")
	public Hotel updateHotelById(@PathVariable Long id, @RequestBody Hotel hotel) {
		
		Hotel hotelFound = hotelrepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel", "id", id));;
		
		hotelFound.setNombre(hotel.getNombre());
		hotelFound.setTipo(hotel.getTipo());
		hotelFound.setCadena(hotel.getCadena());
		hotelFound.setZona(hotel.getCadena());
		hotelFound.setCodigoOficina(hotel.getCodigoOficina());
		hotelFound.setActivo(hotel.getActivo());
		
		Hotel hotelUpdated = hotelrepository.save(hotelFound);

		return hotelUpdated;	
	}
	
	@DeleteMapping("/deleteHotel/{id}")
	public ResponseEntity<?> deleteHotelById(@PathVariable Long id) {
		
		Hotel hotelFound = hotelrepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel", "id", id));;
		hotelrepository.delete(hotelFound);

		return ResponseEntity.ok().build();	
	}
}
