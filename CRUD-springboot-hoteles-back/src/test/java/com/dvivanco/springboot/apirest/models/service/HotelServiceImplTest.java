package com.dvivanco.springboot.apirest.models.service;

import com.dvivanco.springboot.apirest.controller.HotelController;
import com.dvivanco.springboot.apirest.models.dto.HotelDTO;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HotelServiceImplTest {
    @InjectMocks
    private HotelController hotelController;

    @Autowired
    private HotelServiceImpl hotelService;

    private HotelDTO newHotelDTO = HotelDTO.builder()
            .id(1L)
            .nombre("Hotel test 1")
            .tipo("Hotel 5 estrellas")
            .cadena("Grupotel")
            .zona("Grupotel")
            .codigoficina("HPI")
            .activo("S")
            .build();

    @Test
    public void testFindAllHotels() {
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        hotelDTOList.add(newHotelDTO);

        List<HotelDTO> hotelDTOListResult = hotelService.getAllItems();
        assertEquals(hotelDTOListResult.get(0), hotelDTOList.get(0));
    }

    @Test
    public void testFindOneHotelById() {
        HotelDTO hotelDTOResult = hotelService.getItemById(1L);
        assertEquals(hotelDTOResult.getId(), newHotelDTO.getId() );
    }

    @Test
    public void testSaveHotelAndFindIt() {
        HotelDTO hotelDTOResult = hotelService.saveItem(newHotelDTO);
        assertEquals(hotelDTOResult.getCodigoficina(), newHotelDTO.getCodigoficina() );
    }

    @Test
    public void testUpdateItemById() {
        HotelDTO hotelDTOResult = hotelService.updateItemById(1L, newHotelDTO);
        assertEquals(hotelDTOResult.getNombre(), newHotelDTO.getNombre());
    }

    @Test
    public void testDeleteItemById() {
        hotelService.delete(3L);
        List<HotelDTO> hotelDTOListResult = hotelService.getAllItems();
        assertEquals(hotelDTOListResult.size(), 2);
    }
}