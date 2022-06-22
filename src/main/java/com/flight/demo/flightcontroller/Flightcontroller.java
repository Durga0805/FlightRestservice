package com.flight.demo.flightcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flight.demo.flightentity.Airline;
import com.flight.demo.service.FlightService;

@RestController
public class Flightcontroller {
  @Autowired(required=true)
 private FlightService flightservice;
  
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello World";
	}
	
	@GetMapping("/callanotherapp")
	public Integer getPriceData()
	{
		String uri ="http://localhost:8083/getdata";
		RestTemplate resttemplate = new RestTemplate();
		int price = resttemplate.getForObject(uri, Integer.class);
		return price;
		
		
	}
	
	@PostMapping("/addInfo")
	public void createFlight(@RequestBody Airline airline) {
		flightservice.saveFlight(airline);
}


	@PutMapping("/updateFlight")
	public void updateFlighInfo(@Validated @RequestBody Airline airline) {
		flightservice.updateFlighInfo(airline);
	}
	
	@DeleteMapping("/deleteFlight")
	public void deleteFlight(@RequestParam("id") Integer id) {
		flightservice.deleteFlight(id);
	}
	
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exception){
		Map<String, String> messages = new HashMap<String, String>();
		exception.getAllErrors().forEach(error->
		{
			String fieldName =((FieldError) error).getField();
			String errorMessage  =((FieldError) error).getDefaultMessage();
			messages.put(fieldName, errorMessage);
		});
		return messages;
	}
	
}
