package com.flight.demo.flightentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="FlightTable")
public class Airline {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "pls provide some data")
	private String flightName;
	private String airlineName;
	private Integer price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Airline(Integer id, @NotBlank(message = "pls provide some data") String flightName, String airlineName,
			Integer price) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.airlineName = airlineName;
		this.price = price;
	}
	public Airline() {
		super();
	}
	
}
