package com.sdettest.restservice.springboot.app.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sdettest.restservice.springboot.app.model.CountryCodeResponse;

@RestController
@RequestMapping("/CountryInfo")
public class CountryCodeController {

	@Autowired
	private RestTemplate restTemplate;
	public static String URL;

	@GetMapping("countrycode/{code}")
	public List<CountryCodeResponse> getCapitalOnName(@PathVariable("code") String code) {
		System.out.println("Print CountryCode :" + code);
		URL = "https://restcountries.eu/rest/v2/alpha/{code}";
		ResponseEntity<CountryCodeResponse> response = restTemplate.getForEntity(URL, CountryCodeResponse.class, code);
		System.out.println("Response from RestEndPoint" + response.getBody());
		System.out.println("Status code value: " + response.getStatusCodeValue());
		System.out.println("HTTP Header 'ContentType': " + response.getHeaders().getContentType());
		if (response.getStatusCode() == HttpStatus.OK) {

			System.out.println(response.getBody().getName() + " " + response.getBody().getCapital() + " "
					+ response.getBody().getAlpha3Code() + "" + response.getBody().getCapital());
		}
		return response.getBody() != null ? Arrays.asList(response.getBody()) : Collections.emptyList();

	}

}
