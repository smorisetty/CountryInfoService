package com.sdettest.restservice.springboot.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CountryResponse {
   
	private String name;
	
	private String capital;
	
	public CountryResponse() {
		
	}
	
   public CountryResponse(String name, String capital)
   { super(); 
     this.name = name; 
     this.capital = capital;
        }
 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
}
