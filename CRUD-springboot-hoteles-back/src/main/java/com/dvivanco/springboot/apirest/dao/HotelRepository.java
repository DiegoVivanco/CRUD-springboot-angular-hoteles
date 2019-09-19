package com.dvivanco.springboot.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvivanco.springboot.apirest.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
