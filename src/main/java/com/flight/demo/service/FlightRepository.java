package com.flight.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.demo.flightentity.Airline;


public interface FlightRepository extends JpaRepository<Airline, Integer> {

}
