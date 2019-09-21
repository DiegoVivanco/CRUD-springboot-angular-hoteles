package com.dvivanco.springboot.apirest.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvivanco.springboot.apirest.exception.EntityNotFoundException;
import com.dvivanco.springboot.apirest.models.dao.IHotelDao;
import com.dvivanco.springboot.apirest.models.dto.HotelDTO;
import com.dvivanco.springboot.apirest.models.entity.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelDao hotelDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<HotelDTO> getAllItems() {
		
		List<HotelDTO> hotelsDTO = new ArrayList<>();
		List<Hotel> hotels = hotelDao.findAll();
		
		hotelsDTO.addAll(hotels.stream().map(Hotel::entityToHotelDTO).collect(Collectors.toList()));
		return hotelsDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public HotelDTO getItemById(Long id) {
		Hotel hotelFound = hotelDao.findById(id).orElseThrow(() -> new EntityNotFoundException(Hotel.class.toString(), "id", id));
		return hotelFound.entityToHotelDTO();
	}

	@Override
	@Transactional
	public HotelDTO saveItem(HotelDTO hotel) {
		Hotel hotelSaved = hotelDao.save(hotel.dtoToEntityHotel());
		return hotelSaved.entityToHotelDTO();
	}

	@Override
	@Transactional
	public HotelDTO updateItemById(Long id, HotelDTO hotel) {
		Hotel hotelFound = hotelDao.findById(id).orElseThrow(() -> new EntityNotFoundException(Hotel.class.toString(), "id", id));
		
		hotelFound.setNombre(hotel.getNombre());
		hotelFound.setTipo(hotel.getTipo());
		hotelFound.setCadena(hotel.getCadena());
		hotelFound.setZona(hotel.getCadena());
		hotelFound.setCodigoficina(hotel.getCodigoficina());
		hotelFound.setActivo(hotel.getActivo());

		return hotelDao.save(hotelFound).entityToHotelDTO();
	}

	@Override
	@Transactional
	public ResponseEntity<HotelDTO> delete(Long id) {
		Hotel hotelFound = hotelDao.findById(id).orElseThrow(() -> new EntityNotFoundException(Hotel.class.toString(), "id", id));
		hotelDao.delete(hotelFound);

		return ResponseEntity.ok().build();	
	}

}
