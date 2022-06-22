package com.flight.demo.service;

import com.flight.demo.flightentity.Airline;

public interface FlightService {
	
	public void saveFlight(Airline airline);
	public void deleteFlight(int id);
	public void updateFlighInfo(Airline airline);

}
