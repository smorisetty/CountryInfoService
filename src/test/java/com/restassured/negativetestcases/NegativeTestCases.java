package com.restassured.negativetestcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class NegativeTestCases {
	 @Test
	    public void testStatusNotFoundCountryAPI() throws IOException {
		 String name = "$$$$$";
		 
	        RestAssured.baseURI = "http://localhost:9001/CountryInfo/countryname";
	 
	        Response response = null;
	 
	        try {
	            response = RestAssured.given()
	                                  .pathParam("name", name)
	                                  .when()
	                                  .get("/{name}");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        int StatusCode = response.getStatusCode();
	        System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	        if (StatusCode == 200) {
	        	 System.out.println("Does Reponse contains 'capital'? :" + response.asString().contains("capital"));
	        
	        }
	        else if (StatusCode == 500){
	        	System.out.println("Error code in response"+response.asString().contains("status"));
	        	System.out.println("Not Found error message "+response.asString().contains("message"));
	        	
	        }
	    }
	 
	 
	 
	 @Test
	    public void testStatusNotFoundCountryCodeAPI() throws IOException {
		 String code = "$$$$$";
		 
	        RestAssured.baseURI = "http://localhost:9001/CountryInfo/countrycode";
	 
	        Response response = null;
	 
	        try {
	            response = RestAssured.given()
	                                  .pathParam("name", code)
	                                  .when()
	                                  .get("/{name}");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        int StatusCode = response.getStatusCode();
	        System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	        if (StatusCode == 200) {
	        	 System.out.println("Does Reponse contains 'alpha2Code'? :" + response.asString().contains("alpha2Code"));
	        	 System.out.println("Does Reponse contains 'alpha3Code'? :" + response.asString().contains("alpha2Code"));
	        }
	        else if (StatusCode == 500){
	        	System.out.println("Error code in response"+response.asString().contains("status"));
	        	System.out.println("Not Found error message "+response.asString().contains("message"));
	        	
	        }	        
	      
	        }



	}
