package com.flight.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.demo.flightentity.Airline;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepository repo;
	public void saveFlight(Airline airline) {
		repo.save(airline);
		//return airline.getId();
		
	}
	@Override
	public void deleteFlight(int id) {
		repo.deleteById(id);
		
	}
	@Override
	public void updateFlighInfo(Airline airline) {
		repo.save(airline);
	
	}

}
