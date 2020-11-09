package com.sdettest.restservice.springboot.app.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sdettest.restservice.springboot.app.model.CountryResponse;

@RestController
@RequestMapping("/CountryInfo")
public class CountryNameController {

	@Autowired
	private RestTemplate restTemplate;
	public static String URL;

	@GetMapping("/countryname/{name}")
	public List<CountryResponse> getCapitalOnName(@PathVariable("name") String name) {
		System.out.println("Print name :" + name);
		URL = "https://restcountries.eu/rest/v2/name/{name}";
		ResponseEntity<CountryResponse[]> response = restTemplate.getForEntity(URL, CountryResponse[].class, name);
		System.out.println("Response from RestEndPoint" + response.getBody());
		System.out.println("Status code value: " + response.getStatusCodeValue());
		System.out.println("HTTP Header 'ContentType': " + response.getHeaders().getContentType());
		if (response.getStatusCode() == HttpStatus.OK) {
			for (CountryResponse countryresponse : response.getBody()) {
				System.out.println(countryresponse.getName() + "" + countryresponse.getCapital());
			}
		}
		return response.getBody() != null ? Arrays.asList(response.getBody()) : Collections.emptyList();

	}

}
