package com.dvivanco.springboot.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvivanco.springboot.apirest.models.entity.Hotel;

public interface IHotelDao extends JpaRepository<Hotel, Long> {

}
